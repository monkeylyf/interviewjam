/*Extract_Leaves_Of_Binary_Tree_In_A_Doubly_Linked_List.java
geeksforgeeks

Given a Binary Tree, extract all leaves of it in a Doubly Linked List (DLL).
Note that the DLL need to be created in-place. Assume that the node structure of
DLL and Binary Tree is same, only the meaning of left and right pointers are
different. In DLL, left means previous pointer and right means next pointer.

Let the following be input binary tree
		1
	 /     \
	2       3
   / \       \
  4   5       6
 / \         / \
7   8       9   10


Output:
Doubly Linked List
7<->8<->5<->9<->10

Modified Tree:
		1
	 /     \
	2       3
   /         \
  4           6
*/


public class Extract_Leaves_Of_Binary_Tree_In_A_Doubly_Linked_List {
	
	public static void main(String[] args) {
		// Test case.
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
		solve(root);
	}

	public static void solve(TreeNode root) {
		DLLNode dummy = new DLLNode(-1);
		dfs(root, dummy);
		printDLL(dummy.next);
	}

	private static TreeNode dfs(TreeNode root, DLLNode head) {
		if (root == null) {
			return null;	
		} else if (root.left == null && root.right == null) {
			// Java call by reference. If you modifed the value of head.next, fine,
			// it has influence outside the scope of current function.
			// But if you do head = head.next, you are not changing the content of object
			// this reference points to, but switching to a new reference.
			// Thus, the head reference won't change during the process so you have to move
			// to the last node everytime you reach a leaf. O(n^2) complexity.
			while (head.next != null) {
				head = head.next;
			}
			DLLNode newNode = new DLLNode(root.val);
			head.next = newNode;
			newNode.prev = head;
			head = newNode;
			return null;
		} else {
			root.left = dfs(root.left, head);
			root.right = dfs(root.right, head);
			return root;
		}
	}

	// Helper function to print out DLL.
	public static void printDLL(DLLNode head) {
		while (head != null) {
			System.out.print(head.val + " <-> ");
			head = head.next;
		}	
		System.out.println("null");
	}

	// Nested class def.
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

	static class DLLNode {
		DLLNode next;
		DLLNode prev;
		int val;

		DLLNode(int val) {
			this.next = null;
			this.prev = null;
			this.val = val;
		}
	}
}

