package com.payment.enums.wxpay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WxTradeState {
    SUCCESS("SUCCESS"),
    NOTPAY("NOTPAY"),
    CLOSED("CLOSED"),
    REFUND("REFUND");

    private final String type;
}
