package com.ghj.bean;

public interface UserBeanFactory {
    default User getUser() {
        return User.createUser();
    }
}
