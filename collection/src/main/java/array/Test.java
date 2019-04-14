package array;

import java.util.ArrayList;
import java.util.List;

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
        List list = new ArrayList(0);
        list.add("aaa");
        //myself
        array.List listSelf = new array.ArrayList();
        listSelf.add("aaa");
        listSelf.add("aaa");
        listSelf.add(null);
        listSelf.removeAll("aaa");
        Class<Object[]> aClass = Object[].class;
        System.out.println("self list:" + listSelf);


    }
}
