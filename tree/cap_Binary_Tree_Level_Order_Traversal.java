/*Binary_Tree_Level_Order_Traversal
careercup

Given a binary search tree, design an algorithm which creates a linked list
of all the nodes at each depth (eg, if you have a tree with depth D, you’ll
have D linked lists)

Marked as duplicate.

Please check:
leetcode_Binary_Tree_Level_Order_Traversal.java
*/

import java.util.*;

class cap_Binary_Tree_Level_Order_Traversal {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insert(4);
		t.insert(2);
		t.insert(6);
		t.insert(1);
		t.insert(3);
		t.insert(5);
		t.insert(7);
        // Test case.
        ArrayList<LinkedList<Node>> arr = t.breadthFirstCount();
        for (LinkedList<Node> ll : arr) {
            for (Node n : ll) System.out.print(n.data + " ");
            System.out.println();
		}
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
		if (entry == null) {
            entry = node;
		} else if (node.data < entry.data) {
            entry.l = getNext(entry.l, node);
		} else {
            entry.r = getNext(entry.r, node);
        }
		return entry;
	}
	public void bft() {
		Queue<Node> unvisited = new LinkedList<Node>();
		unvisited.add(root);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.remove();
			if(cur.l != null) {
                unvisited.add(cur.l);
            }
			if(cur.r != null) {
                unvisited.add(cur.r);
            }
			System.out.println(cur.data);
		}
	}
	public void dft() {
		Stack<Node> unvisited = new Stack<Node>();
		unvisited.push(root);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.pop();
			if(cur.r != null) {
                unvisited.push(cur.r);
            }
			if(cur.l != null) {
                unvisited.push(cur.l);
            }
			System.out.println(cur.data);
		}
	}
	public ArrayList<LinkedList<Node>> breadthFirstCount() {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		Queue<Node> unvisited = new LinkedList<Node>();
		LinkedList<Node> ll = new LinkedList<Node>();
		unvisited.add(root);
        int count = 1;
		while (true) {
			Node node = unvisited.remove();
			ll.add(node);
            if (node.l != null) {
                unvisited.add(node.l);
            }
            if (node.r != null) {
                unvisited.add(node.r);
            }
            if (--count == 0) {
                result.add(ll);
                ll = new LinkedList<Node>();
                count = unvisited.size();
            }
            if (unvisited.isEmpty()) {
                break;
            }
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
