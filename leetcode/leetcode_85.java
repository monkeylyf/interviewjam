/*Reverse Linked List II

Reverse a linked list from position m to n. Do it in-place and in one-pass.
For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,
return 1->4->3->2->5->NULL.
Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

class leetcode_85 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(-3);
        reverseBetween(head, 1, 1);
    
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode end = head;
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = null;
        ListNode x = res;
        while (true) {
            if (count >= m && count < n) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            } else if (count < m) {
                x = prev;
                prev = cur;
                cur = cur.next;
            } else if (count == n) {
                x.next.next = cur;
                x.next = prev;
                break;
            }
            ++count;
        }
        return res.next;
    }
    // Do a simple reverse LinkList first to rush up it.
    // Recursive way.
    public static ListNode reverse(ListNode head) {
        if (head == null) return head;
        if (head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = null;
        ListNode reversed = reverse(second);
        second.next = head;
        return reversed;
    }
    // While loop way.
    public static ListNode rev(ListNode head) {
        ListNode end = head;
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        end.next = null;
        return prev;
    }
}


class ListNode {
    ListNode next;
    int val;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
