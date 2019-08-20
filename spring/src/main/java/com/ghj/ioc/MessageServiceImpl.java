package com.ghj.ioc;

import org.springframework.stereotype.Service;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2019/8/20 11:17
 */
@Service
public class MessageServiceImpl implements IMessageService{
    @Override
    public String getMessage() {
        return "aa";
    }
}
