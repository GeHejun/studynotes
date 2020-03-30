package com.ghj.cyclicDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IndexService indexService;

    public UserService() {

        System.out.println("UserService construction ...");

    }
}
