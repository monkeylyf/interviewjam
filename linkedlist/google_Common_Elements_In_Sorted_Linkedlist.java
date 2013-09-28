/*google_Common_Elements_In_Sorted_Linkedlist
google

5 -> 6 -> 6 -> 8
4 -> 4-> 6 -> 6 -> 8

Followup:
What if lengths of these two Linkedlist are very close.
What if one of the LinkedLists is extremely long, say, 1 million nodes.

Output: 6 -> 6 -> 8
*/


public class google_Common_Elements_In_Sorted_Linkedlist {

	/**
	 * The solution is based on merge sort.
	 * If two lengths are very close then merge sort will do.
	 * If one is extremely large then then the shorted one reach the end, then
	 * it can stop.
	 * Worst time complexity O(m + n)
	 */
	
	public static void main(String[] args) {
		// Test case 1.	
		ListNode a = new ListNode(5);
		insert(a, 6);
		insert(a, 6);
		insert(a, 8);
		print(a);
		ListNode b = new ListNode(4);
		insert(b, 4);
		insert(b, 6);
		insert(b, 6);
		insert(b, 8);
		print(b);
		// Test case 2.
		print(commonElement(a, b));
	}

	public static ListNode commonElement(ListNode a, ListNode b) {
		ListNode dummy =  new ListNode(0);
		ListNode cursor = dummy;
		while (a != null && b != null) {
			if (a.val == b.val) {
				cursor.next = new ListNode(a.val); // Copy common element.
				a = a.next;
				b = b.next;
				cursor = cursor.next;
			} else if (a.val > b.val) {
				b = b.next;	
			} else { // a.val < b.val
				a = a.next;	
			}
		}
		return dummy.next;	
	}

	public static int length(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			++len;
		}
		return len;
	}

	static class ListNode {
		ListNode next;
		int val;

		ListNode(int val) {
			this.next = null;
			this.val = val;
		}
	}

	public static void insert(ListNode head, int val) {
		ListNode cursor = head;
		while (head.next != null) {
			head = head.next;	
		}
		head.next = new ListNode(val);
	}

	public static void print(ListNode head) {
		while (head != null) {
			System.out.print(String.format("%d -> ", head.val));
			head = head.next;
		}
		System.out.println("null");
	}
}
