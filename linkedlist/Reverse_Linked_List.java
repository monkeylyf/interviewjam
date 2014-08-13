/**
 * Reverse_Linked_List.
 *
 * Interview Question 101
 */

public class Reverse_Linked_List {

  public static void main(String[] args) {
    test();
  }

  private static void test() {
    ListNode head = new ListNode(3);
    head.next = new ListNode(1);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(-1);

    printList(head);
    printList(reverseLinkedList(head));
  }

  private static ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null;

    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }

    return prev;
  }

  private static class ListNode {
    public final int val;
    public ListNode next;

    public ListNode(final int val) {
      this.val = val;
      this.next = null;
    }

    public String toString() { return "<" + this.val + ">"; }
  }

  private static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head);
      head = head.next;
    }
    System.out.println();
  }
}
