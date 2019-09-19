package com.ghj.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/9/19 15:58
 */
public class LogAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("准备执行方法: " + method.getName() + ", 参数列表：" + Arrays.toString(objects));
    }
}
