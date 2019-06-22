package com.ghj;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanCreateProcess {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.getBean("red");
    }


}
