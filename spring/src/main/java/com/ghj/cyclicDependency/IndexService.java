package com.ghj.cyclicDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {

    @Autowired
    UserService userService;

    public IndexService() {

        System.out.println("IndexService construction ...");

    }
}
