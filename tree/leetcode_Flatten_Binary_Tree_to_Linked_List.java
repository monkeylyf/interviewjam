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

class leetcode_Flatten_Binary_Tree_to_Linked_List {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        flatten(root);
    }
    public static void flatten(TreeNode root) {
        // The quetion is not very clear on the order of linked list.
        // OJ test case tells that it should be in order of preorder traversal.
        if (root != null) {
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
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
