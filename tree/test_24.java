/*Write an algorithm to find the ‘next’ node (e g , in-order successor) of a given
node in a binary search tree where each node has a link to its parent
FOLLOWUP
If there is no link to its parent?*/
import java.util.*;


class test_24 {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.root = new Node();
		t.root.data = 15;
		Node n6 = new Node();
		n6.data = 6;
		Node n18 = new Node();
		n18.data = 18;
		Node n3 = new Node();
		n3.data = 3;
		Node n7 = new Node();
		n7.data = 7;
		Node n17 = new Node();
		n17.data = 17;
		Node n20 = new Node();
		n20.data = 20;
		Node n2 = new Node();
		n2.data = 2;
		Node n4 = new Node();
		n4.data = 4;
		Node n13 = new Node();
		n13.data = 13;
		Node n16 = new Node();
		n16.data = 16;
		Node n9 = new Node();
		n9.data = 9;

		t.root.r = n18;
		n18.p = t.root;
		t.root.l = n6;
		n6.p = t.root;

		n6.r = n7;
		n7.p = n6;
		n6.l = n3;
		n3.p = n6;

		n3.r = n4;
		n4.p = n3;
		n3.l = n2;
		n2.p = n3;

		n7.r = n13;
		n13.p = n7;
		n13.l = n9;
		n9.p = n13;

		n18.r = n20;
		n20.p = n18;
		n18.l = n17;
		n17.p = n18;

		n17.l = n16;
		n16.p = n17;
		t.bft();
		System.out.println("---------------");
		t.dft();
		System.out.println("---------------");
		t.dft();
		System.out.println("Testing successorWithParent---------------");
		System.out.println(t.successorWithParent(13).data);
		System.out.println(t.successorWithParent(18).data);
		System.out.println("Testing predecessorWithParent---------------");
		System.out.println(t.predecessorWithParent(15).data);
		System.out.println(t.predecessorWithParent(16).data);
		System.out.println("Testing successor---------------");
		System.out.println(t.successor(13).data);
		System.out.println(t.successor(18).data);
		System.out.println("---------------");
		System.out.println("---------------");
		System.out.println("---------------");
		Stack<Node> tmp = t.getTrace(t.root, 15);
		while(!tmp.isEmpty()) {
		        System.out.println(tmp.pop().data);
		}

		////////////////////////////////////////
		Tree t1 = new Tree();
		t1.insert(4);
		t1.insert(2);
		t1.insert(6);
		t1.insert(1);
		t1.insert(3);
		t1.insert(5);
		t1.insert(7);
		System.out.println("---------------");
		System.out.println(t1.getNode(t1.root, 7).data);
		System.out.println(t1.getNode(t1.root, 9));
	}
}

class Tree {
	public Node root;

	public void insert(int d) {
		Node node = new Node();
		node.data = d;
		root = getNext(root, node);
	}

	public Node getNext(Node entry, Node node) {
		if (entry == null) entry = node;
		else if (entry.data > node.data) {entry.l = getNext(entry.l, node);}
		else entry.r = getNext(entry.r, node);
		return entry;
	}

	public Node getNode(Node entry, int key) {
		if (entry == null) return null;
		Node n = entry;
		while (n.data != key) {
			if (n.data > key) n = n.l;
			else n = n.r;
			if (n == null) break;
		}
		return n;
	}

	public Stack<Node> getTrace(Node entry, int key) {
		Stack<Node> trace = new Stack<Node>();
		if (entry == null) return trace;
		Node n = entry;
		while (n.data != key) {
			trace.push(n);
			if (n.data > key) n = n.l;
			else n = n.r;
			if (n == null) break;
		}
		trace.push(n);
		return trace;
	}

	public Node find(int key) {return findNext(root, key);}

	public Node findNext(Node entry, int key) {
		if (entry == null) return null;
		else {
			if (entry.data == key) return entry;
			else if (entry.data > key) return findNext(entry.l, key);
			else return findNext(entry.r, key);
		}
	}

	public void bft() {
		Queue<Node> unvisited = new LinkedList<Node>();
		unvisited.add(root);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.remove();
			if(cur.l != null) unvisited.add(cur.l);
			if(cur.r != null) unvisited.add(cur.r);
			System.out.println(cur.data);
		}
	}

	public void dft() {
		Stack<Node> unvisited = new Stack<Node>();
		unvisited.push(root);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.pop();
			if(cur.l != null) unvisited.push(cur.l);
			if(cur.r != null) unvisited.push(cur.r);
			System.out.println(cur.data);
		}
	}

	public Node successorWithParent(int key) {
		Node cur = find(key);
		Node node = new Node();
		if (cur == null) return null;
		else if(cur.r != null) {
			node = cur.r;
			while (node.l != null) node = node.l;
			return node;
		} else if (cur.p == null) {return null;
		} else {node = cur;
			while (node.p.r == node) node = node.p;
			return node.p;
		}
	}

	public Node successor(int key) {
		Stack<Node> trace = getTrace(root, key);
		// Empty stack or stack has only one element, no successor.
		if (trace.isEmpty()) return null;
		Node cur = trace.pop();
		Node node = new Node();
		if (cur.r != null) {
		        node = cur.r; 
	                while (node.l != null) node = node.l;
		        return node;
		} else if (trace.isEmpty()) {return null;
		} else {while (!trace.isEmpty()) {
				node = trace.pop();
				if (node.l == cur) {return node;
				} else {cur = node;}
			}
			return null;
		}
		
	}

	public Node predecessorWithParent(int key) {
		Node cur = find(key);
		Node node = new Node();
		if (cur == null) return null;
		else if(cur.l != null) {
			node = cur.l;
			while (node.r != null) node = node.r;
			return node;
		} else if (cur.p == null) {return null;
		} else {node = cur;
			while (node.p.l == node) node = node.p;
			return node.p;
		}
	}
}


class Node {
	Node l;
	Node r;
	Node p;
	int data;
	public Node() {
		l = null;
		r = null;
		p = null;
		data = 0;
	}
}
