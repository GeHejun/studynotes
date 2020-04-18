package com.ghj.tryFinally;

public class TryFinally {


    public static void main(String[] args) {
        System.out.println(add(1, 2));
    }

    public static Integer add(Integer a, Integer b) {
        int c = 0;
        try {
            return c;
        } finally {
            c = a + b;
        }
    }
    public void test() {

    }
}
