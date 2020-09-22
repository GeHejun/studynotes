package com.ghj.exception;

public class CustomExceptionDemo {
    public static void main(String[] args) {

    }

    public void test() throws MyCustomException {
        MyCustomException.testMyCustomException("aaa{}","vvb");
        System.out.println("aaa");
    }
}
