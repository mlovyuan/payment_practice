package com.payment.enums.wxpay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WxApiType {
    NATIVE_PAY("/v3/pay/transactions/native"),
    NATIVE_PAY_V2("/pay/unifiedorder"),
    ORDER_QUERY_BY_NO("/v3/pay/transactions/out-trade-no/%s"),
    CLOSE_ORDER_BY_NO("/v3/pay/transactions/out-trade-no/%s/close"),
    DOMESTIC_REFUNDS("/v3/refund/domestic/refunds"),
    DOMESTIC_REFUNDS_QUERY("/v3/refund/domestic/refunds/%s"),
    TRADE_BILLS("/v3/bill/tradebill"),
    FUND_FLOW_BILLS("/v3/bill/fundflowbill");

    private final String type;
}
