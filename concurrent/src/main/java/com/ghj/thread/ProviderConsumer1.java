package com.ghj.thread;

/**
 * @author gehejun
 */
public class ProviderConsumer1 {
    public static void main(String[] args) {
        Data data = new Data();
        //生产者线程A
        new Thread(() -> {
            for (int i = 0;i < 5;i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Provider-A").start();

        //消费者线程B
        new Thread(() -> {
            for (int i = 0;i < 5;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer-B").start();

    }
}

