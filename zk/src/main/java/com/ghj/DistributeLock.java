package com.ghj;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/5/6 13:17
 */
public class DistributeLock extends AbstractLock{

    private static final String PATH = "/gehejun_zklock";

    private String curPath;

    private String prePath;

    private CountDownLatch countDownLatch = null;


    public DistributeLock() {
        if (!zkClient.exists(PATH)) {
            zkClient.createPersistent(PATH);
        }
    }

    @Override
    public boolean tryLock() {
        if (StringUtils.isBlank(curPath)) {
            curPath = zkClient.createEphemeralSequential(PATH + "/" , "lock");
        }
        List<String> children = zkClient.getChildren(PATH);
        Collections.sort(children);
        if (curPath.equals(PATH + "/" + children.get(0))) {
            return true;
        } else {

        }

        return false;
    }

    @Override
    public void waitLock() {

    }

    @Override
    public void releaseLock() {

    }
}
