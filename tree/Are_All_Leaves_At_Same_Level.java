/*Are_All_Leaves_At_Same_Level
geeksforgeeks


*/

import java.util.*;


public class Are_All_Leaves_At_Same_Level {
	
	public static void main(String[] args) {
		// Test case 1.
		TreeNode root;
		root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(1);
		System.out.println(areAllLeavesAtSameLevel(root));
		System.out.println(bfs(root));
		// Test case 2.
		root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(9);
		root.left.left.left = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		System.out.println(areAllLeavesAtSameLevel(root));
		System.out.println(bfs(root));
		// Test case 3.
	}
	
	// DFS
	public static boolean areAllLeavesAtSameLevel(TreeNode root) {
		int[] globalDepth = new int[] {0};
		int depth = 1;
		return util(root, depth, globalDepth);
	}

	public static boolean util(TreeNode root, int depth, int[] globalDepth) {
		if (root == null) {
			return true; // Edge case for root is null	
		} else if (root.left == null && root.right == null) {
			// Leaf detected.
			if (globalDepth[0] == 0) {
				globalDepth[0] = depth;
				return true;
			} else {
				return globalDepth[0] == depth;
			}
		} else {
			return util(root.left, depth + 1, globalDepth) &&
				util(root.right, depth + 1, globalDepth);
		}
	}

	// BFS.
	public static boolean bfs(TreeNode root) {
		if (root == null) {
			return true;	
		}
		Queue<TreeNode> cur = new LinkedList<TreeNode>(), next = new LinkedList<TreeNode>();
		cur.add(root);
		TreeNode node;
		int globalDepth = 0, depth = 1; 

		while (!cur.isEmpty()) {
			node = cur.poll();
			if (node.left == null && node.right == null) {
				if (globalDepth == 0) {
					globalDepth = depth;
				} else if (globalDepth != depth) {
					return false;	
				}
			}
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}

			if (cur.isEmpty()) {
				cur = next;
				next = new LinkedList<TreeNode>();
				++depth;
			}
		}
		return true;
	}

	static class TreeNode{
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
