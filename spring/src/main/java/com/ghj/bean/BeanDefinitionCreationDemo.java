package com.ghj.bean;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class BeanDefinitionCreationDemo {

    public static void main(String[] args) {

        //1.通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //2.设置属性
        beanDefinitionBuilder.addPropertyValue("id", 1L)
                .addPropertyValue("name", "葛河俊");
        //3.获取BeanDefinition
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("id", 1L);
        mutablePropertyValues.add("name", "葛河俊");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

    }
}
