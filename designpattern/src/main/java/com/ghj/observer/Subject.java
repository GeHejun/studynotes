package com.ghj.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gehj
 * @date 2019/6/27 14:32
 */
public class Subject {

    List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyEveryOne(String state) {
        observers.stream().forEach(observer -> observer.update(state));
    }

}
