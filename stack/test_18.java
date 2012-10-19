/*Implement a MyQueue class which implements a queue using two stacks*/


class test_18 {
	public static void main(String[] args) {
		Queue q = new Queue();
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

class Queue {
	Stack buffer;
	Stack tank;

	public Queue() {
		buffer = new Stack();
		tank = new Stack();
	}	
	public void enQueue(int d) {tank.push(d);}

	public int deQueue() {
		while (tank.top != null) {buffer.push(tank.pop());}
		int d = buffer.pop();
		while (buffer.top != null) {tank.push(buffer.pop());}
		return d;
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
}


class Node {
	Node next = null;
	int data;
	public Node(int d) {data = d;}
}
