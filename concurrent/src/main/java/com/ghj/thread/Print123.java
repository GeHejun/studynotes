package com.ghj.thread;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @    date 2020/6/25 12:57
 */
public class Print123 {


    private volatile static Integer i = 0;
    private final static Object LOCK = new Object();

    public static void main(String[] args) {

        Print123 print123 = new Print123();

        print123.first(() -> {
            synchronized (LOCK) {
                if (i == 0) {
                    System.out.println("one");
                    i++;
                    LOCK.notify();
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        });


        print123.second(() -> {
            synchronized (LOCK) {
                if (i == 1) {
                    System.out.println("two");
                    i++;
                    LOCK.notify();
                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        print123.third(() -> {
            synchronized (LOCK) {
                if (i == 2) {
                    System.out.println("three");
                    i++;
                    LOCK.notify();

                } else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        });

    }


    public Print123() {

    }

    public void first(Runnable printFirst)  {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond)  {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird)  {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
