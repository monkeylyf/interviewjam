/*Given a binary search tree, design an algorithm which creates a linked list
of all the nodes at each depth (eg, if you have a tree with depth D, you’ll
have D linked lists)*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;

class test_23 {
	public static void main(String[] rags) {
		Tree t = new Tree();
		t.insert(4);
		t.insert(2);
		t.insert(6);
		t.insert(1);
		t.insert(3);
		t.insert(5);
		t.insert(7);
		System.out.println("----------------");
		t.bft();
		System.out.println("----------------");
		t.dft();
		System.out.println("----------------");
		//ArrayList<LinkedList<Node>> arr = t.breadthFirstCount();
		t.breadthFirstCount();
		System.out.println("----------------");
		//for (LinkedList<Node> ll : arr) {
		//	for (Node n : ll) {System.out.println(n.data);}
		//}
	}
}

class Tree {
	public Node root;

	public void insert(int d) {
		Node newNode = new Node();
		newNode.data = d;
		root = getNext(root, newNode);
	}

	public Node getNext(Node entry, Node node) {
		if (entry == null) entry = node;
		else if (node.data < entry.data) {entry.l = getNext(entry.l, node);}
		else entry.r = getNext(entry.r, node); 
		return entry;
	}

	public void bft() {
		Queue<Node> unvisited = new LinkedList<Node>();
		Queue<Node> visited = new LinkedList<Node>();
		unvisited.add(root);
		while(!unvisited.isEmpty()) {
			Node cur = unvisited.remove();
			if(cur.l != null) unvisited.add(cur.l);
			if(cur.r != null) unvisited.add(cur.r);
			System.out.println(cur.data);
		}
	}

	public void dft() {
		Stack<Node> unvisited = new Stack<Node>();
		unvisited.push(root);
		while(!unvisited.isEmpty()) {
			Node cur = unvisited.pop();
			if(cur.r != null) unvisited.push(cur.r);
			if(cur.l != null) unvisited.push(cur.l);
			System.out.println(cur.data);
		}
	}

	public ArrayList<LinkedList<Node>> breadthFirstCount() {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		Queue<Node> unvisited = new LinkedList<Node>();
		Queue<Node> temp = new LinkedList<Node>();

		unvisited.add(root);
		int layer = 1;
		int cnt = 0;
		LinkedList<Node> ll = new LinkedList<Node>();
		while(true) {
			Node node = unvisited.remove();
			temp.add(node);
			ll.add(node);
			++cnt;
			if (unvisited.isEmpty()) {
				System.out.println("Layer " + layer + " has " + cnt + " nodes:");
				for (Node n : ll) {System.out.println(n.data);}
				result.add(ll.clone());
				ll.clear();
				++layer;
				cnt = 0;
				while (!temp.isEmpty()) {
					Node cur = temp.remove();
					if (cur.l != null) unvisited.add(cur.l);
					if (cur.r != null) unvisited.add(cur.r);
				}
			}
			if (unvisited.isEmpty() && temp.isEmpty()) break;
		}
		return result;
	}
}


class Node {
	Node r;
	Node l;
	int data;
	public Node() {
		r = null;
		l = null;
		data = 0;
	}
}
