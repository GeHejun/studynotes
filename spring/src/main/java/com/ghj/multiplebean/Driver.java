package com.ghj.multiplebean;

import org.springframework.stereotype.Service;
@Service
public class Driver {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
