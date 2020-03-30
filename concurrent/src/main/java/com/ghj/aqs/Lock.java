package com.ghj.aqs;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * 锁
 * @Author ghjwh
 * @Date 2019-04-18
 */
public interface Lock {

    /**
     * 锁
     */
    void lock();

    /**
     * 尝试加锁
     * @return
     */
    boolean tryLock();

    /**
     * 尝试加锁多久
     * @param time
     * @param timeUnit
     * @return
     */
    boolean tryLock(Long time, TimeUnit timeUnit);

    /**
     * 解锁
     * @return
     */
    boolean unLock();

    /**
     * 中断锁
     * @throws InterruptedException
     */
    void lockInterruptibly() throws InterruptedException;

}
