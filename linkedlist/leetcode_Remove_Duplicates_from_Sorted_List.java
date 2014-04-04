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
            return null;
        }
        ListNode cursor = head.next;
        ListNode processed = head;
        while (cursor != null) {
            if (cursor.val != processed.val) {
                processed.next.val = cursor.val;
                processed = processed.next;
            }
            cursor = cursor.next;
        }
        processed.next = null;
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

/* Python Version
def deleteDuplicates(self, head):
    if not head:
        return head

    processed = head
    cursor = head.next
    prev = head # Only need one pointer instead cursor and prev both, but having two is clearer.
    
    while cursor:
        if cursor.val != prev.val:
            processed.next.val = cursor.val
            processed = processed.next
        cursor = cursor.next
        prev = prev.next
    
	# Remove the rest    
    processed.next = None

    return head
*/
