/*Merge_Two_Sorted_Lists

Merge two sorted linked lists and return it as a new list. The new list should
be made by splicing together the nodes of the first two lists.
*/

class leetcode_Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        ListNode prev = new ListNode(0);
        prev.next = l1;
        ListNode cur = l1;
        ListNode head = prev;
        while (l2 != null) {
            if (cur.val < l2.val) {
                if (cur.next != null) {
                    // cur ptr and prev ptr move by one step.
                    prev = cur;
                    cur = cur.next;
                } else {
                    // Simply copy l2 to cur.next and done.
                    cur.next = l2;
                    break;
                }
            } else {
                // Must be: prev.val >= l2.val >= cur.val.
                ListNode temp = l2.next;
                prev.next = l2;
                l2.next = cur;
                // Move by one step.
                prev = l2;
                l2 = temp;
            }
        }
        return head.next;
    }
}
