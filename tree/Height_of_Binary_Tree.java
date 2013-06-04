/*Height_of_Binary_Tree

There are two conventions to define height of Binary Tree
1) Number of nodes on longest path from root to the deepest node.
2) Number of edges on longest path from root to the deepest node.

*/

import java.util.*;


class Height_of_Binary_Tree {
	public static void main(String[] args) {
		// test case 1.
		BSTNode root = new BSTNode(1);
		root.left = new BSTNode(2);
		root.right = new BSTNode(3);
		root.left.left = new BSTNode(4);
		root.left.right = new BSTNode(5);
		System.out.println(heightIter(root));
		System.out.println(heightRecr(root));
	}

	// Recursive.
	public static int heightRecr(BSTNode root) {
		if (root == null) {
			return 0;	
		} else {
			return Math.max(heightRecr(root.left), heightRecr(root.right)) + 1;	
		}
	}

	// Iterative.
	public static int heightIter(BSTNode root) {
		if (root == null) {
			return 0;	
		}	
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		Queue<BSTNode> next = new LinkedList<BSTNode>();
		BSTNode cur;
		q.add(root);
		int ret = 0;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.left != null) {
				next.add(cur.left);	
			}
			if (cur.right != null) {
				next.add(cur.right);
			}
			if (q.isEmpty()) {
				// swap queue.
				q = next; // point q to next
				next = new LinkedList<BSTNode>(); // Reinit next
				ret = ret + 1;
			}
		}
		return ret;
	}

}


class BSTNode {
	BSTNode left;
	BSTNode right;
	int val;
	BSTNode(int val) {
		this.left = null;
		this.right = null;
		this.val = val;
	}
}
