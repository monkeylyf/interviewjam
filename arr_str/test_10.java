/*Implement an algorithm to find the nth to last element of a singly linked list*/


class test_10 {
	public static void main(String[] args) {
		Node ll = new Node("F"); // * 
		ll.addToTail("U");
		ll.addToTail("C");
		ll.addToTail("K");
		ll.addToTail("M");
		ll.addToTail("Y");
		ll.addToTail("L");
		ll.addToTail("I");      // *
		ll.addToTail("F");      // *
		ll.addToTail("E");
		ll.addToTail("S");
		ll.addToTail("H");
		ll.addToTail("I");      // *
		ll.addToTail("T");

		printNodes(ll);
		findNthElement(ll, 1);


		easierWay(ll, 14);

	}

	public static String findNthElement(Node head, int n) {
		int length = 1; // head node counts for 1. 
		Node node = head;
		while (node.next != null) {
			node = node.next;
			++length;}
		System.out.println("The length of this linkedlist is "+ length);
		if (n > length) return null;
		
		node = head;
		for (int i = 0; i < length - n; ++ i) {
			node = node.next;
		}
		System.out.println("The last " + n + "th element is " + node.data);
		return node.data;
	}

	public static String easierWay(Node head, int n) {
		// Assume length of this ll is larger than n,
		// So we do not need to iterate through this ll.
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < n - 1; i ++) {
			p2 = p2.next;
		}
		while (p2.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		System.out.println("The last " + n + "th element is " + p1.data);
		return p1.data;
	}

	public static void printNodes(Node node) {
	        System.out.println(node.data);
		while (node.next != null) {
			node = node.next;
		        System.out.println(node.data);
	        }
	}

}


class Node {
	Node next = null;
	String data;

	public Node(String d) {
		data = d;
	}

	void addToTail(String str) {
		Node end = new Node(str);
		Node node = this;
		
		while (node.next != null) {
			node = node.next;
		}
		node.next = end;
	}
}
