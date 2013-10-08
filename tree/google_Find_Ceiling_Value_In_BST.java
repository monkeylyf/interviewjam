/*google_Find_Ceiling_Value_In_BST
google

		 8
	  /     \
	 3       12
   /   \    /   \ 
  2     6  10    15
       /
	  4

Input: 13 => 15 
Input: 4 => 6 
Input: 8 => 10
*/


public class google_Find_Ceiling_Value_In_BST {
	
	public static void main(String[] args) {
		// Test case.		
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(15);
		for (int i = 0; i <= 16; ++i) {
			System.out.println(String.format("Input: %d Output: %d", i, findCeilingValueInBST(root, i)));
		}
	}

	public static int findCeilingValueInBST(TreeNode root, int val) {
		// p, the value of current root's parent.
		// leftP, the value of parent where is the left child relationship along the path.
		int p = Integer.MIN_VALUE, leftP = Integer.MIN_VALUE;
		while (root != null) {
			if (val < root.val) { // Go left.
				if (root.left != null) {
					p = root.val; // Cache parent value.
					leftP = root.val; // Cache the value when go left.
					root = root.left;
				} else {
					return root.val;
				}
			} else if (val >= root.val) { // Go right.
				if (root.right != null) {
					p = root.val;
					root = root.right;
				} else {
					// Tricky part.
					// 1. If val is larger than any values in the BST, return MIN_VALUE
					// 2. Otherwise return leftP, the first turning left parent.
					return (root.val < p) ? p : leftP;	
				}
			}
		}
		return p; // If root == null, throw exception or return MIN_VALUE.
	}

	// Nested class def.
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
