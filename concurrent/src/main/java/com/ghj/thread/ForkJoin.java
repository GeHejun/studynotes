package com.ghj.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Integer> {
    //阈值
    private static final int THRESHOLD = 2;

    private final int start;

    private final int end;

    public ForkJoin(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        int length = end - start;

        if (length < THRESHOLD) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoin  forkJoinLeft = new ForkJoin(start, middle);
            ForkJoin  forkJoinRight = new ForkJoin(middle + 1, end);
            invokeAll(forkJoinLeft, forkJoinRight);
            Integer leftResult = forkJoinLeft.join();
            Integer rightResult = forkJoinRight.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoin forkJoin =new ForkJoin(1,1000000);
        long now = System.currentTimeMillis();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(forkJoin);
        System.out.println("time=" + (System.currentTimeMillis() - now));
        System.out.println(forkJoinTask.get());

        System.out.println("--------------------------");

        int sum = 0;
        long now1 = System.currentTimeMillis();
        for (int i = 1; i <= 1000000; i++) {
            sum += i;
        }
        System.out.println("time=" + (System.currentTimeMillis() - now1));
        System.out.println(sum);

        System.out.println("--------------------------");


    }
}
