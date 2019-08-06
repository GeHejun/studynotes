package com.ghj.strategy;

import java.math.BigDecimal;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/6 13:24
 */
public interface Payment {

    /**
     * 支付
     * @return
     */
    PayState pay(String uid, BigDecimal amount);
}
