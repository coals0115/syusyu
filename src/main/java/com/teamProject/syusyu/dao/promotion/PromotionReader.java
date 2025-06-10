package com.teamProject.syusyu.dao.promotion;

import com.teamProject.syusyu.domain.promotion.PromotionDto;
import java.util.Optional;

public interface PromotionReader {
    Optional<PromotionDto> findByPromotionCode(String promotionCode);
} 