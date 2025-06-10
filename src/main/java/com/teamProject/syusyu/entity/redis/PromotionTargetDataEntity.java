package com.teamProject.syusyu.entity.redis;

import com.teamProject.syusyu.domain.promotion.PromotionTargetDto;
import com.teamProject.syusyu.util.RedisKeySet;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Getter
@ToString
@RedisHash(value = "promotionInfo", timeToLive = 60 * 60 * 3) // 3시간
public class PromotionTargetDataEntity {
    @Id
    private String id;
    private final String promotionName;
    private final Boolean isTarget;

    @Builder
    private PromotionTargetDataEntity(String promotionCode, String hashCi, String promotionName, Boolean isTarget) {
        this.id = RedisKeySet.promotionTarget(promotionCode, hashCi);
        this.promotionName = promotionName;
        this.isTarget = isTarget;
    }

    public static PromotionTargetDataEntity from(PromotionTargetDto dto) {
        return PromotionTargetDataEntity.builder()
            .promotionCode(dto.promotionCode())
            .hashCi(dto.hashCi())
            .promotionName(dto.promotionName())
            .isTarget(dto.isTarget())
            .build();
    }

    public static PromotionTargetDataEntity of(PromotionTargetDto dto, boolean isTarget) {
        return PromotionTargetDataEntity.builder()
            .promotionCode(dto.promotionCode())
            .hashCi(dto.hashCi())
            .promotionName(dto.promotionName())
            .isTarget(isTarget)
            .build();
    }

    public PromotionTargetDto toDto(String promotionCode, String hashCi) {
        return PromotionTargetDto.builder()
            .promotionCode(promotionCode)
            .promotionName(promotionName)
            .hashCi(hashCi)
            .isTarget(isTarget)
            .build();
    }
} 