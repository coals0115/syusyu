package com.teamProject.syusyu.domain.promotion;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record PromotionTargetDto(
    Long promotionTargetId,
    Long promotionId,
    String promotionCode,
    String promotionName,
    String hashCi,
    Boolean isTarget,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

    public boolean isNotTarget() {
        return !Boolean.TRUE.equals(isTarget);
    }

    public static PromotionTargetDto of(String promotionCode, String promotionName, String hashCi, boolean isTarget) {
        return PromotionTargetDto.builder()
            .promotionCode(promotionCode)
            .promotionName(promotionName)
            .hashCi(hashCi)
            .isTarget(isTarget)
            .build();
    }
} 