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
	}

	public static Node my(boolean offset, Node a, Node b) {
		if (a == null && b == null) {return nulll;}
		Node result = new Node();
		int v
		if (1 != null) {value += }
	}
}

class Node {
	Node next = null;
	int data;
	public Node(int d) {data = d;}
	public void addToTail(int d) {
		Node node = this;
		while (node.next != null) {node = node.next;}
		node.next = new Node(d);
	}
}
