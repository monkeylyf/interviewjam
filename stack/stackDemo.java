/*Describe how you could use a single array to implement three stacks*/

class stackDemo{
	public static void main(String[] args) {
		Stack s1 = new Stack();
		s1.push(1);
		s1.push('k');
		s1.push("FUCK THIS SHIT");
		s1.print();
		System.out.println("-----------"); 

		System.out.println(s1.pop()); 
		System.out.println(s1.pop()); 
		System.out.println(s1.pop()); 
		System.out.println(s1.pop()); 

		System.out.println("-----------");
		s1.push(1);
		s1.push('k');
		s1.push("FUCK THIS SHIT");
		System.out.println(s1.peek());
		System.out.println("-----------");
		Stack s2 = new Stack();
		System.out.println(s2.isEmpty());
		System.out.println(s2.pop());

		s2.push("FUCKTHISSHIT!");
		System.out.println(s2.peek());
		System.out.println(s2.pop());

	}

	public static void printNodes(Node node) {
		System.out.println(node.data);
	        while (node.next != null) {
                	node = node.next;
                	System.out.println(node.data);
	        }
	}
}


class Stack {
	Node top; // Always pointing at the top of this stack.
	public Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		System.out.println("Empty stack!" + top);
		return null;
	}

	public void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	public boolean isEmpty() {return top == null;}

	public void print() {
		Node node = top;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	public Object peek() {return top.data;}
}

class Node {
	Node next = null;
	Object data;
	public Node(Object d) {data = d;}
	public void addToTail(Object d) {
		Node end = new Node(d);
		Node node = this;
		while (node.next != null) {node = node.next;}
		node.next = end;
	}
}

// EOF.
