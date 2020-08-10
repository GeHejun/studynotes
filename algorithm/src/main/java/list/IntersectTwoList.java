package list;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gehj
 * @version 1.0
 * @description TODO
 * @date 2020/8/10 12:57
 */
public class IntersectTwoList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        node.next = node2;
        node1.next = node2;
        System.out.println(intersectTwoList(node1, node));

    }
    public static boolean intersectTwoList(ListNode node1, ListNode node2) {
        Map<ListNode, ListNode> listNodeMap = new HashMap<>();
        while (node1.next != null) {
            listNodeMap.put(node1, node1);
            node1 = node1.next;
        }

        while (node2.next != null) {
            if (listNodeMap.get(node2) != null) {
                return true;
            }
            node2 = node2.next;
        }
        return false;
    }
}
