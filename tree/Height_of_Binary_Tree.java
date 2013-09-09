/*Height_of_Binary_Tree

There are two conventions to define height of Binary Tree
1) Number of nodes on longest path from root to the deepest node.
2) Number of edges on longest path from root to the deepest node.

*/

import java.util.*;


public class Height_of_Binary_Tree {

	// The difference between those two conventional definition is trivial(by 1)

	public static void main(String[] args) {
		// test case 1.
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		System.out.println(heightIter(root));
		System.out.println(heightRecr(root));
	}

	// DFS.
	public static int heightRecr(TreeNode root) {
		if (root == null) {
			return 0;	
		} else {
			return Math.max(heightRecr(root.left), heightRecr(root.right)) + 1;	
		}
	}

	// BFS.
	public static int heightIter(TreeNode root) {
		if (root == null) {
			return 0;	
		}	
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		TreeNode cur;
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
				next = new LinkedList<TreeNode>(); // Reinit next
				ret = ret + 1;
			}
		}
		return ret;
	}
}


class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	TreeNode(int val) {
		this.left = null;
		this.right = null;
		this.val = val;
	}
}
