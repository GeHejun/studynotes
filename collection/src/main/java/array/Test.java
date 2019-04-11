package array;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList(3);
        list.add(0,"aaa");
        list.add(1,"bbb");
        list.add(0,"ccc");
        list.add(0,"ddd");
        System.out.println(list.toString());

    }
}
