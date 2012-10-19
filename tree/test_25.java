/*Design an algorithm and write code to find the first common ancestor of two nodes
in a BINARY TREE(not bst). Avoid storing additional nodes in a data structure. 
NOTE: This is not necessarily a binary search tree
FOLLOWUP: what if it is a bst*/

import java.util.*;


class test_25 {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(4);
		t.insert(2);
		t.insert(6);
		t.insert(1);
		t.insert(3);
		t.insert(5);
		t.insert(7);
		t.bft();
		System.out.println("----------------");
		t.dft();
		System.out.println("----------------");
		System.out.println(t.root.data);

	}
}


class Tree {
	public Node root;

	public void insert(int d) {
		Node newNode = new Node();
		newNode.data = d;
		if (root == null) {
			root = newNode;
			return;
		}
		Node n = root;
		while (true) {
			if (d < n.data) {
				if (n.l == null) {
					n.l = newNode;
					break;
				} else {n = n.l;}
			} else {if (n.r == null) {
					n.r = newNode;
					break;
				} else {n = n.r;}
			}
		}
	}

	public void bft() {
		Queue<Node> unvisited = new LinkedList<Node>();
		unvisited.add(root);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.remove();
			if (cur.l != null) unvisited.add(cur.l);
			if (cur.r != null) unvisited.add(cur.r);
			System.out.println(cur.data);
		}
	}

	public void dft() {
		Stack<Node> unvisited = new Stack<Node>();
		unvisited.push(root);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.pop();
			if (cur.r != null) unvisited.push(cur.r);
			if (cur.l != null) unvisited.push(cur.l);
			System.out.println(cur.data);
		}
	}
}


class Node {
	Node l;
	Node r;
	int data;
	public Node() {
		l = null;
		r = null;
		data = 0;
	}
}


