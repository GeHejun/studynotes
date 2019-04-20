package com.ghj.map;

public class LinkedHashMap {

    static  class Entry<K,V> extends HashMap.Node {

        Entry<K,V> before;

        Entry<K,V> after;

        /**
         * hashMap 节点
         *
         * @param hash
         * @param key
         * @param value
         * @param next
         */
        Entry(int hash, K key, V value, HashMap.Node next) {
            super(hash, key, value, next);
        }
    }
}
