package com.ghj.aqs;

import java.util.concurrent.TimeUnit;

/**
 * 重入锁
 * @Author ghjwh
 * @Date 2019-04-18
 */
public class ReentrantLock implements Lock{

    @Override
    public void lock() {

    }
    @Override
    public boolean tryLock() {
        return false;
    }
    @Override
    public boolean tryLock(Long time, TimeUnit timeUnit) {
        return false;
    }
    @Override
    public boolean unLock() {
        return false;
    }
    @Override
    public void lockInterruptibly() throws InterruptedException {

    }
}
