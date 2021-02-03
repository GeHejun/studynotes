package com.ghj.aqs;

import java.util.concurrent.TimeUnit;

/**
 * 线程8锁
 * 1. 两个普通同步方法，打印? one  two
 * 2. 新增Thread.sleep() 给 printOne,打印? one two
 * 3. 新装普通方法 printThree,打印? three  one  two
 * 4. 两个number对象，打印? two one
 * 5. 一个静态同步方法 printOne， 一个普通同步方法 printTwo ，打印? two one
 * 6. 两个静态方法, 打印? one two
 * 7. 一个静态同步方法 printOne， 一个普通同步方法 printTwo ，两个number对象， 打印? two one
 * 8. 两个静态方法，两个number，打印? two one
 *
 * 结论： 1.非静态方法的锁默认为this
 *       2.静态方法的锁默认为 Class
 *       3.某一时刻内，只能有一个线程持有锁，不管有多少方法
 *
 */
public class Thread8Monitor {



    public static void main(String[] args) {
        Number number = new Number();
        Number number1 = new Number();
        new Thread(() -> Number.printOne()).start();
//        new Thread(() -> number.printTwo()).start();
        new Thread(() -> number1.printTwo()).start();
//        new Thread(() -> number.printThree()).start();

    }

}


class Number {

    public static synchronized void printOne() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        System.out.println("one");
    }

    public  synchronized void printTwo() {
        System.out.println("two");
    }

    public void printThree() {
        System.out.println("three");
    }
}

