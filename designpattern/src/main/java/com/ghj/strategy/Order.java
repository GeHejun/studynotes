package com.ghj.strategy;

import java.math.BigDecimal;

/**
 * @author gehj
 * @version 1.0
 * @description 订单
 * @date 2019/8/6 13:16
 */
public class Order {

    String uid;

    String orderId;

    BigDecimal amount;

    public Order(String uid, String orderId, BigDecimal amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public void pay(PayType payType) {
        payType.payment.pay();
    }
}
