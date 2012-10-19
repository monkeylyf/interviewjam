/*Implement an algorithm to delete a node in the middle of a single linked list, given
only access to that node
EXAMPLE
Input: the node ‘c’ from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a->b->d->e
*/

class test_11 {

	public static void main(String[] args) {
		Node ll = new Node('F'); // * 
		ll.addToTail('U');
		ll.addToTail('C');
		ll.addToTail('K');
		ll.addToTail('M');
		ll.addToTail('Y');
		ll.addToTail('L');
		// ll.addToTail('!');

		printNodes(ll);
		Node middle = getMiddle(ll);
		System.out.println("The middle element is " +middle.data);
		printNodes(middle);
		System.out.println("--------");
		removeMiddle(middle);
	}

	public static void printNodes(Node node) {
	        System.out.println(node.data);
	        while (node.next != null) {
	                node = node.next;
	                System.out.println(node.data);
	        }
	}

	public static Node getMiddle(Node head) {
		Node p1 = head;
		int length = 1;
		while (p1.next != null) {
			p1 = p1.next;
			++length;
		}
		p1 = head;
		for (int i = 0; i < length / 2; ++i) {
			p1 = p1.next;	
		}
		return p1;
	}

	public static boolean removeMiddle(Node middle) {
		// This problem can not be solved if the node to be deleted
		// is the last node, which means it is a single node linkedlist.
		if (middle.next == null) return false;

		Node p1 = middle;
		Node p2 = middle.next;

		p1.data = p2.data;
		p1.next = p2.next;
		
		printNodes(middle);
		return true;
	}
}


class Node {
	Node next = null;
	char data;

	public Node (char d) {
		data = d;
	}

	void addToTail(char d) {
		Node end = new Node(d);
		Node node = this;

		while (node.next != null) {
			node = node.next;
		}
		node.next = end; 
	}
}
