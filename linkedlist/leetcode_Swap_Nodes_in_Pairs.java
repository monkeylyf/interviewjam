/*Swap_Nodes_in_Pairs

Given a linked list, swap every two adjacent nodes and return its head.
For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.
Your algorithm should use only constant space. You may not modify the values in
the list, only nodes itself can be changed.
*/


class leetcode_Swap_Nodes_in_Pairs {
    public static void main(String[] args) {
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prev = res;
        ListNode tail = head.next;
        int count = 0;
        while (tail != null) {
            if (count % 2 == 0) {
                prev.next.next = tail.next;
                tail.next = prev.next;
                prev.next = tail;
                tail = tail.next;
            }
            ++count;
            prev = prev.next;
            tail = tail.next;
        }
        return res.next;
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
