package com.ghj.thread;

public class TwoThreadPrintNumber {

    public static volatile int flag = 0;
    public static volatile int i = 0;
    public static Object lock = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            synchronized (lock) {
                while (i < 100) {
                    if (flag != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                    i++;
                    flag = 0;
                    lock.notify();
                }

            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                while (i < 100) {
                    if (flag != 0 ) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(i);
                    i++;
                    flag = 1;
                    lock.notify();
                }

            }


        }).start();
    }
}
