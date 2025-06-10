package com.teamProject.syusyu.domain.promotion;

/**
 * 프로모션 정보
 */
public record PromotionInfo(
    String promotionName,    // 프로모션 이름
    boolean isTarget         // 프로모션 대상 여부
) {} 