package com.ghj.map;


import apple.laf.JRSUIUtils;

import java.util.Objects;

public class HashMap<K, V> {

    /**
     * 默认的数组大小
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 默认的扩容因子大小
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 最大容量
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * 转换成红黑树的链表阈值大小
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 从红黑树转化成链表的阈值大小
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * 转化成红黑树的最小的table容量阈值
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

    /**
     * 扩容阈值 容量 * 加载因子
     */
    private int threshold;

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
        @Override
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

    static class TreeNode<K,V> extends LinkedHashMap.Entry<K,V>{
        TreeNode<K,V> parent;
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;
        boolean red;

        TreeNode(int hash,K k,V v,Node<K,V> next) {
            super(hash,k,v,next);
        }

        /**
         * 获取树的根节点
         * @return
         */
        final TreeNode<K,V> root() {
            for (TreeNode<K,V> r = this,p;;) {
                if ((p = r.parent) == null) {
                    return r;
                }
                r = p;
            }
        }

        static <K,V> void moveRootToFront(Node<K,V>[] tab,TreeNode<K,V> root) {
            int n;
            if (root != null && tab != null && (n = tab.length) > 0) {
                int index = (n - 1) & root.hash;
                TreeNode<K,V> first = (TreeNode<K,V>)tab[index];
                if (root != first) {
                    Node<K,V> rn;
                    tab[index] = root;
                }
            }
        }
    }

    /**
     * 数组
     */
    Node[] table;

    /**
     * 加载因子  用于计算扩容阈值
     */
    float loadFactor;

    /**
     * 计算key的hash值，如果key为null，那么hash值为0
     * @param k
     * @return
     */
    public int hash(K k) {
        int h;
        return (k == null) ? 0: (h = k.hashCode()) ^ (h >>> 16);
    }

    /**
     * 无参构造器
     * 加载因子 = 默认的加载因子大小
     */
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    /**
     *
     * @param k
     * @param v
     * @return
     */
    public V put(K k, V v) {
        return putVal(hash(k), k, v,false, true);
    }


    final V putVal(int hash, K k, V v,boolean onlyIfAbsent, boolean evict) {
        Node[] tab;Node p;int n,i;
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        return null;
    }



    final Node[] resize() {
        Node[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 :oldTab.length;
        int oldThr = threshold;
        int newCap,newThr = 0;
        if (oldCap > 0) {
            if (oldCap > MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY){
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {
            newCap = oldThr;
        } else {
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }

        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float) MAXIMUM_CAPACITY)? (int)ft :Integer.MAX_VALUE;
        }
        threshold = newThr;
        Node[] newTab = new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; j++) {
                Node e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null) {
                        newTab[e.hash & (newCap - 1)] = e;
                    } else if (e instanceof TreeNode){

                    }
                }
            }
        }
        return newTab;
    }

}
