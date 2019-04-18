package com.ghj.map;

import java.util.Objects;

public class HashMap<K, V> {
    /**
     * static可以修饰方法、属性和内部类
     * static修饰内部类，这个内部类就可以直接作为一个普通类来使用，而不需要实力一个外部类
     * @param <K>
     * @param <V>
     */
    static class Node<K,V> implements Map.Entry<K, V>{
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        /**
         * hashMap 节点
         * @param hash
         * @param key
         * @param value
         * @param next
         */
        Node(int hash, K key,V value,Node<K, V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        /**
         * hashMap 节点的hashCode 方法
         * node的hashCode用key的hashCode异或value的hashCode
         * 异或运算：相同为0 不同为1
         * @return
         */
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        /**
         * 重写equals方法
         *
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            //如果两个对象内存相同那么该对象是同一个对象
            if (obj == this) {
                return true;
            } else {
                if (obj instanceof Map.Entry) {
                    //如果对象的是Map.Entry 那么key值相同并且value值相同那么定义为同一个对象
                    if (Objects.equals(((Map.Entry) obj).getKey(),key)
                            && Objects.equals(((Map.Entry) obj).getValue(),value)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 设置值
         * 要返回旧值
         * @param newValue
         * @return
         */
        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }


    public int hash(K k) {
        int h;
        return (k == null) ? 0: (h = k.hashCode()) ^ (h >>> 16);
    }

    public V put(K k, V v) {
        return putVal(hash(k), k, v,true, false);
    }


    final V putVal(int hash, K k, V v,boolean onlyIfAbsent, boolean evict) {
        return null;
    }

}
