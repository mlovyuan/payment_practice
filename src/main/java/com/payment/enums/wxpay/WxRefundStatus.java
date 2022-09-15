package com.payment.enums.wxpay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WxRefundStatus {
    SUCCESS("SUCCESS"),
    CLOSED("CLOSED"),
    PROCESSING("PROCESSING"),
    ABNORMAL("ABNORMAL");

    private final String type;
}
