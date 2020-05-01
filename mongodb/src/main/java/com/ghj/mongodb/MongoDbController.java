package com.ghj.mongodb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/4/29 12:56
 */
@Controller
@RequestMapping("/mongodb")
public class MongoDbController {

    @Resource
    MongoDbOperator mongoDbOperator;

    @RequestMapping("/query")
    @ResponseBody
    public String query() {
        return mongoDbOperator.operator();
    }
}
