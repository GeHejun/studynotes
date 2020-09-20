package com.ghj.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;
import java.util.Iterator;
import java.util.ServiceLoader;

public class BeanCreationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean-creation.xml");
        Object bean = applicationContext.getBean("user-by-static-method");
        Object bean1 = applicationContext.getBean("user-by-instance-method");
        Object bean2 = applicationContext.getBean("user-by-factory-bean");
        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean2);
    }
}
