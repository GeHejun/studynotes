package com.ghj.list;

import com.ghj.list.List;
import org.omg.CORBA.NO_IMPLEMENT;

import java.util.Collection;

public class LinkedList<T> implements List<T> {
    /**
     * 用来存储链表存储元素个数
     */
    private int size;

    private Node first;

    private Node last;

    /**
     * 默认的无参构造器
     */
    public LinkedList() {

    }

    public LinkedList(Collection c) {

    }

    /**
     * 判断linkedList是否为空
     * size会随着元素的增加或减少而改变
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 得到指定位置的元素
     * node(index)可以的到指定位置上的节点
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        //检查下标是否越界
        checkRange(index);
        return (T)node(index).item;
    }

    /**
     * 把指定位置上的元素替换成data
     * @param index
     * @param data
     * @return
     */
    @Override
    public T set(int index, T data) {
        checkRange(index);
        Node node = node(index);
        T oldValue = (T)node.item;
        node.item = data;
        return oldValue;
    }


    /**
     * 在指定位置增加元素
     * @param index
     * @param data
     */
    @Override
    public void add(int index, T data) {
        checkRange(index);
        linkBefore(data,node(index));
    }

    /**
     * 在指定节点之前增加元素
     * @param data
     * @param node
     */
    private void linkBefore(T data, Node node) {
        //把节点的前驱节点赋给prev
        Node prev = node.prev;
        //初始化一个node节点，前驱节点是prev,后驱节点是传入的参数node
        Node t = new Node(prev,data,node);
        //把新节点的作为传入参数node的前驱节点
        node.prev = t;
        //如果node是first节点
        if (prev == null) {
            //新节点作为first节点
            first = t;
        } else {
            //把新节点作为原来节点前驱节点的后驱节点
            prev.next = t;
        }
        //size改变
        size++;
    }

    /**
     * 通过下标获取下标所在的node 采用二分法
     * @param index
     * @return
     */
    public Node node(int index) {
        //如果index小于size的一半，那么从前开始遍历，否则从后开始遍历
        if (index < (size >> 1)) {
            //把first赋予临时节点x
            Node x = first;
            for (int i = 0; i < index; i++) {
                //从0开始一直到下标index-1 x不断被赋予给它的下一个节点
                x = x.next;

            }
            return x;
        } else {
            //把last赋予给临时节点x
            Node x = last;
            for (int i = size - 1;i > index; i--) {
                //从size - 1开始一直到index x 不断被赋予给它的前一个元素
                x = x.prev;
            }
            return x;
        }
    }

    /**
     * 检查传入的下标是否合法
     * @param index
     */
    public void checkRange(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 添加元素
     * @param data
     * @return
     */
    @Override
    public boolean add(T data) {
        linkLast(data);
        return true;
    }

    /**
     * 在链表尾部添加元素
     * @param data
     */
    public void linkLast(T data) {
        //把last赋给临时节点l
        final Node l = last;
        //新初始化一个节点 前驱节点是l,后驱节点为空
        Node node = new Node(l,data,null);
        //新节点作为最后一个节点
        last = node;
        //如果l节点是空，代表目前的链表为空，那么node也是最开始的节点
        if (l == null) {
            first = node;
        } else {
            //把l的后驱节点指向新节点
            l.next = node;
        }
        size ++;
    }


    /**
     * 移除指定下标的node
     * @param index
     */
    @Override
    public void remove(int index) {
        //检查下标的合法性
        checkRange(index);
        //通过node(index)方法找到要移除下标对应的node元素，然后通过unlink方法移除元素
        unLink(node(index));

    }

    /**
     * 移除节点的方法
     * @param node
     */
    public void unLink(Node node) {
        //把node的前驱节点赋给prev
        Node prev = node.prev;
        //把node的后驱节点赋给next
        Node next = node.next;
        //如果前驱节点为空，代表node是第一个节点那么，把第一个节点指向next
        if (prev == null) {
             first = next;
        } else {
            //把node的前驱节点的next指向node的next
            prev.next = next;
            //node的prev没有用了，可以置为null
            node.prev = null;
        }
        //如果后驱节点为空，代表node是最后一个节点那么，把最后一个节点指向next
        if (next == null) {
            last = prev;
        } else {
            //把node的后驱节点的prev指向node的prev
            next.prev = prev;
            //node的next没有用了，可以置为null
            node.next = null;
        }
        node.item = null;
        size --;

    }

    /**
     * 移除元素
     * @param data
     * @return
     */
    @Override
    public boolean remove(T data) {
        //判断是否是null
        if (data == null) {
            //遍历链表 先把first赋给临时节点x,然后x不为空，判断x的值是否是空，如果是移除，否则x指向x的next
            for (Node x = first; x!= null;x = x.next) {
                if (x.item == null) {
                    unLink(x);
                    return true;
                }

            }
        } else {
            //遍历链表 先把first赋给临时节点x,然后x不为空，判断data是否和x的元素相同，如果是移除，否则x指向x的next
            for (Node x = first; x!= null;x = x.next) {
                if (data == x.item) {
                    unLink(x);
                    return true;
                }

            }
        }
         return false;
    }

    /**
     * 自己添加的方法，不断调用remove方法，采用递归实现
     *
     *
     * @param data
     * @return
     */
    @Override
    public boolean removeAll(T data) {
        remove(data);
       if (contains(data)) {
           removeAll(data);
       }
        return true;
    }

    /**
     * 清空链表
     */
    @Override
    public void clear() {
        //node 从first开始不断指向它的next节点
        //和for (Node x = first; x!= null;x = x.next) {}不同，因为是要不断清空当前节点所以x = x.next不能使用
        //而是在循环体中采用Node t = node.next;node = t;把node不断指向它的下一个节点
        for (Node node = first;node != null;) {
            Node t = node.next;
            node.prev = null;
            node.item = null;
            node.next = null;
            node = t;
        }
        first = last = null;
        size = 0;
    }

    /**
     * 是否包含某个元素 调用indexOf方法
     * @param data
     * @return
     */
    @Override
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    /**
     * 找到指定元素的下标
     * 用到了局部变量 index每次遍历index+1
     * @param data
     * @return
     */
    @Override
    public int indexOf(T data) {
        int index = 0;
        if (data == null) {
            for (Node node = first; node != null;node = node.next) {
                if (node.item == null) {
                    return index;
                }
                index ++;
            }
        } else {
            for (Node node = first; node != null;node = node.next) {
                if (data.equals(node.item)) {
                    return index;
                }
                index ++;
            }
        }

        return -1;
    }

    /**
     * 找到最大的和data相同的元素的下标和indexOf不同的是，该方法从后往前遍历
     * @param data
     * @return
     */
    @Override
    public int lastIndexOf(T data) {
        int index = size;
        if (data == null) {
            for (Node node = last; node != null;node = node.prev) {
                if (node.item == null) {
                    return index;
                }
                index --;
            }
        } else {
            for (Node node = last; node != null;node = node.prev) {
                if (data.equals(node.item)) {
                    return index;
                }
                index --;
            }
        }

        return -1;
    }

    /**
     * 内部类Node
     * @param <T>
     */
    class Node<T> {

        public Node next;
        public Node prev;
        public T item;

        public Node(Node prev,T item, Node next) {
            this.next = next;
            this.prev = prev;
            this.item = item;
        }
    }

    /**
     * 该toString方法是自己实现的
     * @return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Node node = first; node != null; node = node.next) {
            stringBuilder.append(node.item);
            if (node != last) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
