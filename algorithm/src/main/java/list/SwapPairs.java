package list;

/**
 * @author GeHejun
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        swapPairs(l1);
    }
    public static ListNode swapPairs(ListNode head) {
        int i = 1;
        ListNode first = head;
        ListNode second = head;
        while (first != null && first.next != null) {
            first = first.next;
            if (i % 2 == 1) {
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
            second = second.next;
            i++;
        }
        return head;
    }
}
