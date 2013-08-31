/*BST_Inorder_Iterator
careercup

Write an algorithm to find the ‘next’ node (e g , in-order successor) of a given
node in a binary search tree where each node has a link to its parent

FOLLOWUP
What if there is no link to node's parents?
*/

import java.util.*;

public class cap_BST_Inorder_Iterator {
	
	public static void main(String[] args) {
		// test case 1.
		TreeNode root;
		root = new TreeNode(4);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		Tree tree = new Tree(root);
		while (tree.hasNext()) {
			System.out.println(tree.next().val);	
		}
		// test case for TreeNodeWithParent.
		TreeNodeWithParent r;
		r = new TreeNodeWithParent(4);
		r.left = new TreeNodeWithParent(3);
		r.right = new TreeNodeWithParent(5);
		r.left.parent = r;
		r.right.parent = r;
		TreeWithParent t = new TreeWithParent(r);
		while (t.hasNext()) {
			System.out.println(t.next().val);	
		}
	}

	static class Tree {
		private Queue<TreeNode> arr;
		private TreeNode root;

		Tree(TreeNode root) {
			this.root = root;
			this.arr = new LinkedList<TreeNode>();
			this.initArray();
		}

		private void initArray() {
			dfs(this.root);
		}

		private void dfs(TreeNode root) {
			if (root == null) {
				return;	
			} else {
				dfs(root.left);
				this.arr.add(root);
				dfs(root.right);
			}
		}

		public boolean hasNext() {
			return !this.arr.isEmpty();	
		}

		public TreeNode next() {
			return this.arr.poll();	
		}

		public TreeNode peek() {
			return this.arr.peek();
		}
	}

	static class TreeWithParent {
		private TreeNodeWithParent root;
		private TreeNodeWithParent cursor;

		TreeWithParent(TreeNodeWithParent root) {
			this.root = root;
			this.cursor = root;
			while (this.cursor.left != null) {
				this.cursor	= this.cursor.left;
			}
		}

		public boolean hasNext() {
			return this.cursor != null;
		}

		public TreeNodeWithParent next() {
			TreeNodeWithParent ret = this.cursor;
			// Find the next node cor cursor.
			TreeNodeWithParent parent = this.cursor.parent;
			if (parent == null) {
				// Back to root. Inorder traversal done.
				this.cursor = null;
			} else if (parent.val > this.cursor.val && parent.right != null) {
				// cursor is left child. Go right.
				this.cursor = parent.right;
				while (this.cursor.left != null) {
					this.cursor = this.cursor;	
				}
			} else if (parent.val < this.cursor.val) {
				this.cursor = parent;
			} else {
				System.out.println("Something is wrong here");	
			}
			return ret;
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

	static class TreeNodeWithParent {
		TreeNodeWithParent left;
		TreeNodeWithParent right;
		TreeNodeWithParent parent;
		int val;

		TreeNodeWithParent(int val) {
			this.left = null;
			this.right = null;
			this.parent = null;
			this.val = val;
		}
	}
}
