/*Print_Left_View_of_Binary_Tree
geeksforgeeks

*/


import java.util.*;


public class Print_Left_View_of_Binary_Tree {
	
	public static void main(String[] args) {
		// Test case 1
		TreeNode root;
		root = new TreeNode(12);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);
		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(40);
		bfs(root);
		dfs(root);
	}

	public static void bfs(TreeNode root) {
		if (root == null) {
			return;	
		}
		Queue<TreeNode> cur = new LinkedList<TreeNode>();	
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		cur.add(root);
		System.out.println(root.val);
		TreeNode node;

		while (!cur.isEmpty()) {
			node = cur.poll();
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			if (cur.isEmpty()) {
				if (!next.isEmpty()) {
					System.out.println(next.peek().val);
				}
				cur = next;
				next = new LinkedList<TreeNode>();
			}
		}
	}

	public static void dfs(TreeNode root) {
		int[] globalDepth = new int[] {0};
		int depth = 1;
		dfsUtil(root, depth, globalDepth);
	}

	public static void dfsUtil(TreeNode root, int depth, int[] globalDepth) {
		if (root == null) {
			return;	
		} else {
			if (depth > globalDepth[0])	{
				System.out.println(root.val);	
				globalDepth[0] = depth;
			}
			dfsUtil(root.left, depth + 1, globalDepth);
			dfsUtil(root.right, depth + 1, globalDepth);
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
