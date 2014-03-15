/** leetcode_Reorder_List.
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */



public class leetcode_Reorder_List {
  
  public static void main(String[] args) {
	// Test case 1.
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
	reorderList(head);
	// Test case 2.
	head.next.next.next = new ListNode(4);
	reorderList(head);
  }

  public static void reorderList(ListNode head) {
	if (head == null || head.next == null || head.next.next == null) {
	  return;  
	}

	// Measure the length of linked list.
	int length = 0;
	ListNode cursor = head;
	while (cursor != null) {
	  cursor = cursor.next;
	  ++length;
	}

	// Find the node that breaks original ll into two and len(left) >= len(right).
	cursor = head;
	for (int i = 1; i < (length + 1) / 2; ++i) {
	  cursor = cursor.next;  
	}
	// Break the chain.
	ListNode second_head = cursor.next;
	cursor.next = null;

	// Reverse the right linkedlist.
	second_head = reverseSLL(second_head);

	cursor = head;

	// Intertwine these two linked list.
	while (second_head != null) {
	  ListNode second_next = second_head.next;
	  second_head.next = cursor.next;
	  cursor.next = second_head;
	  cursor = cursor.next.next;
	  second_head = second_next;
	}

	printSLL(head);
  }

  public static ListNode reverseSLL(ListNode head) {
	if (head == null || head.next == null) {
	  return head;
	}

	ListNode dummy = new ListNode(-1);
	dummy.next = head;

	head = dummy;

	ListNode cursor = dummy.next;

	while (cursor.next != null) {
	  ListNode tmp = cursor.next;
	  cursor.next = tmp.next;
	  tmp.next = dummy.next;
	  dummy.next = tmp;
	}

	return dummy.next;
  }

  static class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
	  this.val = val;
	  this.next = null;
	}

	public String toString() {  return this.val + " ->"; }
  }

  public static void printSLL(ListNode head) {
	while (head != null) {
	  System.out.print(head + " ");
	  head = head.next;
	}
	System.out.println("null");
  }
}
