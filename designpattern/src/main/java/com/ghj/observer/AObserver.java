package com.ghj.observer;

/**
 * @author gehj
 * @date 2019/6/2714:42
 */
public class AObserver implements Observer {

    private String myState;

    @Override
    public void update(String state) {
        this.myState = state;

        System.out.println("AObserver  ------------ " + myState);
    }
}
