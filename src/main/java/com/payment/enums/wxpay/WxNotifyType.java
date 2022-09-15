package com.payment.enums.wxpay;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum WxNotifyType {
	NATIVE_NOTIFY("/api/wx-pay/native/notify"),
	NATIVE_NOTIFY_V2("/api/wx-pay-v2/native/notify"),
	REFUND_NOTIFY("/api/wx-pay/refunds/notify");

	private final String type;
}
