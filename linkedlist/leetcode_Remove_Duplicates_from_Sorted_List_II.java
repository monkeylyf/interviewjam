/**
 * Remove_Duplicates_from_Sorted_List_II.
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */


class leetcode_Remove_Duplicates_from_Sorted_List_II {

  public static void main(String[] args) {

  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode prev = new ListNode(0);
    ListNode res = prev;
    prev.next = head;
    while (head.next != null) {
      if (head.val != head.next.val) {
        if (prev.next == head) {
          // if prev.next is head, meaning no duplicate. e.g., 1 -> 2
          prev = prev.next;
        } else {
          // Duplicates detected and cut off all duplicate nodes.
          prev.next = head.next;
        }
      }
      head = head.next; // keep moving so while loop won't be infinite.
    }
    if (prev.next != head) {
      // After while loop, still gotta check prev & head.
      prev.next = null;
    }
    return res.next;
  }
}

/* Python Version
def deleteDuplicates(self, head):
    if not head:
        return head
    # Dummy head needed
    dummy = ListNode(-1)
    dummy.next = head

    prev = dummy
    cursor = head

    while cursor.next:
        if cursor.val != cursor.next.val:
            if prev.next == cursor:
                prev = prev.next
            else:
                prev.next = cursor.next
        cursor = cursor.next

    if prev.next != cursor:
        prev.next = None

    return dummy.next
*/
