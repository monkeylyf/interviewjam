/*How would you design a stack which, in addition to push and pop, also has a
functionmin which returns the minimum element? Push, pop and min should all
operate in O(1) time*/

import java.util.Stack;

class test_15 {
	public static void main(String[] args) {
		myStack mys = new myStack();
		mys.push(1);
		mys.push(2);
		mys.push(-3);
		mys.push(4);
		System.out.println(mys.min());
		System.out.println("--------------");
		stack s = new stack();
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


class stack {
	Node top;
	int localMin = Integer.MAX_VALUE;
	public void push(int d) {
		localMin = Math.min(localMin, d);
		Node node = new Node(d, localMin);
		node.next = top;
		top = node;
	}

	public int pop() {
		if (top != null) {
			int d = top.data;
			top = top.next;
			if (localMin <= d) localMin = top.min;
			return d;
		}
		return Integer.MAX_VALUE;
	}

	public int min() {return peek().min;}

	public Node peek() {return top;}

	public boolean isEmpty() {return top == null;}
}

class Node {
	Node next = null;
	int data;
	int min;
	
	public Node(int d, int minimum) {
		data = d;
		min = minimum;
	}
}
