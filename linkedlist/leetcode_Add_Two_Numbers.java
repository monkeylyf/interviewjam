/*Add Two Numbers

You are given two linked lists representing two non-negative numbers. The
digits are stored in reverse order and each of their nodes contain a single
digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

class leetcode_Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        addTwoNumbers(l1, l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        int offset = 0;
        while (true) {
            // Neither is null.
            if (l1 != null && l2 != null) {
                l3.next = new ListNode((l1.val + l2.val + offset) % 10);
                offset = (l1.val + l2.val + offset) / 10;
                l1 = l1.next;
                l2 = l2.next;
                l3 = l3.next;
            // Both are null.
            } else if ( l1 == null && l2 == null) {
                if (offset == 1) {
                    l3.next = new ListNode(1);
                }
                break;
            // Either one node is null.
            } else if (l1 == null) {
                l3.next = new ListNode((l2.val + offset) % 10);
                offset = (l2.val + offset) / 10;
                l2 = l2.next;
                l3 = l3.next;
            } else {
                // l2 == null.
                l3.next = new ListNode((l1.val + offset) % 10);
                offset = (l1.val + offset) / 10;
                l1 = l1.next;
                l3 = l3.next;
            }
        }
        return head.next;
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
