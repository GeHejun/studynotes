package com.ghj.bean;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;

    public static User createUser() {
        return new User();
    }
}
