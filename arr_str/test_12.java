/*You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1’s digit is at the head of
the list. Write a function that adds the two numbers and returns the sum as a linked
list.
EXAMPLE
Input: (3 -> 1 -> 5), (5 -> 9 -> 2)
Output: 8 -> 0 -> 8
*/

class test_12 {
	public static void main(String[] args) {
		Node n1 = new Node(5);
		n1.addToTail(1);
		n1.addToTail(7);

		Node n2 = new Node(2);
		n2.addToTail(9);
		n2.addToTail(5);

		addNodes(n1, n2);
	}

	public static Node addNodes(Node n1, Node n2) {
		int offset = 0;
		Node sum = new Node((n1.data + n2.data + offset) % 10);
		if (n1.data + n2.data >= 10) offset = 1;
		n1 = n1.next;
		n2 = n2.next;

		while (n1 != null && n2 != null) {
			sum.addToTail((n1.data + n2.data + offset) % 10);
			if (n1.data + n2.data >= 10) {offset = 1;
			} else {offset = 0;}
			n1 = n1.next;
			n2 = n2.next;
			}

		if (n1 != null || n2 != null) {
			Node rest;
			if (n1 != null) {rest = n1;
			} else {rest = n2};

			wihle (rest.next != null) {
				sum.add((rest.data + offset) % 10);
				}
			}

		if (n1 = null && n2 = null) {
			if (offset == 1) sum.addToTail(1);
			printNodes(sum);			
			return sum;
			}
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
	int data;

	public Node(int d) {
		data = d;
	}

	public void addToTail(int d) {
		Node end = new Node(d);
		Node node = this;

		while (node.next != null) {
			node = node.next;
		}
		node.next = end;
	}
}
