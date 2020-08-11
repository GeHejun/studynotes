package list;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/8/11 10:25
 */
public class CycleList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(2);
        ListNode next4 = new ListNode(2);
        ListNode next5 = new ListNode(2);
        head.next = next1;
        next1.next = next2;
        next2.next  = next3;
        next3.next = next4;
        next4.next = next5;
        next5.next = next3;

        System.out.println(isCycleList(head));

    }


    private static boolean isCycleList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (slow.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode tmp = slow.next;
                int i = 1;
                while (tmp != slow) {
                    tmp = tmp.next;
                    i++;
                }
                System.out.println(i);
                return true;
            }
        }
        return false;
    }
}
