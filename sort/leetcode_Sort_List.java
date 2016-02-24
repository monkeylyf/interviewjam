/**
 * leetcode_Sort_List.
 */

public class leetcode_Sort_List {

  public static void main(String[] args) {
	leetcode_Sort_List intance = new leetcode_Sort_List();
	intance.solve();
  }

  public void solve() {

  }

  public ListNode sortList(ListNode head) {
	if (head == null || head.next == null) {
	  return head;
	}

	/* Instead of measure the length of ll, use fast and slow to find the middle point.*/
	ListNode slow = head;
	ListNode fast = head.next;

	while (fast != null && fast.next != null) {
	  fast = fast.next.next;
	  slow = slow.next;
	}

	// Mark the head of second half and break it into tww halves.
	ListNode second = slow.next;
	slow.next = null;

	// Sort and merge.
	head = sortList(head);
	second = sortList(second);

	return merge(head, second);
  }

  private ListNode merge(ListNode left, ListNode right) {
	if (left == null) {
	  return right;
	}
	if (right == null) {
	  return left;
	}

	// Dummy is necessary.
	ListNode dummy = new ListNode(-1);
	dummy.next = left;

	ListNode prev = dummy;

	// Using left as base and insert nodes in right into left.
	while (prev.next != null && right != null) {
	  if (prev.next.val > right.val) {
		ListNode rightNext = right.next;
		right.next = prev.next;
		prev.next = right;
		right = rightNext;
	  }
	  prev = prev.next;
	}

	// If left reach the tail first then append right to the end.
	if (prev.next == null) {
	  prev.next = right;
	}

	return dummy.next;
  }
}
