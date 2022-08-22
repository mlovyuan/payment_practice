package com.payment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_order_info")
public class OrderInfo extends BaseEntity {
    private String title;

    private String orderNo;

    private Long userId;

    private Long productId;

    private Integer totalFee;

    private String codeUrl;

    private String orderStatus;
}
