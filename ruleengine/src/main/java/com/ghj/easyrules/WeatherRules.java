package com.ghj.easyrules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/5/7 18:39
 */
@Rule
public class WeatherRules {

    @Condition
    public boolean isRain() {
        return true;
    }

    @Action
    public void doSomething() {
        System.out.println("1111");
    }
}
