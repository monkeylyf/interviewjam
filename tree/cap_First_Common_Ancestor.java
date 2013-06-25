/*First_Common_Ancestor
careercup

Design an algorithm and write code to find the first common ancestor of two nodes
in a BINARY TREE(not bst). Avoid storing additional nodes in a data structure. 
NOTE: This is not necessarily a binary search tree
FOLLOWUP: what if it is a bst
*/

import java.util.*;


public class cap_First_Common_Ancestor {

	/*
	 1. If each node has link pointing back to its parent, simply trace all the way back
	    to their paths first meets.
	 2. Naive method. At each level of dfs, check if given nodes are on different sides.
	 */

	static int NONE = 0;
	static int ONE = 1;
	static int TWO = 2;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(-1);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		// test case for getPath.
		ArrayList<TreeNode> path = getPath(root, root.right.right);
		print(path);
		path = getPath(root, root.right.left);
		print(path);
		//test case for bingoLCA.
		TreeNode LCA = null;
		LCA = bingoLCA(root, root, root);
		System.out.println(LCA.val);
		LCA = bingoLCA(root, root, root.left);
		System.out.println(LCA.val);
		LCA = bingoLCA(root, root.right.left, root.right.right);
		System.out.println(LCA.val);
		LCA = bingoLCA(root, root.left, root.right.right);
		System.out.println(LCA.val);
	}

	// Robin's algo
	// 1. Assuming that each kid has a link pointing to its parent. Find the depth of both nodes.
	// For the lower node, travel to its parent util two nodes are at the same depth. Check if two
	// nodes are the same node. If yes, that the LCA. If no, both nodes travel back to their parents
	// and check if they are the same. Rinse wash repeat util they are the same. 
	// 2. Assuming that there is no link pointing to its parent. Then we need to cache the path
	// from root to each node. The idea is all most the same as above. But space complexity is
	// O(depth of tree) instead of O(1)

	public static TreeNode bingoLCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null) {
			return null;	
		}

		ArrayList<TreeNode> p_path = getPath(root, p);
		ArrayList<TreeNode> q_path = getPath(root, q);

		while (p_path.size() < q_path.size()) {
			q_path.remove(q_path.size() - 1);
		}
		while (p_path.size() > q_path.size()) {
			p_path.remove(p_path.size() - 1);
		}

		int size = p_path.size();
		while (p_path.get(size - 1) != q_path.get(size - 1)) {
			p_path.remove(size - 1);
			q_path.remove(size - 1);
			--size;	
		}
		return p_path.get(size - 1);
	}

	public static ArrayList<TreeNode> getPath(TreeNode root, TreeNode target) {
		// If it's bst, then it's easier to find the path from root to target.
		// Here we assume that it's just a binary tree.
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		getPathUtil(root, target, path);
		return path;
	}

	public static boolean getPathUtil(TreeNode root, TreeNode target, ArrayList<TreeNode> path) {
		if (root == null) {
			return false;	
		}
		if (root == target) {
			path.add(root);
			return true;	
		}
		path.add(root);
		if (getPathUtil(root.left, target, path)) {
			return true;	
		}
		if (getPathUtil(root.right, target, path)) {
			return true;	
		}
		path.remove(path.size() - 1);
		return false;
	}

	public static void print(ArrayList<TreeNode> path) {
		for (TreeNode node : path) System.out.println(node.val + " ");
		System.out.println();
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
