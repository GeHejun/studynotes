package com.ghj.multiplebean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class BeanConfiguration {

    @Bean(name = "driver1")
    public Driver driver1() {
        User user = new User();
        user.setName("gehejun");

        Driver driver = new Driver();
        driver.setUser(user);
        return driver;
    }

    @Bean(name = "driver2")
    public Driver driver2() {
        User user = new User();
        user.setName("gehejun1");

        Driver driver = new Driver();
        driver.setUser(user);
        return driver;
    }

    @Resource(name = "driver1")
    @Bean(name = "car1")
    public Car car1(Driver driver) {
        return new Car(driver);
    }

    @Resource(name = "driver2")
    @Bean( name = "car2")
    public Car car2(Driver driver) {
        return new Car(driver);
    }
}
