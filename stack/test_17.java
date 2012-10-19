/*In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of
different sizes which can slide on to any tower. The puzzle starts with disks sorted
in ascending order of size from top to bottom (e g ,each disk sits on top of an
even larger one) You have the following constraints:
pg 52
SOLUTION
(A) Only one disk can be moved at a time
(B) A disk is slid off the top of one rod onto the next rod
(C) A disk can only be placed on top of a larger disk Write a program to move the
disks from the first rod to the last using Stacks*/

class test_17 {
	public static void main() {
	
	}
}


class Stack {
	Node top;

	public void push(int d) {
		Node node = new Node(d);
		node.next = top;
		top = node;
	}

	public int pop() {
		if (top != null) {
			int data = top.data;
			top = top.next;
			return data;
		}
		return Integer.MAX_VALUE;
	}

	public Node peek() {return top;}

	public boolean isEmpty() {return top == null;}
}


class Node {
	Node next = null;
	int data;
	public Node(int d) {data = d;}
}
