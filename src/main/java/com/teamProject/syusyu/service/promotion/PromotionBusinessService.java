package com.teamProject.syusyu.service.promotion;

import com.teamProject.syusyu.domain.promotion.PromotionTargetDto;
import java.util.Optional;

public interface PromotionBusinessService {
    Optional<PromotionTargetDto> getPromotionTargetData(String promotionCode, String hashCi);
} 