package com.teamProject.syusyu.service.promotion;

import com.teamProject.syusyu.domain.promotion.PromotionTargetDto;
import java.util.Optional;

public interface RedisPromotionService {
    void savePromotionTarget(PromotionTargetDto promotionTargetDto);
    Optional<PromotionTargetDto> findPromotionTarget(String promotionCode, String hashCi);
    void usePromotion(PromotionTargetDto promotionTargetDto);
} 