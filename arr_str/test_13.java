/*Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
Definition:
Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node,
so as to make a loop in the linked list.
EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
*/

class test_13 {
	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
	  	Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");
		Node j = new Node("J");
		Node k = new Node("K");

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;
		j.next = k;
		k.next = d;	// Beginning node!

		Node begin = findBeginningNode(a);
		System.out.println("Beginning node is " + begin.data);
		
	}

	public static Node findBeginningNode(Node head) {
		Node p1 = head; // Jump to next node.
		Node p2 = head;	// Jump to next next node.

		while (p1.next != p2.next.next) {
			p1 = p1.next;
			p2 = p2.next.next;
		}
		p1 = p1.next;
		p2 = p2.next.next;
	
		p1 = head;
		while (p1.next != p2.next) {
		        p1 = p1.next;
		        p2 = p2.next;
		}
		return p1.next;
	}

	public static void printNodes(Node head) {
		Node node = head;
		while (node.next != null) {
			System.out.println(node.data);
			node = node.next;
		}
		System.out.println(node.data);
	}
}


class Node {
	Node next = null;
	String data;

	public Node(String d) {
		data = d;
	}

	void addToTail(String d) {
		Node end = new Node(d);
		Node node = this;
		while (node.next != null) node = node.next;
		node.next = end;
	}
}
