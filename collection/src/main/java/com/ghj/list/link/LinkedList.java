package com.ghj.list.link;

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

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        checkRange(index);
        return (T)node(index).item;
    }

    @Override
    public T set(int index, T data) {
        checkRange(index);
        Node node = node(index);
        T oldValue = (T)node.item;
        node.item = data;
        return oldValue;
    }


    @Override
    public void add(int index, T data) {
        checkRange(index);
        linkBefore(data,node(index));
    }

    private void linkBefore(T data, Node node) {
        Node prev = node.prev;
        Node t = new Node(prev,data,node);
        node.prev = t;
        if (prev == null) {
            first = t;
        } else {
            prev.next = t;
        }
        size++;
    }


    public Node node(int index) {
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;

            }
            return x;
        } else {
            Node x = last;
            for (int i = size - 1;i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    public void checkRange(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean add(T data) {
        linkLast(data);
        return true;
    }

    public void linkLast(T data) {
        final Node l = last;
        Node node = new Node(l,data,null);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size ++;
    }



    @Override
    public void remove(int index) {
        checkRange(index);
        unLink(node(index));

    }
    public void unLink(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
             first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            next.prev = null;
        }
        node.item = null;
        size --;

    }

    @Override
    public boolean remove(T data) {
        if (data == null) {
            for (Node x = first; x!= null;x = x.next) {
                if (x.item == null) {
                    unLink(x);
                    return true;
                }

            }
        } else {
            for (Node x = first; x!= null;x = x.next) {
                if (data == x.item) {
                    unLink(x);
                    return true;
                }

            }
        }
         return false;
    }

    @Override
    public boolean removeAll(T data) {
        remove(data);
       if (contains(data)) {
           removeAll(data);
       }
        return true;
    }

    @Override
    public void clear() {
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

    @Override
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

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
