package com.payment.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PayType {
    WXPAY("微信");

    private final String type;
}

