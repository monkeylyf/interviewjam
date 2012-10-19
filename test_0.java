/*This is a sandbox for anything in java*/


import java.util.*;

class test_0 {
	public static void main(String[] args) {
		Node node = null;
		if (node == null) System.out.println("i is not inited!");

		Stack s = new Stack();
		System.out.println(s.isEmpty());
		System.out.println(s.peek());

	}
}

class Node {
	Node next = null;
	int data;
	public Node(int d) {data = d;}
	public void addToTail(int d) {
		Node end = new Node(d);
		Node node = this;
		while(node != null) node = node.next;
		node.next = end;
	}
}
