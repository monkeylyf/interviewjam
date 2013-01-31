/*Remove_Duplicates_from_Sorted_List

Given a sorted linked list, delete all duplicates such that each element appear
only once.
For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

class leetcode_Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        deleteDuplicates(head);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        // The idea behind this solution is same as 
        // leetcode_Remove_Duplicates_from_Sorted_Array
        if (head == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode processed = node;
        ListNode prev = head;
        while (node != null) {
            ListNode cur = head;
            while (cur != processed) {
                if (cur.val == node.val) {
                    break;
                }
                cur = cur.next;
            }   
            if (cur == processed) {
                processed.val = node.val;
                processed = processed.next;
                prev = prev.next;
            }   
            node = node.next;
        }
        prev.next = null;
        return head;
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
