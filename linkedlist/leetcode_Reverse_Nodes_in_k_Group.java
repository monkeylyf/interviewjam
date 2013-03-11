/*Reverse_Nodes_in_k_Group

Given a linked list, reverse the nodes of a linked list k at a time and return
its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end
should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/


class leetcode_Reverse_Nodes_in_k_Group {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        reverseKGroup(head, 2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }   
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        int i = 0;
        while (head != null) {
            if (++i % k == 0) {
                // Reverse from pre to head, exclusive and inclusive respectively.
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return res.next;
    }
    public static ListNode reverse(ListNode pre, ListNode next) {
        // Interesting way to reverse linkedlist...
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;

            cur = last.next;
        }
        return last;
    }
}


class ListNode {
    ListNode next;
    int val;
    ListNode (int x) {
        val = x;
        next = null;
    }
}
