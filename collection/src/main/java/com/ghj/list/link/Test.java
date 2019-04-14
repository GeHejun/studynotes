package com.ghj.list.link;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        //jdk
        LinkedList linkedList = new LinkedList();
        linkedList.add("aaa");
        linkedList.add("bbb");
        linkedList.add("aaa");
        linkedList.remove("aaa");
        System.out.println(linkedList.toString());

        //self
        com.ghj.list.link.LinkedList linkedList1 = new com.ghj.list.link.LinkedList();
        linkedList1.add("aaa");
        linkedList1.add("bbb");
        System.out.println(linkedList1.removeAll("aaa"));
    }
}
