package com.ghj.cyclicDependency;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ServiceLoader;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("com.ghj.cyclicDependency");
        applicationContext.refresh();
        IndexService indexService = applicationContext.getBean(IndexService.class);
        System.out.println(indexService.userService.indexService);


    }
}
