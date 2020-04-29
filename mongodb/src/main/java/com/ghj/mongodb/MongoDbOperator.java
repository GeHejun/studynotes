package com.ghj.mongodb;

import com.mongodb.client.model.Aggregates;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;

import javax.annotation.Resource;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/4/29 11:37
 */
public class MongoDbOperator {
    @Resource
    MongoTemplate mongoTemplate;

    public void operator() {


    }
}
