package list;

/**
 * 未完成
 * @author GeHejun
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        removeNthFromEnd(l1,1);


    }



    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode target = head;
        ListNode res = target;
        int i = 0;
        for (; head != null; head = head.next) {
            i++;
            if (i == n) {
                target = head;
            }
            if (i > n) {
                target = target.next;
            }

        }
        if (target.next != null) {
            target.next = target.next.next;
        } else  {
            return null;
        }

        return res;
    }

}

