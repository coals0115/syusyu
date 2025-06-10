package com.teamProject.syusyu.domain.promotion;

import lombok.Builder;

@Builder
public record PromotionDto(
    Long promotionId,
    String promotionCode,
    String promotionName,
    String description,
    Boolean isActive
) {} 