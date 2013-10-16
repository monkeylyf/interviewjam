/*Ancestors_of_Given_Binary_Tree_Node
geeksforgeeks

Given a Binary Tree and a key, write a function that prints all the ancestors
of the key in the given binary tree.
*/

public class Ancestors_of_Given_Binary_Tree_Node {
	
	public static void main(String[] args) {
		// test case 1.
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		naive(root, 7);
	}

	public static boolean naive(TreeNode root, int val) {
		if (root == null) {
			return false;	
		} else if (root.val == val) {
			return true;	
		} else if (naive(root.left, val) || naive(root.right, val)) {
			System.out.println(root.val);
			return true;
		} else {
			return false;	
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
}
