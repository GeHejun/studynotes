package com.ghj.thread;

import java.util.concurrent.TimeUnit;

/**
 * 数据类
 */
class Data {
    /**
     * 表示数据个数
     */
    private volatile int number = 0;
    public synchronized void increment() throws InterruptedException {
        while (number != 0) {
            this.wait();
        }
        number++;
        System.err.println(Thread.currentThread().getName()+"生产了数据:"+number);
        this.notify();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"消费了数据:"+number);
        this.notify();
    }
}