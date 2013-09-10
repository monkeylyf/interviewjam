/*Construct_Binary_Tree_from_Sorted_Array
careercup

Given a sorted (increasing order) array, write an algorithm to create a
binary tree with minimal height.
*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;


public class cap_Construct_Binary_Tree_from_Sorted_Array {
	

	// Since minimal height is required, start with mid element.

	public static void main(String[] args) {
		int len = 7;
		int[] arr = new int[len];
		for (int i = 0; i < len; ++i) {
			arr[i] = i;
		}
		Tree t = new Tree();
		t.createWithMinHeight(arr);
		t.bft();
		System.out.println("--------");
		t.dft();
	}
}

class Tree {
	public TreeNode root;

	public void createWithMinHeight(int[] arr) {
        root =  addToTree(arr, 0, arr.length -1);
    }

	public TreeNode addToTree(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) /  2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = addToTree(arr, start, mid - 1);
		node.right = addToTree(arr, mid + 1, end);
		return node;
	}

	public void bft() {
		Queue<TreeNode> unvisited = new LinkedList<TreeNode>();
		unvisited.add(root);
		while (!unvisited.isEmpty()) {
			TreeNode cur = unvisited.remove();
			System.out.println(cur.data);
			if (cur.left != null) {
				unvisited.add(cur.left);
			}
			if (cur.right != null) {
				unvisited.add(cur.right);
			}
		}
	}

	public void dft() {
		Stack<TreeNode> unvisited = new Stack<TreeNode>();
		unvisited.push(root);
		while (!unvisited.isEmpty()) {
			TreeNode cur = unvisited.pop();
			System.out.println(cur.data);
			if (cur.left != null) unvisited.push(cur.left);
			if (cur.right != null) unvisited.push(cur.right);
		}
	}
}


class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.left = null;
		this.right = null;
		this.val = val;
	}
}
