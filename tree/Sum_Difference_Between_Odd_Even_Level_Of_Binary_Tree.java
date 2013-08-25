/*Sum_Difference_Between_Odd_Even_Level_Of_Binary_Tree
geeksforgeeks

//       5           5
//     /   \  
//    2     6        8
//  /  \     \  
// 1    4     8      13
//     /     / \ 
//    3     7   9    19

Given a a Binary Tree, find the difference between the sum of nodes at odd
level and the sum of nodes at even level. Consider root as level 1, left and
right children of root as level 2 and so on.

5 - 8 + 13 -19 = -9
*/


import java.util.*;


public class Sum_Difference_Between_Odd_Even_Level_Of_Binary_Tree {
	
	public static void main(String[] args) {
		// test case.	
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		// Test for bfs.
		System.out.println(bfs(root));
		// Test for dfs.
		System.out.println(dfs(root));
	}

	// DFS
	public static int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return root.val - dfs(root.left) - dfs(root.right);
	}


	// BFS
	public static int bfs(TreeNode root) {
		if (root == null) {
			return 0; // Edge case.
		}
		Queue<TreeNode> cur = new LinkedList<TreeNode>(), next = new LinkedList<TreeNode>();
		cur.add(root);

		boolean oddLevel = true; // Consider root as level 1.
		int ret = 0;
		TreeNode node;

		while (!cur.isEmpty()) {
			node = cur.poll();

			ret = (oddLevel) ? ret + node.val : ret - node.val;

			if (node.left != null) {
				next.add(node.left);
			} 
			if (node.right != null) {
				next.add(node.right);
			}

			if (cur.isEmpty()) {
				// Swap cur and next;	
				cur = next;
				next = new LinkedList<TreeNode>();
				oddLevel = !oddLevel;
			}
		}
		return ret;
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
