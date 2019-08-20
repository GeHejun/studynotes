package com.ghj.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/20 11:15
 */
public class IocMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.scan("com.ghj.ioc");
        IMessageService messageService = annotationConfigApplicationContext.getBean(MessageServiceImpl.class);
        System.out.println(messageService.getMessage());
    }
}
