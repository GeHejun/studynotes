package com.ghj.thread;

public class PrintFooBar {


    private static Object lock = new Object();
    private static volatile int  fooNum = 50;
    private static volatile int  barNum = 50;
    private static volatile boolean  flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                while (fooNum > 0) {
                    if (!flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("foo");
                        fooNum--;
                        flag = false;
                        lock.notify();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                while (barNum > 0) {
                    if (flag) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("bar");
                        barNum--;
                        flag = true;
                        lock.notify();
                    }
                }
            }
        }).start();
    }

}
