package com.ghj.gc;

import java.lang.ref.SoftReference;

public class ReferenceQueue {
    private static int _4M = 1024 * 1024 * 4;

    public static void main(String[] args) {
        byte[] bytes = new byte[_4M];
        SoftReference<byte[]> softReference = new SoftReference(bytes);

    }
}
