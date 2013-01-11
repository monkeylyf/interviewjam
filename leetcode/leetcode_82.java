/*Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.
For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/


class leetcode_82 {
    public static void main(String[] args) {
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode tail = res;
        ListNode node = res;
        while (n > 0) {
            tail = tail.next;
            --n;
        }
        while (tail.next != null) {
            tail = tail.next;
            node = node.next;
        }
        node.next = node.next.next;
        return res.next;        
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
