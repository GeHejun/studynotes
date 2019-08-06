package com.ghj.strategy;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/6 13:24
 */
public class PayState {

    private int code;

    private String message;

    private Object data;

    public PayState(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
