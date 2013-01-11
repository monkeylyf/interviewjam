/*Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.
For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/


class leetcode_80 {
    public static void main(String[] args) {
    
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode h = new ListNode(0);
        ListNode res = h;
        h.next = head;
        while (head.next != null) {
            if (head.val != head.next.val) {
                if (h.next == head) h = h.next;
                else h.next = head.next;
            }
            head = head.next;
        }
        if (h.next != head) h.next = null;
        return res.next;
    }
}
