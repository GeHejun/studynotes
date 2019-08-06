package com.ghj.strategy;

import java.math.BigDecimal;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/6 14:11
 */
public class Test {

    public static void main(String[] args) {
        Order order = new Order("", "", new BigDecimal("520.0"));

        order.pay(PayType.ALI_PAY);

        order.pay(PayType.WECHAT_PAY);

        order.pay(PayType.UNION_PAY);
    }
}
