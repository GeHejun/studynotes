package com.ghj.java8;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        list.add(new User("李师师", 23, "女"));
        list.add(new User("陈圆圆", 26, "女"));
        list.add(new User("潘安", 24, "男"));
        list.add(new User("赵飞燕", 26, "女"));
        //统计为性别为女的个数
        System.out.println(list.toString());
        long count = list.stream().filter(s -> "女".equals(s.getSex())).count();
        System.out.println(count);
        System.out.println(list.toString());
        list.removeIf(x -> "女".equals(x.getSex()));
        System.out.println(list.toString());
    }
}
