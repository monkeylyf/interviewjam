/*Rotate_List

Given a list, rotate the list to the right by k places, where k is
non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/


class leetcode_Rotate_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        rotateRight(head, 1);
    }
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        ListNode prev = head;
        ListNode t = head;
        int cnt = 0;
        while (t != null) {
            // Move t down to the right node, which is n-nodes away from head.
            // Or break reach the end of linked list.
            t = t.next;
            ++cnt;
            if (cnt == n) {
                break;
            }
        }
        if (t == null && cnt <= n) {
            // length of this linked list cnt is less than n.
            // rotateRigth(1->2->3, 4) is equal to rotateRight(1->2->3, 1)
            return rotateRight(head, n % cnt);
        }
        while (t.next != null) {
            // Slide down to the end of linked list.
            t = t.next;
            prev = prev.next;
        }
        ListNode newhead = prev.next;
        t.next = head;
        prev.next = null;
        return newhead;
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
