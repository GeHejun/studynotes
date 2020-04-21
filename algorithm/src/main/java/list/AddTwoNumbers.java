package list;

/**
 *
 * @author GeHejun
 */
public class AddTwoNumbers {



    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);

        ListNode l4 = new ListNode(5);

        System.out.println(addTwoNumbers(l1,l4).toString());

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int nextVal = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        while (l1 != null || l2 != null ) {
            ListNode node = new ListNode(((l1 == null? 0:l1.val) + (l2 == null? 0:l2.val) + nextVal) % 10);
            nextVal = ((l1 == null? 0:l1.val) + (l2 == null? 0:l2.val) + nextVal) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            head.next = node;
            head = head.next;
        }
        if (nextVal > 0) {
            head.next = new ListNode(1);
        }
        return res.next;
    }

//    0、字符串hshaksdhqqkqwkasfa,shgjqijasjkdhajkcsnidh取出所有相邻a和s之间的字符串并排序
//    //归并
//// int i = 0; j = 0;
//// String
//// while() {
//// }
//    String str = "hshaksdhqqkqwkasfa,shgjqijasjkdhajkcsnidh";
//    String[] as = str.split("a");
//        for (int i = 0; i < as.length; i++) {
//        if (as[i].contains("s")) {
//            as[i] = as[i].subSequence(0, as[i].indexOf("s")).toString();
//        }
//    }
//        System.out.println(Arrays.stream(as).sorted(String::compareTo).collect(Collectors.joining()));
//
//
//1、有100个任务需要分成10批执行，每批执行执行有顺序（即第一批执行完执行第二批）
//    如果是一台机器上如何实现（代码实现），  如果是多机器集群如何实现（架构说明）
//    public class Test implements Runnable {
//
//        private static int i = 1;
//
//
//        @Override
//        public void run() {
//            synchronized (this) {
//                System.out.println(i++);
//            }
//        }
//    }
//
//    public class Main {
//
//        public static void main(String[] args) {
//            test();
//        }
//        public static void test() {
//            for (int i = 0; i < 10; i++) {
//                new Thread(new Test()).start();
//
//            }
//        }
//    }
//
//
//
//2、给下面两个表，计算代理人1001(agent_id) 在航空公司MU(airline)
//            2018-01-01的目的地国家(country_code)覆盖度 并说明如何建索引能提高查询速度。
//    目的地国家覆盖度定义为代理人在某个航空公司下的目的地国家数量/该航空公司的目的地国家数量
//    表A 目的地城市搜索记录样表
//    time	       agent_id	airline	dest_city_code
//2018-01-01 12:12:12	1000	CA	       TYO
//2018-01-01 12:12:13	1001	MU	       SIN
//2018-01-01 12:12:15	1000	CA	       TYO
//2018-01-01 12:12:15	1000	MU	       SEL
//...	...	...	...
//        2018-03-21 23:59:59	1001	MU		   SEL
//    表B 城市-国家映射样表
//    city_code	country_code
//    TYO			JP
//    SEL			KP
//    SIN			SG
//...			...
//
//
//    select count(b.country_code) / count(a.airline) from A a inner join B b on a.dest_city_code = b.city_code  where a.time = date('2018-01-01') group by a.airline
//
//



}
