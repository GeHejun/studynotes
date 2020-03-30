package com.ghj.singleInstance;

public class LazySingleInstance {

    private LazySingleInstance () {}

    private static class InnerLazySingleInstance {
        private static final  LazySingleInstance lazySingleInstance = new LazySingleInstance();
    }

    public LazySingleInstance getInstance() {
        return InnerLazySingleInstance.lazySingleInstance;
    }
}
