package list;

public class AddTwoList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;


        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        System.out.println(addTwoList(l1, l4));
    }

    public static int addTwoList(ListNode l1, ListNode l2) {
        int i = 1;
        int num1 = 0;
        int num2 = 0;
        while (l1 != null) {
            num1 = num1 + l1.val * i;
            i *= 10;
            l1 = l1.next;
        }
        int j = 1;
        while (l2 != null) {
            num2 = num2 + l2.val * j;
            j *= 10;
            l2 = l2.next;
        }
        return num1 + num2;
    }
}
