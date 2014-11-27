/**
 * leetcode_Intersection_of_Two_Linked_lists.
 *
 */


public class leetcode_Intersection_of_Two_Linked_lists {

  public static void main(String[] args) {
    System.out.println("hello world");
    leetcode_Intersection_of_Two_Linked_lists solution = new leetcode_Intersection_of_Two_Linked_lists();
  }

  /**
   * Find out the length diff and move header of the longer linked list forward by the diff.
   * With the same length, move both header forward until they are the same node.
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    int lengthA = getLength(headA);
    int lengthB = getLength(headB);

    int lengthDiff = Math.abs(lengthA - lengthB);

    if (lengthA > lengthB) {
      // Swap.
      ListNode tmp = headA;
      headA = headB;
      headB = tmp;
    }

    // Now headA.length <= headB.length.
    while (lengthDiff > 0) {
      headB = headB.next;
      lengthDiff -= 1;
    }

    // Now headA and headB has same number of nodes.
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }

    return headA;
  }

  private int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
      head = head.next;
      length += 1;
    }

    return length;
  }

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      this.val = x;
      this.next = null;
    }
  }
}
