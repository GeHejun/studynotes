package com.ghj.thread;

import java.util.concurrent.*;

public class DelayThreadPool {


    public static void main(String[] args) {
//        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
//        for (int i = 0; i < 10; i++) {
//            threadPool.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//            });
//        }

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
        try {
            arrayBlockingQueue.add(null);
            System.out.println(arrayBlockingQueue.offer("aa", 5, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
