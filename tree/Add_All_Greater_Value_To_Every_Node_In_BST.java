/*Add_All_Greater_Value_To_Every_Node_In_BST
geeksforgeeks

*/


import java.util.*;


public class Add_All_Greater_Value_To_Every_Node_In_BST {

	/** 
	 * Look at this question this way
	 * You have a sorted array in descending order and you want
	 * [sum(arr[:i]) for i in xrange(len(arr))].
	 * So you definitely need an accumulater. And you want to do it in descending order.
	 * Reversed inorder traversal. Here we go.
	 */
	
	public static void main(String[] args) {
		// Test case.
		TreeNode root = new TreeNode(50);
		root.left = new TreeNode(30);
		root.right = new TreeNode(70);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(60);
		root.right.right= new TreeNode(80);
		bfs(root);
		modifyBST(root);
		bfs(root);
	}

	public static void modifyBST(TreeNode root) {
		intWrapper sum = new intWrapper(0);
		modifyBSTUtil(root, sum);
	}

	private static void modifyBSTUtil(TreeNode root, intWrapper sum) {
		if (root == null) {
			return;	
		}
		modifyBSTUtil(root.right, sum); // Go right first. Descending inorder traversal.
		sum.val += root.val;
		root.val = sum.val;

		modifyBSTUtil(root.left, sum);
	}
	
	// Helper function to do bfs for testing purpose.
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

	// This function is irrelevant to this question but itself is quite interesting
	// question, say, how to inorder a BST with descending order.
	public static void revInorder(TreeNode root) {
		if (root != null) {
			revInorder(root.right);
			System.out.println(root.val);
			revInorder(root.left);
		}	
	}

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

	// Wrapper for int so it can be called by reference.
	static class intWrapper {
		int val;

		intWrapper(int val) {
			this.val = val;	
		}
	}
}
