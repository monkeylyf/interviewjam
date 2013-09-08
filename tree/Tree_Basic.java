/*
*/

import java.util.*;


public class Tree_Basic {
	public static void main(String[] args) {
		Tree t = new Tree();
		t.insertTwo(1);
		t.insertTwo(2);
		t.insertTwo(0);
		t.insertTwo(12);
		t.insertTwo(-8);
		t.insertTwo(-5);
		t.insertTwo(5);

		t.inOrder(t.root);
		System.out.println("-----------");
		t.preOrder(t.root);
		System.out.println("-----------");
		t.postOrder(t.root);
		System.out.println("-----------");
		// System.out.println(t.find(-20));
		System.out.println(t.min());
		System.out.println("-----------");
		System.out.println(t.max());
		System.out.println("-----------");
		System.out.println(t.maxDepth(t.root));
		System.out.println("-----------");
		System.out.println(t.minDepth(t.root));
		System.out.println("-----------");
		System.out.println(t.isBalanced(t.root));
		System.out.println("-----------");
		System.out.println(t.root.val);
		System.out.println(t.root.left.val);
		System.out.println(t.root.left.left.val);
		System.out.println(t.root.left.left.right.val);
		System.out.println("-----------");
		System.out.println(t.root.right.val);
		System.out.println(t.root.right.right.val);
		System.out.println(t.root.right.right.left.val);
		System.out.println("-----------");
		t.bfs(t.root);	
		System.out.println("-----------");
		t.dfs(t.root);	
		Tree t1 = new Tree();
	}
}


class Tree {
	TreeNode root;

	Tree() {
		this.root = null;	
	}

	public TreeNode find(int key) {
		if (this.root == null) {
			return null;
		}

		TreeNode node = this.root;
		while (node.val != key) {
			if (node == null) {
				return null;
			}
			if (key < node.val) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}

	public TreeNode findOne(int key) {
		return findNode(root, key);
	}

	public TreeNode findNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		} else {
			if (root.val == key) {
				return root;
			} else if (key < root.val) {
				return findNode(root.left, key);
			} else {
				return findNode(root.right, key);
			}
		}
	}

	public TreeNode insert(TreeNode root, TreeNode newNode) {
		if (root == null) {
			root = newNode;
		} else if (root.val > newNode.val) {
			// Go left.
			root.left = insert(root.left, newNode);
		} else {
			// Go right.
			root.right = insert(root.right, newNode);
		}
		return root;
	}

	public void insertTwo(int d) {
		TreeNode newNode = new TreeNode(d);
		root = insert(root, newNode);
	}

	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.val);
			inOrder(root.right);
		}
	}

	public void preOrder(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.val);
		}
	}

	// Get the min element from BST.
	public int min() {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		TreeNode node = this.root;
		while (node.left != null) {
			node = node.left;
		}
		return node.val;
	}

	// Get the max element from BST.
	public int max() {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		TreeNode node = this.root;
		while (node.right != null) {
			node = node.right;
		}
		return node.val;
	}

	// Delete a node from BST is non-trivial.
	// Check ../linkedin_Binary_Search_Tree_Detele_Node.java
	public void delete(int key) {
		return;
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.min(minDepth(root.left), minDepth(root.right));
		}
	}

	// Balanced tree problem. 
	public boolean isBalanced(TreeNode root) {
		return (maxDepth(root) - minDepth(root) <= 1);
	}

	public void bfs(TreeNode root) {
		Queue<TreeNode> unvisited = new LinkedList<TreeNode>();
		unvisited.add(root);
		while (!unvisited.isEmpty()) {
			TreeNode cur = unvisited.poll();
			if (cur.left != null) {
				unvisited.add(cur.left);
			}
			if (cur.right != null) {
				unvisited.add(cur.right);
			}
			System.out.println(cur.val);
		}
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;	
		} else {
			// Preorder.
			dfs(root.left);
			// Inorder.
			dfs(root.right);
			// Postorder.
			System.out.println(root.val);
		}
	}
}


class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode(int val) {
		this.left = null;
		this.right = null;
		this.val = val;
	}
}
