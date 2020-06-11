package com.ghj.teswt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/6/4 10:02
 */
public class Test1 {
    static volatile boolean flag = true;
    static Object lock = new Object();
    static volatile int a = 50;
    static volatile int b = 50;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                while (a > 0) {
                    synchronized (lock) {
                        if (!flag) {
                            lock.wait();
                        }
                        System.out.println("A");
                        flag = false;
                        a--;
                        lock.notify();
                    }

                }
            } catch (InterruptedException e) {

            }
        }).start();

        new Thread(() -> {
            try {
                while (b > 0) {
                    synchronized (lock) {
                        if (flag) {
                            lock.wait();
                        }
                        System.out.println("B");
                        flag = true;
                        b--;
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {

            }
        }).start();
    }
}
