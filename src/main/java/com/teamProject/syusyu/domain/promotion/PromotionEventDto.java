package com.teamProject.syusyu.domain.promotion;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PromotionEventDto extends ApplicationEvent {
    private final long customerUid;
    private final String moneyKey;
    private final PromotionEventPayload payload;

    @Setter
    private Object eventOutboxDto;

    @Builder
    public PromotionEventDto(Object source, long customerUid, String moneyKey, PromotionEventPayload payload) {
        super(source);
        this.customerUid = customerUid;
        this.moneyKey = moneyKey;
        this.payload = payload;
    }
} 