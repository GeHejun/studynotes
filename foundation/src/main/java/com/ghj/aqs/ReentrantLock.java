package com.ghj.aqs;

import java.util.concurrent.TimeUnit;

/**
 * 重入锁
 * @Author ghjwh
 * @Date 2019-04-18
 */
public class ReentrantLock implements Lock{

    public void lock() {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(Long time, TimeUnit timeUnit) {
        return false;
    }

    public boolean unLock() {
        return false;
    }

    public void lockInterruptibly() throws InterruptedException {

    }
}
