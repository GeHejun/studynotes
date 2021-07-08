package com.ghj.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class MergeSort {
    private static int MAX = 10000;

    private static int init[] = new int[MAX];

    // 这是为了生成一个数量为MAX的随机整数集合，准备计算数据
    // 和算法本身并没有什么关系
    static {
        Random r = new Random();
        for(int index = 1 ; index <= MAX ; index++) {
            init[index - 1] = r.nextInt(10000000);
        }
    }

    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();
        int results[] = NormalMerge.forkits(init);
        long endTime = System.currentTimeMillis();
        // 如果参与排序的数据非常庞大，记得把这种打印方式去掉
        System.out.println("耗时=" + (endTime - beginTime) + " | " + Arrays.toString(results));

        // 正式开始
        long beginTime1 = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinMerge.MyTask task = new ForkJoinMerge.MyTask(init);
        ForkJoinTask<int[]> taskResult = pool.submit(task);
        try {
            taskResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(System.out);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("耗时=" + (endTime1 - beginTime1));
    }
}
