package com.payment.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    NOTPAY("未支付"),
    SUCCESS("支付成功"),
    CLOSED("超時已關閉"),
    CANCEL("用戶已取消"),
    REFUND_PROCESSING("退款中"),
    REFUND_SUCCESS("已退款"),
    REFUND_ABNORMAL("退款異常");

    private final String type;
}
