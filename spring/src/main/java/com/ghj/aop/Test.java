package com.ghj.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/9/19 16:05
 */
public class Test {
    public static void main(String[] args) {
        // 启动 Spring 的 IOC 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-aop.xml");

        AopService aopService = context.getBean(AopService.class);

        aopService.testAop();

    }
}
