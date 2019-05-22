package list;

import java.math.BigInteger;

/**
 * @author gehj
 */
public class ListAddTwoNumbers {



    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);


        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(9);
        l4.next = l5;
        ListNode l6 = new ListNode(9);
        l5.next = l6;
        ListNode l7 = new ListNode(9);
        l6.next = l7;
        ListNode l8 = new ListNode(9);
        l7.next = l8;
        ListNode l9 = new ListNode(9);
        l8.next = l9;
        ListNode l10 = new ListNode(9);
        l9.next = l10;
        ListNode l11 = new ListNode(9);
        l10.next = l11;
        ListNode l12 = new ListNode(9);
        l11.next = l12;
        ListNode l13 = new ListNode(9);
        l12.next = l13;
        System.out.println(listAddTwoNumbers(l1,l4).toString());

    }
    public static ListNode listAddTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger i = BigInteger.valueOf(1);
        BigInteger j = BigInteger.valueOf(1);
        BigInteger sum = BigInteger.valueOf(0);
        while (l1 != null) {
            sum = sum.add(BigInteger.valueOf(l1.val).multiply(i));
            l1 = l1.next;
            i = i.multiply(BigInteger.valueOf(10));
        }
        while (l2 != null) {
            sum = sum.add(BigInteger.valueOf(l2.val).multiply(j));
            l2 = l2.next;
            j = j.multiply(BigInteger.valueOf(10));
        }

        BigInteger k = BigInteger.valueOf(10);
        ListNode head = new ListNode(Integer.valueOf(sum.remainder(k).toString()));
        sum = sum.mod(k);
        ListNode start = head;
        while (sum.compareTo(BigInteger.valueOf(0)) > 0) {
            ListNode node = new ListNode(Integer.parseInt(sum.remainder(k).toString()));
            start.next = node;
            start = node;
            sum = sum.mod(k);
        }
        return head;
    }


    static class ListNode {


        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }


    }


}
