/*Write a program to sort a stack in ascending order. You should not make any
assumptions about how the stack is implemented The following are the only
functions that should be used to write this program: push | pop | peek | 
isEmpty*/

import java.util.*;

class test_19 {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(5);
		s.push(1);
		s.push(3);
		s.push(-1);
		s.push(2);
		Stack r = my(s);
		r.printAll();
	}

	public static Stack my(Stack s) {
		Stack buffer = new Stack();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!buffer.isEmpty() && tmp < buffer.peek()) {
				s.push(buffer.pop());
			}
			buffer.push(tmp);
		}
		return buffer;
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

	public int peek() {
		if (top == null) return Integer.MAX_VALUE;
		return top.data;
	}

	public boolean isEmpty() {return top == null;}

	public void printAll() {
		Node node = top;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}


class Node {
	Node next = null;
	int data;
	public Node(int d) {data = d;}
}
