/*Balanced Binary Tree.

Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as a binary tree in
which the depth of the two subtrees of every node never differ by more than 1.
*/

/*
I have some tough time on this one because I, somehow, mistandstood the
definition in the quesion.
Another definition of balanced binary tree in careerup150 is:
A balanced tree is defined to be a tree such that no two leaf nodes
differ in distance from the root by more than one.
*/

public class leetcode_Balanced_Binary_Tree {

    public static void main(String[] args) {
    
    }

    // O(n log n).
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
			return true;
		}
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
			return false;
        } else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
    }

    public int maxDepth(TreeNode node) {
        if (node == null) {
			return 0; // return 0 or 1 depends on the definition of depth.
		} else {
			return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
		}
    }

    // O(n).
    public static boolean isBalancedd(TreeNode root) {
        if (root == null) {
			return true;
		}
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
			return false;
        } else {
			return true;
		}
    }

    public int maxD(TreeNode node) {
        if (node == null) {
			return 0;
		}
        int left = maxD(node.left);
        int right = maxD(node.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
			return -1;
        } else {
			return Math.max(left, right) + 1;
		}
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
		this.left = null;
		this.right = null;
        this.val = x;
    }
}
