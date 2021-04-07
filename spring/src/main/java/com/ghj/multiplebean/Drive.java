package com.ghj.multiplebean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Drive {

    @Resource
    private Car car1;

    @Resource
    private Car car2;


    public void test() {
        System.out.println(car1);
        System.out.println(car2);
    }
}
