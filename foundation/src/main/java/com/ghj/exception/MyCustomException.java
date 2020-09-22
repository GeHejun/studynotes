package com.ghj.exception;

public class MyCustomException extends Exception {

    public MyCustomException(String msg) {
        super(msg);
    }

    public static void testMyCustomException(String format, String msg) throws MyCustomException {
        format = format.replaceAll("\\{\\}", "%s");
        throw new MyCustomException(String.format(format, msg));
    }
}
