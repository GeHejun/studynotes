package com.ghj.bean;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;

//3.通过@Import方式
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        annotationConfigApplicationContext.register(AnnotationBeanDefinitionDemo.class);

        registerUserBeanDefinition(annotationConfigApplicationContext, "gehejun-user");

        registerUserBeanDefinition(annotationConfigApplicationContext);

        annotationConfigApplicationContext.refresh();

        System.out.println("config:" + Arrays.toString(annotationConfigApplicationContext.getBeanNamesForType(Config.class)));

        System.out.println("user:" + Arrays.toString(annotationConfigApplicationContext.getBeanNamesForType(User.class)));


        annotationConfigApplicationContext.close();

    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("id", 1L);
        mutablePropertyValues.add("name", "葛河俊");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, genericBeanDefinition);
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(genericBeanDefinition, registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    //2.通过@Component方式
    @Component
    public static class Config {
        //1.  通过@Bean的方式
        @Bean
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("gehejun");
            return user;
        }
    }


}
