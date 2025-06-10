package com.teamProject.syusyu.service.promotion.impl;

import com.teamProject.syusyu.domain.promotion.PromotionTargetDto;
import com.teamProject.syusyu.service.promotion.RedisPromotionService;
import com.teamProject.syusyu.entity.redis.PromotionTargetDataEntity;
import com.teamProject.syusyu.repository.redis.PromotionTargetRedisRepository;
import com.teamProject.syusyu.util.RedisKeySet;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisPromotionServiceImpl implements RedisPromotionService {

    private final PromotionTargetRedisRepository promotionTargetRedisRepository;

    @Override
    public void savePromotionTarget(PromotionTargetDto promotionTargetDto) {
        if (!isValidPromotionTargetDto(promotionTargetDto)) {
            return;
        }
        promotionTargetRedisRepository.save(PromotionTargetDataEntity.from(promotionTargetDto));
    }

    @Override
    public Optional<PromotionTargetDto> findPromotionTarget(String promotionCode, String hashCi) {
        if (Objects.isNull(promotionCode) || Objects.isNull(hashCi)) {
            return Optional.empty();
        }
        return promotionTargetRedisRepository.findById(RedisKeySet.promotionTarget(promotionCode, hashCi))
                .map(entity -> entity.toDto(promotionCode, hashCi));
    }

    @Override
    public void usePromotion(PromotionTargetDto promotionTargetDto) {
        if (!isValidPromotionTargetDto(promotionTargetDto)) {
            return;
        }
        promotionTargetRedisRepository.save(PromotionTargetDataEntity.of(promotionTargetDto, false));
    }

    private boolean isValidPromotionTargetDto(PromotionTargetDto promotionTargetDto) {
        if (Objects.isNull(promotionTargetDto) ||
            ObjectUtils.isEmpty(promotionTargetDto.promotionCode()) ||
            ObjectUtils.isEmpty(promotionTargetDto.hashCi()) ||
            ObjectUtils.isEmpty(promotionTargetDto.promotionName()) ||
            Objects.isNull(promotionTargetDto.isTarget())) {

            log.error("PromotionTargetDto 필수값이 비어있습니다. {}", promotionTargetDto);
            return false;
        }
        return true;
    }
} 