/*Depth_Of_Deepest_Odd_Level_Node
geeksforgeeks

Consider that level starts with 1. Depth of a leaf node is number of nodes on
the path from root to leaf (including both leaf and root).

For example, consider the following tree. The deepest odd level node is the node
with value 9 and depth of this node is 5.
      1
     /  \
    2    3
  /     /  \  
 4     5    6
       \     \
        7     8
       /       \
      9         10
                /
               11
*/


import java.util.*;


public class Depth_Of_Deepest_Odd_Level_Node {

	public static void main(String[] args) {
		// Test case
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		root.right.left.right.left = new TreeNode(9);
		root.right.right.right.right = new TreeNode(10);
		root.right.right.right.right.left = new TreeNode(11);
		System.out.println(dfs(root));
		System.out.println(bfs(root));
	}

	// BFS.
	public static int bfs(TreeNode root) {
		if (root == null) {
			return 0;	
		}

		Queue<TreeNode> cur = new LinkedList<TreeNode>(), next = new LinkedList<TreeNode>();
		cur.add(root);
		int level = 1, depth = 0;
		TreeNode node;
		while (!cur.isEmpty()) {
			node= cur.poll();
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			if (node.left == null && node.right == null && level % 2 == 1) {
				depth = Math.max(depth, level);
			}
			if (cur.isEmpty()) {
				cur = next;
				next = new LinkedList<TreeNode>();
				++level;
			}
		}
		return depth;
	}

	// DFS.
	public static int dfs(TreeNode root) {
		int depth = 1; // Root is considered as depth 1.
		return dfsUtil(root, depth);
	}

	public static int dfsUtil(TreeNode root, int depth) {
		if (root == null) {
			return 0;	
		} else if (root.left == null && root.right == null && depth % 2 == 1) {
			return depth;	
		} else {
			return Math.max(dfsUtil(root.left, depth + 1), dfsUtil(root.right, depth + 1));	
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
