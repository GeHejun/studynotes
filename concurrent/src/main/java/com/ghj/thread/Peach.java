package com.ghj.thread;

/**
 * @author gehejun
 */
public class Peach {
    public volatile static int count = 100;
    public static void main(String[] args) {
        Monkey monkey = new Monkey(count);
        new Thread(monkey).start();
        new Thread(monkey).start();
        new Thread(monkey).start();
    }
}

class Monkey implements Runnable {
    private int myselfCount = 0;
    private int count;

    public Monkey(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        get();
    }

    private synchronized void get() {
        int tmpCount = 0;
        while (count  > 0) {
            if (count % 2 == 0) {
                tmpCount = count / 2;
            } else {
                tmpCount = (count + 1) / 2;
            }
            if (tmpCount >= 0) {
                myselfCount = myselfCount + tmpCount;
                System.out.println(Thread.currentThread().getName() + myselfCount);
                count = count - tmpCount;
            }
        }
    }
}
