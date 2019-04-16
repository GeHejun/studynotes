package com.ghj.map;


public interface Map<K, V> {
    public interface Entry<K, V> {
        K getKey();
        V getValue();
        V setValue(V value);


    }
}
