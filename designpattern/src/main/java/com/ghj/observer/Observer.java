package com.ghj.observer;

/**
 * @author gehj
 * @date 2019/6/27 14:32
 */
public interface Observer {
    /**
     * 通知
     * @param state
     */
    void update(String state);
}
