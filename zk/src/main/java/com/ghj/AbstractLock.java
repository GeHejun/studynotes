package com.ghj;

import org.I0Itec.zkclient.ZkClient;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/5/6 13:19
 */
public abstract class AbstractLock {

    public static final String ZK_ADDR = "";

    public static final int SESSION_TIMEOUT = 5000;

    ZkClient zkClient = new ZkClient(ZK_ADDR, SESSION_TIMEOUT);


    public void getLock() {
        String threadName = Thread.currentThread().getName();
        if (tryLock()) {
            System.out.println(threadName + "-获得锁成功");
        } else {
            System.out.println(threadName + "-获得锁失败");
            waitLock();
            getLock();
        }
    }


    public abstract boolean tryLock();

    public abstract void waitLock();

    public abstract void releaseLock();

}
