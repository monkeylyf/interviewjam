/*Merge_Two_Linkedlists_At_Alternate_Positions
geeksforgeeks

Given two linked lists, insert nodes of second list into first list at alternate
positions of first list.
For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6,
the first list should become 5->12->7->10->17->2->13->4->11->6 and second list
should become empty. The nodes of second list should only be inserted when there
are positions available.
For example, if the first list is 1->2->3 and second list is 4->5->6->7->8,
then first list should become 1->4->2->5->3->6 and second list to 7->8.
*/


public class Merge_Two_Linkedlists_At_Alternate_Positions {
	
	public static void main(String[] args) {
		// Test case 1
		Node p = new Node(5);
		p.next = new Node(7);
		p.next.next = new Node(17);
		p.next.next.next = new Node(13);
		p.next.next.next.next = new Node(11);
		Node q = new Node(12);
		q.next = new Node(10);
		q.next.next = new Node(2);
		q.next.next.next = new Node(4);
		q.next.next.next.next = new Node(6);

		print(p);
		print(q);
		q = mergeLinkedList(p, q);
		print(p);
		print(q);
		// Test case 2.
		p = new Node(1);
		p.next = new Node(2);
		p.next.next = new Node(3);
		q = new Node(4);
		q.next = new Node(5);
		q.next.next = new Node(6);
		q.next.next.next = new Node(7);
		q.next.next.next.next = new Node(8);

		print(p);
		print(q);
		q = mergeLinkedList(p, q);
		print(p);
		print(q);
	}

	public static Node mergeLinkedList(Node p, Node q) {
		if (p == null) {
			return q; // No alternate positions.
		}
		Node p_next, q_next;
		while (p != null && q != null) {
			p_next = p.next;
			q_next = q.next;
			// Insert p between p and next.
			p.next = q;
			q.next = p_next;
			// Both pointers of q and p move to next.
			q = q_next;
			p = p_next;
		}
		// Note:
		// In java, call by reference means if you change object's contents in a
		// method, the changed contents will be available to the calling context.
		// However if you are only playing with the reference pointer, then there
		// will not be any side-effect.
		// That's why I chose to return q to override the outside this function.
		return q;
	}

	// Helper funtion.
	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.val + " -> ");	
			head = head.next;
		}
		System.out.println("null");
	}

	static class Node {
		Node next;
		int val;

		Node(int val) {
			this.next = null;
			this.val = val;
		}
	}
}
