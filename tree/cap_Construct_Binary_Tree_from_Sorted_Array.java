/*Construct_Binary_Tree_from_Sorted_Array
careercup

Given a sorted (increasing order) array, write an algorithm to create a
binary tree with minimal height*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;


class cap_Construct_Binary_Tree_from_Sorted_Array {
	public static void main(String[] args) {
		int len = 7;
		int[] arr = new int[len];
		for (int i = 0; i < len; ++i) arr[i] = i;
		Tree t = new Tree();
		t.createWithMinHeight(arr);
		t.bft();
		System.out.println("--------");
		t.dft();
	}
}

class Tree {
	public Node root;
	public void createWithMinHeight(int[] arr) {
        root =  addToTree(arr, 0, arr.length -1);
    }
	public Node addToTree(int[] arr, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) /  2;
		Node node = new Node();
		node.data = arr[mid];
		node.l = addToTree(arr, start, mid - 1);
		node.r = addToTree(arr, mid + 1, end);
		return node;
	}
	public void bft() {
		Queue<Node> unvisited = new LinkedList<Node>();
		unvisited.add(root);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.remove();
			System.out.println(cur.data);
			if (cur.l != null) unvisited.add(cur.l);
			if (cur.r != null) unvisited.add(cur.r);
		}
	}
	public void dft() {
		Stack<Node> unvisited = new Stack<Node>();
		unvisited.push(root);
		while (!unvisited.isEmpty()) {
			Node cur = unvisited.pop();
			System.out.println(cur.data);
			if (cur.l != null) unvisited.push(cur.l);
			if (cur.r != null) unvisited.push(cur.r);
		}
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
