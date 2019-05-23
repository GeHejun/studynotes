package list;

import java.math.BigInteger;
import java.util.List;

/**
 * @author gehj
 */
public class ListAddTwoNumbers {



    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);

        ListNode l4 = new ListNode(5);

        System.out.println(listAddTwoNumbers(l1,l4).toString());

    }
    public static ListNode listAddTwoNumbers(ListNode l1, ListNode l2) {

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


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }


}
