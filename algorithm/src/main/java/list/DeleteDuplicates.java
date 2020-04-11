package list;

import java.util.HashMap;
import java.util.Map;


/**
 * @author GeHejun
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.next = l2;
        ListNode l3 = new ListNode(1);
        l2.next = l3;
        ListNode l4 = new ListNode(1);
        l3.next = l4;
        deleteDuplicates(l1);
    }
    public static void deleteDuplicates(ListNode head) {
        Map map = new HashMap(16);
        ListNode node = head;
        for (;node != null && node.next != null; node = node.next) {
            if (map.get(node.val) == null) {
                map.put(node.val,node.val);
            }
            if (map.get(node.next.val) != null) {
                node.next = node.next.next;
            }
        }
    }
}
