package com.teamProject.syusyu.domain.promotion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record PromotionEventPayload(
    String promotionCode,
    String hashCi,
    Boolean isTarget
) {
} 