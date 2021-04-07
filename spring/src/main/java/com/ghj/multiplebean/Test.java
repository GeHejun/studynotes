package com.ghj.multiplebean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.ghj*");
        applicationContext.register(BeanConfiguration.class);
        applicationContext.refresh();
        Object driver = applicationContext.getBean("driver");
        System.out.println(driver);
//        Drive drive = (Drive) applicationContext.getBean("drive");
//        drive.test();
    }
}
