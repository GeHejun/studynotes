package com.ghj.mongodb;

import com.alibaba.fastjson.JSON;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/4/29 11:37
 */
@Service
public class MongoDbOperator {

    @Resource
    private MongoTemplate mongoTemplate;

    public String operator() {

        GroupOperation sum = Aggregation.group("qr.bi").count().as("sum");

        LimitOperation limit = Aggregation.limit(5);

        SortOperation sort = Aggregation.sort(new Sort(Sort.Direction.DESC, "qr.c"));

        SkipOperation skip = Aggregation.skip(3L);

        Aggregation aggregation = Aggregation.newAggregation(limit, sort, skip);

        AggregationResults<Object> result = mongoTemplate.aggregate(aggregation, "quotations", Object.class);

        return  JSON.toJSONString(result.getMappedResults());

    }
}
