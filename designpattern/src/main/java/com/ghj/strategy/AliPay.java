package com.ghj.strategy;

import java.math.BigDecimal;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/6 13:25
 */
public class AliPay implements Payment {
    @Override
    public PayState pay(String uid, BigDecimal amount) {
        System.out.println("--------------------------");
        System.out.println("欢迎使用支付宝支付");
        System.out.println("使用支付宝支付扣款520.0元");
        System.out.println("支付宝支付完成");
        System.out.println("--------------------------");
        return new PayState(200, "支付宝支付成功", 520.0);
    }
}
