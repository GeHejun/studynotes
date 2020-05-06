package com.ghj.limit;

import java.lang.annotation.*;

/**
 * @author gehj
 * @version 1.0
 * @description 限流注解
 * @date 2019/12/15 13:50
 */
@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {

    //标识 指定sec时间段内的访问次数限制
    int limit() default 1;
    //标识 时间段
    int sec() default 1000;
}
