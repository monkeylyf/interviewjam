/*Implement an algorithm to delete a node in the middle of a single linked list, given
only access to that node.
EXAMPLE
Input: the node ‘c’ from the linked list a->b->c->d->e
Result: nothing is returned, but the new linked list looks like a->b->d->e
*/

class test_11 {

	public static void main(String[] args) {
		Node ll = new Node('F');
		ll.addToTail('U');
		ll.addToTail('C');
		ll.addToTail('K');
		printNodes(ll);
		my(ll.next);
		printNodes(ll);
	}

	// This givin input has one issue. What if n is the last node of this ll?
	// Without given previous, can it be done? preivous.next = null;....
	public static void my(Node n) {
		Node newNode = n.next;
		n.data = newNode.data;
		n.next = newNode.next;
	}

	public static void printNodes(Node node) {
		while (node != null) {
			System.out.print(node.data);
			node = node.next;
		}
		System.out.println("");
	}
}


class Node {
	Node next = null;
	char data;
	public Node (char d) {data = d;}
	void addToTail(char d) {
		Node node = this;
		while (node.next != null) {node = node.next;}
		node.next = new Node(d); 
	}
}
