package com.ghj.observer;

/**
 * @author gehj
 * @date 2019/6/2714:45
 */
public class ContextSubject extends Subject {

    public void contextChange(String newState) {

        notifyEveryOne(newState);

    }

    public static void main(String[] args) {
        ContextSubject contextSubject = new ContextSubject();
        contextSubject.attach(new AObserver());
        contextSubject.attach(new BObserver());

        contextSubject.contextChange("state1");
        contextSubject.contextChange("state2");
    }
}
