package com.ghj.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/4/29 11:19
 */
@SpringBootApplication
public class MongoDbApp {

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApp.class, args);
    }
}
