/*Implement a MyQueue class which implements a queue using two stacks*/


class test_18 {
	public static void main(String[] args) {
		my q = new my();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	}
}

class my {
	Stack buffer, catcher;
	public my() {
		buffer = new Stack();
		catcher = new Stack();
	}
	public void enQueue(int d) {buffer.push(d);}
	public int deQueue() {
		while (!buffer.isEmpty()) {catcher.push(buffer.pop());}
		int tmp = catcher.pop();
		while (!catcher.isEmpty()) {buffer.push(catcher.pop());}
		return tmp;
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
			int d = top.data;
			top = top.next;
			return d;
		}
		return Integer.MAX_VALUE;
	}

	public boolean isEmpty() {return top == null;}
}


class Node {
	Node next = null;
	int data;
	public Node(int d) {data = d;}
}
