/*Implement an algorithm to find the nth to last element of a singly linked list*/


class test_10 {
	public static void main(String[] args) {
		Node ll = new Node("F");
		ll.addToTail("U");
		ll.addToTail("C");
		ll.addToTail("K");
		ll.addToTail("M");
		ll.addToTail("Y");
		ll.addToTail("L");
		ll.addToTail("I");
		ll.addToTail("F");
		ll.addToTail("E");
		ll.addToTail("S");
		ll.addToTail("H");
		ll.addToTail("I");
		ll.addToTail("T");
		my(ll, 3);
	}

	public static void my(Node entry, int n) {
		Node tail = entry;
		for (int i = 0; i < n; ++i) {tail = tail.next;}
		while (tail != null) {tail = tail.next; entry = entry.next;}
		System.out.println(entry.data);
	}


class Node {
	Node next = null;
	String data;
	public Node(String d) {data = d;}
	void addToTail(String str) {
		Node node = this;
		while (node.next != null) {node = node.next;}
		node.next = new Node(str);
	}
}
