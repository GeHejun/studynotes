package com.ghj;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        //jdk
//        List list = new ArrayList(3);
//        list.add("aaa");
//        list.add("aaa");
//        list.add(null);
//        list.remove("aaa");
//        list.get(-100);
//        System.out.println("jdk list:" + list.toString());
//        list = new ArrayList<Object>();
//        long startTime1 = System.currentTimeMillis();
//        ((ArrayList) list).ensureCapacity(100000);
//        for (int i = 0; i < 100000; i++) {
//            list.add(i);
//        }
//        List list = new ArrayList(0);
//        list.add("aaa");
        //myself
//        com.ghj.list.List listSelf = new com.ghj.list.ArrayList();
//        listSelf.add("aaa");
//        listSelf.add("aaa");
//        listSelf.add(null);
//        listSelf.removeAll("aaa");
//        Class<Object[]> aClass = Object[].class;
//        System.out.println("self list:" + listSelf);

        //jdk
//        LinkedList linkedList = new LinkedList();
//        linkedList.add("aaa");
//        linkedList.add("bbb");
//        linkedList.add("aaa");
//        linkedList.remove("aaa");
//        System.out.println(linkedList.toString());

        //self
//        com.ghj.list.LinkedList linkedList1 = new com.ghj.list.LinkedList();
//        linkedList1.add("aaa");
//        linkedList1.add("bbb");
//        System.out.println(linkedList1.removeAll("aaa"));

//        System.out.println(Objects.hashCode(new Object()));
//        System.out.println(Objects.hashCode(new ArrayList<>()));
//        System.out.println(Objects.hashCode(new ArrayList<>()));
//        System.out.println(Objects.hashCode(new HashMap<>()));
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        objectObjectHashMap.put("aaa","bbb");
//        System.out.println(Objects.hashCode(objectObjectHashMap));
//
//        System.out.println(Objects.hashCode(Integer.valueOf(10)));
//        System.out.println(Objects.hashCode(Integer.valueOf(11)));
//        System.out.println(Objects.hashCode(Integer.valueOf(50)));

//        HashMap hashMap = new HashMap(4);
//        hashMap.put(null,null);
//        hashMap.put(null,null);
//        hashMap.put(null,null);
//        hashMap.put(null,null);




        int a = 1 << 30;
        int b = Integer.MAX_VALUE;

        System.out.println(a);
        System.out.println(b);





    }
}
