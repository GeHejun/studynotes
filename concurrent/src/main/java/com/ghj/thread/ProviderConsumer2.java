package com.ghj.thread;

/**
 * @author gehejun
 */
public class ProviderConsumer2 {
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
        },"Producer--A").start();

        //生产者线程B
        new Thread(() -> {
            for (int i = 0;i < 5;i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Producer--B").start();

        //消费者线程C
        new Thread(() -> {
            for (int i = 0;i < 5;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"consumer--C").start();

        //消费者线程D
        new Thread(() -> {
            for (int i = 0;i < 5;i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"consumer--D").start();
    }
}

