package list;

public class DeleteKNode {
    public static void main(String[] args) {

    }

    private static void deleteKNode(ListNode head, int k) {
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
    }
}
