package com.ghj.proxy;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/9/26 9:16
 */
public interface InvocationHandler {

    Object invoke(Method m, Objects args);
}
