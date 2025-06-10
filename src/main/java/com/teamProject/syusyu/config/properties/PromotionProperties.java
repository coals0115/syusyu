package com.teamProject.syusyu.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "promotion")
public class PromotionProperties {

    private FirstPayment firstPayment;

    @Getter
    @Setter
    public static class FirstPayment {
        private String code;
        private String name;
        private List<String> excludedMerchants;
        private List<ExcludedMerchantBrand> excludedMerchantBrands;
    }

    @Getter
    @Setter
    public static class ExcludedMerchantBrand {
        private String merchant;
        private String brand;
    }

    /**
     * 첫 결제 프로모션 대상 여부 확인
     * @param merchantCode merchantCode
     * @param merchantBrandCode merchantBrandCode
     * @return 프로모션 대상이면 true, 아니면 false
     */
    public boolean isFirstPaymentPromotionValid(String merchantCode, String merchantBrandCode) {
        if (firstPayment.getExcludedMerchants() != null &&
            firstPayment.getExcludedMerchants().contains(merchantCode)) {
            return false;
        }

        if (firstPayment.getExcludedMerchantBrands() != null) {
            return firstPayment.getExcludedMerchantBrands().stream()
                .noneMatch(excluded ->
                    excluded.getMerchant().equals(merchantCode) &&
                    excluded.getBrand().equals(merchantBrandCode));
        }

        return true;
    }
} 