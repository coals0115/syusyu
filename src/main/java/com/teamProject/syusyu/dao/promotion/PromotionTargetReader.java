package com.teamProject.syusyu.dao.promotion;

import com.teamProject.syusyu.domain.promotion.PromotionTargetDto;
import java.util.Optional;

public interface PromotionTargetReader {
    Optional<PromotionTargetDto> findByPromotionCodeAndHashCi(String promotionCode, String hashCi);
} 