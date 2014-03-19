/*leetcode_Copy_Linked_List_With_Random_Pointer
leetcode/Microsoft

Given a linkedlist which has next() and random().
next() points to next node and random() points to a random node in this
linkedlist.

Copy this linkedlist in O(n)


A linked list is given such that each node contains an additional random
pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/


class MS_Copy_Linked_List_With_Random_Pointer {

  public static void main(String[] args) {

  }

  public static ListNode copy(ListNode head) {
	if (head == null) {
	  return null;
	}

	RandomListNode cursor = head;
	// Given a -> b -> c -> null
	// Create a -> a -> b -> b -> c-> c -> null
	do {
	  RandomListNode node = cursor.next;
	  cursor.next = new RandomListNode(cursor.label);
	  cursor.next.next = node;
	  cursor = node;
	} while (cursor != null);

	// Point the random ref of copied node to copied.
	cursor = head;
	do {
	  cursor.next.random = (cursor.random == null) ? null : cursor.random.next;
	  cursor = cursor.next.next;
	} while (cursor != null);

	// Strip into two linkedlists.
	cursor = head;
	RandomListNode ret = cursor.next;

	for (RandomListNode n = ret; ; ) {
	  cursor.next = n.next;
	  cursor = cursor.next;

	  if (cursor == null) { break; }
	  n.next = cursor.next;
	  n = n.next;
	}

	return ret;
  }

  static class RandomListNode {
	RandomListNode next;
	RandomListNode random;
	int label;

	RandomListNode(int label) {
	  this.label = label;
	  this.next = null;
	  this.random = null;
	}
  }
}
