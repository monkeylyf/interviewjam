/*Flatten_Binary_Tree_to_Linked_List

Given a binary tree, flatten it to a linked list in-place.
For example,
Given
         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/

public class leetcode_Flatten_Binary_Tree_to_Linked_List {

    public static void main(String[] args) {
		// Test case.
        TreeNode root = new TreeNode(0);
        flatten(root);
    }

	// This is the solution i came up with recently. Way better than the one below.
	// Post-order recursion + 
	public static void myFlatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
		// Cache root.right for swap.
        TreeNode right = root.right;
		// Copy left to right and empty left.
        root.right = root.left;
        root.left = null;
		// Right the last node of linked copied to right and connect it with the right linkedlist.
        TreeNode cursor = root;
        while (cursor.right != null) {
            cursor = cursor.right;
        }
        cursor.right = right;		
	}

	// The version one solution.
    public static void flatten(TreeNode root) {
        // The quetion is not very clear on the order of linked list.
        // OJ test case tells that it should be in order of preorder traversal.
        if (root == null) {
			return;
		}
        TreeNode node = root;
        // Find first node with non-null left child.
        while (node.left == null) {
            node = node.right;
            if (node == null) {
                // if all node has no left child. 
                return;
            }
        }
        TreeNode left = node.left;
        // Along left child node, find last non-null right child.
        while (left.right != null) {
            left = left.right;
        }
        if (node.right != null) {
            left.right = node.right;
        }
        node.right = node.left;
        node.left = null;
        flatten(node.right);
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
}
