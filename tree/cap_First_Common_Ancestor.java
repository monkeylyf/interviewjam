/*First_Common_Ancestor
careercup

Design an algorithm and write code to find the first common ancestor of two nodes
in a BINARY TREE(not bst). Avoid storing additional nodes in a data structure. 
NOTE: This is not necessarily a binary search tree
FOLLOWUP: what if it is a bst
*/

public class cap_First_Common_Ancestor {

	/**
	 1. If each node has link pointing back to its parent, simply trace all the way back
	    to their paths first meets.
	 2. Naive method. At each level of dfs, check if given nodes are on different sides.
	 3. 
	 */

	static int NONE = 0;
	static int ONE = 1;
	static int TWO = 2;

	public static void main(String[] args) {

	}

	// LCA
	public static TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		// check left side.
		int left = trace(root.left, p, q);
		if (left == ONE && (root.val == q.val || root.val == p.val)) {
			return root;
		} else if (left == TWO) {
			if (root.left.val == q.val || root.left.val == p.val) {
				return root.left;
			} else {
				return LCA(root.left, p, q);
			}
		}
		
		// check right side.
		int right = trace(root.right, p, q);
		if (right == ONE && (root.val == q.val || root.val == p.val)) {
			return root;
		} else if (left == TWO) {
			if (root.right.val == q.val || root.right.val == p.val) {
				return root.right;
			} else {
				return LCA(root.right, p, q);
			}
		}
		return null;
	}

	public static int trace(TreeNode root, TreeNode p, TreeNode q) {
		// Assuming all elements in tree are unique.
		if (root == null) {
			return NONE;
		} else {
			int ret = (root.val == p.val || root.val == q.val) ? ONE : NONE;
			ret += trace(root.left, p, q);
			return (ret == TWO) ? TWO : ret + trace(root.right, p, q);
		}
	}

	// Naive method.

	public static TreeNode LCANaive(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;	
		} else if (root.val == p.val && (contains(root.left, q) || contains(root.right, q))) {
			return root;
		} else if (root.val == q.val && (contains(root.left, p) || contains(root.right, p))) {
			return root;
		} if ((contains(root.left, p) && contains(root.right, q)) ||
			  (contains(root.right, p) && contains(root.left, q))) {
			return root;	
		} else {
			TreeNode left = LCANaive(root.left, p, q);
			TreeNode right = LCANaive(root.right, p, q);
			if (left == null && right == null) {
				return null;	
			} else if (left == null) {
				return right;	
			} else {
				return left;	
			}
		}
	}

	public static boolean contains(TreeNode root, TreeNode q) {
		if (root == null) {
			return false;	
		} else if (root.val == q.val) {
			return true;	
		} else {
			return contains(root.left, q) || contains(root.right, q);	
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
}
