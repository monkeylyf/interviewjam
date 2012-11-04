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
		System.out.println("Beginning node is " + my(a).data);
		
	}

	public static Node my(Node entry) {
		Node a1 = entry, a2 = entry;
		while (true) {
			a1 = a1.next;
			a2 = a2.next.next;
			if (a1 == a2) break;
		}
		while (true) {
			a1 = a1.next;
			entry = entry.next;
			if (entry == a1) break;
		}
		return entry;
	}
}


class Node {
	Node next = null;
	String data;
	public Node(String d) {data = d;}
	void addToTail(String d) {
		Node node = this;
		while (node.next != null) node = node.next;
		node.next = new Node(d);
	}
}
