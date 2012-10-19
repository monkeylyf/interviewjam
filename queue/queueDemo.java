import java.lang.Exception;

class queueDemo {
	public static void main(String[] args) {
		myQueue q = new myQueue();
		q.enQueue(1);
		q.enQueue(2);
		System.out.println(q.deQueue());
		System.out.println(q.peek());
		System.out.println(q.deQueue());
	}
}


class myQueue {
	Node head, tail;

	public void enQueue(int d) {
		Node node = new Node(d);
		if (head == null && tail == null) head = tail = node;
		tail.next = node;
		tail = node;
	}

	public int deQueue() {
		//if (head == null && tail == null) {throw new EmptyStackException();}
		int data = head.data;
		if (head == tail) {
			head = tail = null;
		} else {head = head.next;}
		return data;
	}

	public boolean isEmpty() {
	        return head == null && tail == null;
	}

	public int peek() {return head.data;}
}

class Node {
	Node next = null;
	int data;

	public Node(int v) {data = v;}

	public void addToTail(int v) {
		Node end = new Node(v);
		Node node = this;
		while(node.next != null) {node = node.next;}
		node.next = end;
	}
}

//class EmptyStackException extends Exception {
//	public void MyException(String msg) {
//		super(msg);
//	}
//}
