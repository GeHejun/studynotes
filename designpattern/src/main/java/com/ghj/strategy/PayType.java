package com.ghj.strategy;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/6 14:01
 */
public enum PayType {

    WECHAT_PAY(new WeChatPay()),
    ALI_PAY(new AliPay()),
    UNION_PAY(new UnionPay());

    Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }
}
