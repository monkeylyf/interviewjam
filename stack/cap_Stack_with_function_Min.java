/*Stack_with_function_Min
careercup

How would you design a stack which, in addition to push and pop, also has a
functionmin which returns the minimum element? Push, pop and min should all
operate in O(1) time
*/

import java.util.Stack;

class cap_Stack_with_function_Min {
	public static void main(String[] args) {
		myS s = new myS();
		s.push(1);
		System.out.println(s.min());
		s.push(2);
		System.out.println(s.min());
		s.push(-3);
		System.out.println(s.min());
		s.push(4);
		System.out.println(s.min());
		System.out.println("--------------");
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
	}
}


class myS {
	Node top;
	int curmin = Integer.MAX_VALUE;

	public void push(int d) {
		curmin = Math.min(d, curmin);
		Node n = new Node(d, curmin);
		n.next = top;
		top = n;
	}

	public int pop() {
		if (top != null) {
			int data = top.data;
			top = top.next;
			curmin = top.min;
			return data;
		}
		return Integer.MAX_VALUE;
	}

	public int min() {
		return top.min;
	}

	public int peek() {
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
}


class myStack extends Stack<Node> {
	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new Node(value, newMin));
	}

	public int min() {
		if (this.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min;
		}
	}
}


class Node {
	Node next;
	int data;
	int min;
	public Node(int d, int minimum) {
		this.next = null;
		this.data = d;
		this.min = minimum;
	}
}
