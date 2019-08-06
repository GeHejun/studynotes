package com.ghj.strategy;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/6 13:26
 */
public class UnionPay implements Payment{

    @Override
    public PayState pay() {
        System.out.println("--------------------------");
        System.out.println("欢迎使用银联支付");
        System.out.println("使用银联支付扣款520.0元");
        System.out.println("银联支付完成");
        System.out.println("--------------------------");
        return new PayState(200, "银联支付成功", 520.0);
    }
}
