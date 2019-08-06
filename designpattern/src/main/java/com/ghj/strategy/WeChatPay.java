package com.ghj.strategy;

import java.math.BigDecimal;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/6 13:26
 */
public class WeChatPay implements Payment {
    @Override
    public PayState pay(String uid, BigDecimal amount) {
        System.out.println("--------------------------");
        System.out.println("欢迎使用微信支付");
        System.out.println("使用微信支付扣款520.0元");
        System.out.println("微信支付完成");
        System.out.println("--------------------------");
        return new PayState(200, "微信支付成功", 520.0);
    }
}
