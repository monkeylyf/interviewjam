/*Remove_All_Nodes_Do_Not_Lie_In_Any_Path_With_Sum_More_Than_K
geeksforgeeks

http://www.geeksforgeeks.org/remove-all-nodes-which-lie-on-a-path-having-sum-less-than-k/


Given a binary tree, a complete path is defined as a path from root to a leaf.
The sum of all nodes on that path is defined as the sum of that path. Given a
number K, you have to remove (prune the tree) all nodes which don't lie in any
path with sum>=k.

Note: A node can be part of multiple paths. So we have to delete it only in case
when all paths from it have sum less than K.
*/

import java.util.*;


public class Remove_All_Nodes_Do_Not_Lie_In_Any_Path_With_Sum_More_Than_K {
	
	public static void main(String[] args) {
		// Test case 1.
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right.left = new TreeNode(12);
		root.right.right.left = new TreeNode(10);
		root.right.right.left.right = new TreeNode(11);
		root.left.left.right.left = new TreeNode(13);
		root.left.left.right.right = new TreeNode(14);
		root.left.left.right.right.left = new TreeNode(15);
		bfs(root);
		prune(root, 20);
		bfs(root);
	}

	public static void prune(TreeNode root, int k) {
		intWrapper sum = new intWrapper(0);
		pruneUtil(root, k, sum);
	}

	public static TreeNode pruneUtil(TreeNode root, int k, intWrapper sum) {
		if (root == null) {
			return null;
		}

		// Post-order traversal.
		intWrapper left = new intWrapper(sum.val + root.val);
		intWrapper right = new intWrapper(sum.val + root.val);

		root.left = pruneUtil(root.left, k, left);
		root.right = pruneUtil(root.right, k, right);

		// After the recursion finished, left reprensents the max path value
		// from the root of this root to curNode.left to every leaf.

		// Max path value passing this node.
		sum.val = Math.max(left.val, right.val);

		if (sum.val < k) {
			root = null; // Eliminated.
		}
		return root;
	}

	// Helper function. Print out the tree layer by layer.
	public static void bfs(TreeNode root) {
		Queue<TreeNode> cur = new LinkedList<TreeNode>(), next = new LinkedList<TreeNode>();
		cur.add(root);
		TreeNode node;

		while (!cur.isEmpty()) {
			node = cur.poll();
			System.out.print(node.val + " ");
			if (node.left != null) {
				next.add(node.left);	
			}
			if (node.right != null) {
				next.add(node.right);	
			}
			if (cur.isEmpty()) {
				cur = next;
				next = new LinkedList<TreeNode>();
				System.out.println();
			}
		}
	}

	// This wrapper is simulating pointer.
	// int is primitive type and Integer is immutable so neither of them can 
	// be used for call by referrence. You can create int[] {0} but it will
	// confuse people.
	static class intWrapper {
		int val;

		intWrapper(int val) {
			this.val = val;	
		}
	}

	// TreeNode class
	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;

		TreeNode(int val) {
			this.left = null;
			this.right = null;
			this.val = val;
		}
	}
}
