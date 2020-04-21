package list;

public class ReversePrint {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next1 = new ListNode(3);
        ListNode next2 = new ListNode(2);
        head.next = next1;
        next1.next = next2;
        final int[] ints = reversePrint(head);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] reversePrint(ListNode head) {
        int i = 0;
        ListNode node = head;
        while (head != null) {
            i++;
            head = head.next;
        }
        int[] tmp = new int[i];

        while (node != null) {
            tmp[i - 1] = node.val;
            node = node.next;
            i--;
        }
        return tmp;
    }
}
