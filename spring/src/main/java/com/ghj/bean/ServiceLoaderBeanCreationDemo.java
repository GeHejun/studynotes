package com.ghj.bean;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

public class ServiceLoaderBeanCreationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:serviceLoad-bean-creation.xml");
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<UserBeanFactory> userBeanFactories = applicationContext.getBean("serviceLoader-bean", ServiceLoader.class);
        loadService(userBeanFactories);
        UserBeanFactory bean = beanFactory.createBean(DefaultUserBeanFactory.class);
        System.out.println(bean.getUser());

    }
    public static void loadService(ServiceLoader<UserBeanFactory> beanFactories) {
        for (UserBeanFactory next : beanFactories) {
            System.out.println(next.getUser());
        }
    }
}
