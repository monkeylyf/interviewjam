/*Create_Mirror_of_Tree
geeksforgeeks
*/

import java.util.*;

public class Create_Mirror_of_Tree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.left.right.left = new TreeNode(7);
	    root.left.right.right = new TreeNode(8);
	    bfs(root);
	    bfs(copy(root));
	}

	// dfs to copy. Right node copied to left, left node copied to right.
	public static TreeNode copy(TreeNode root) {
		if (root == null) {
			return null;
		} else {
			TreeNode node = new TreeNode(root.val);
			node.left = copy(root.right);
			node.right = copy(root.left);
			return node;
		}
	}

	// Helper function to print out tree layer by layer.
	public static void bfs(TreeNode root) {
		Queue<TreeNode> cur = new LinkedList<TreeNode>(), next = new LinkedList<TreeNode>();
		cur.add(root);
		TreeNode curNode;

		while (!cur.isEmpty()) {
			curNode = cur.poll();
			System.out.print(curNode + " ");
			if (curNode.left != null) {
				next.add(curNode.left);
			}
			if (curNode.right != null) {
				next.add(curNode.right);
			}
			if (cur.isEmpty()) {
				// swap cur and next.
				Queue<TreeNode> tmp = cur;
				cur = next;
				next = tmp;
				System.out.println();
			}
		}
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
		
	public String toString() {
		return String.format("<%d>", this.val);
	}
}
