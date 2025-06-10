package com.teamProject.syusyu.service.promotion.impl;

import com.teamProject.syusyu.dao.promotion.PromotionReader;
import com.teamProject.syusyu.dao.promotion.PromotionTargetReader;
import com.teamProject.syusyu.domain.promotion.PromotionTargetDto;
import com.teamProject.syusyu.service.promotion.RedisPromotionService;
import com.teamProject.syusyu.service.promotion.PromotionBusinessService;
import com.teamProject.syusyu.config.properties.PromotionProperties;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@RequiredArgsConstructor
@Service
public class PromotionBusinessServiceImpl implements PromotionBusinessService {

    private final PromotionReader promotionReader;
    private final PromotionTargetReader promotionTargetReader;
    private final RedisPromotionService redisPromotionService;
    private final PromotionProperties promotionProperties;

    @Override
    @Cacheable(cacheNames = "PROMOTION_TARGET", cacheManager = "cacheManager",
        key = "#promotionCode + ':' + #hashCi",
        unless = "#result == null || #result.isTarget()"
    )
    public Optional<PromotionTargetDto> getPromotionTargetData(String promotionCode, String hashCi) {
        validatePromotionRequest(promotionCode, hashCi);

        log.debug("프로모션 대상자 조회 시작 - promotionCode: {}, hashCi: {}", promotionCode, hashCi);

        log.debug("로컬 캐시 MISS - Redis 조회 시작");
        Optional<PromotionTargetDto> redisResult = redisPromotionService.findPromotionTarget(promotionCode, hashCi);

        if (redisResult.isPresent()) {
            log.debug("Redis 캐시 HIT - isTarget: {}", redisResult.get().isTarget());
            return redisResult;
        }

        log.debug("Redis 캐시 MISS - DB 조회 시작");
        Optional<PromotionTargetDto> dbResult = promotionTargetReader.findByPromotionCodeAndHashCi(promotionCode, hashCi);

        dbResult.ifPresentOrElse(
            dto -> {
                log.debug("DB 조회 성공 - 회원 데이터 Redis 저장, isTarget: {}", dto.isTarget());
                redisPromotionService.savePromotionTarget(dto);
            },
            () -> {
                log.debug("DB 조회 결과 없음 - 비회원으로 판단하여 isTarget(true) Redis 저장");
                redisPromotionService.savePromotionTarget(
                    PromotionTargetDto.of(promotionCode, promotionProperties.getFirstPayment().getName(), hashCi, true)
                );
            }
        );

        return dbResult;
    }

    private void validatePromotionRequest(String promotionCode, String hashCi) {
        if (ObjectUtils.isEmpty(promotionCode) || ObjectUtils.isEmpty(hashCi)) {
            log.error("promotionCode: {}, hashCi: {} is null", promotionCode, hashCi);
            throw new RuntimeException("Invalid promotion request parameters");
        }

        if (promotionReader.findByPromotionCode(promotionCode).isEmpty()) {
            log.warn("존재하지 않는 프로모션 코드입니다: {}", promotionCode);
            throw new RuntimeException("Invalid promotion code");
        }
    }
} 