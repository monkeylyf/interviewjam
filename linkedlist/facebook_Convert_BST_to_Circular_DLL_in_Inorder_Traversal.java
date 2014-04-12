/*Convert_BST_to_DLL

Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL). The left
and right pointers in nodes are to be used as previous and next pointers
respectively in converted DLL. The order of nodes in DLL must be same as Inorder
of the given Binary Tree. The first node of Inorder traversal (left most node
in BT) must be head node of the DLL.

Spoiler: http://leetcode.com/2010/11/convert-binary-search-tree-bst-to.html
		 http://cslibrary.stanford.edu/109/TreeListRecursion.html
*/


class Convert_BST_to_DLL {
	
	public static void main(String[] args) {
		// Test case 1.
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(9);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(14);
		treeToDLL(root);
		print(root);
		// Test case 2.
		root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(5);
		treeToDLL(root);
		print(root);

	}

	// The data structure of DLL is exactly the same as TreeNode.
	// 1. For recursive way, each recursion *MUST* return a circularly
	//    connected DLL.
	// 2. For each recursion, take care of the DLL of left subtree and
	//    DLL of right subtree.
	// 3. Isolate root by pointing its both right and left pointer to itself.
	// 4. Join left and root.
	// 5. join what you get from step 4 and right.
	public static TreeNode treeToDLL(TreeNode root) {
		if (root == null) {
			return null;	
		}
		TreeNode left = treeToDLL(root.left);
		TreeNode right = treeToDLL(root.right);
		// Isolate root and form a circularly connect DLL with length 1.
		root.left = root;
		root.right = root;
		//
		left = append(left, root);
		left = append(left, right);

		return left;
	}

	// a is smaller group of DLL and b is larger one.
	public static void join(TreeNode a, TreeNode b) {
		a.right = b; //
		b.left = a;
	}

	public static TreeNode append(TreeNode a, TreeNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;	
		}
		TreeNode aLeft = a.left; // smallest node's left points to the largest.
		TreeNode bLeft = b.left;
		join(aLeft, b);
		join(bLeft, a);
		return a;
	}

	// Helper function.
	public static void print(TreeNode head) {
		TreeNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + " -> ");
			cur = cur.right;
			if (cur == head) {
				break;	
			}
		}
		System.out.println();
	}

	// Nested class definition.
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
