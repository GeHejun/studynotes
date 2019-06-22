package com.ghj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCreator {

    @Bean
    public Red red() {
        return new Red();
    }
}
