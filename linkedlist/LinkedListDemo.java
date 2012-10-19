import java.util.*;

class LinkedListDemo {
	public static void main(String[] args) {
	LinkedList<String> ll = new LinkedList<String>();
	ll.add("F");
	ll.add("U");
	ll.add("C");
	ll.add("K");
	ll.add("M");
	ll.add("Y");
	ll.add("L");
	ll.add("I");
	ll.add("F");
	ll.add("E");


	ll.addLast("!");
	ll.addFirst("!");
	System.out.println("The content of this linked list is: " + ll);

	Node node = new Node(1);
	node.appendToTail(2);
	node.appendToTail(3);
	node.appendToTail(4);
	node.appendToTail(5);
	
	System.out.println(node.data);
	while(node.next != null) {
		node = node.next;
		System.out.println(node.data);
		}
	}
}

class Node {
	// Node class has two fields.
	Node next = null;
	int data;
	// Node class has on 
	public Node(int d) {
		data = d;
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	void deleteNode(int d) {
		Node n = this;
	}
}

Node deleteNode(Node head, int d) {
	// Delete the first node with int equals d
	Node n = head;
	if (n.data == d) {
		return head.next;
	}
	while (n.next != null) {
		if (n.next.data == d) {
		n.next = n.next.next;
		return head;
		}
		n = n.next;
	}
}
