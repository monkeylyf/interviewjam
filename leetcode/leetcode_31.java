/*Given a binary tree, flatten it to a linked list in-place.
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

class leetcode_31 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        flatten(root);
    }
    public static void flatten(TreeNode root) {
        if (root == null) return;
        else {
            TreeNode node = root;
            while (node.left == null) {
                node = node.right;
                if (node == null) return;
            }
            TreeNode left = node.left;
            while (left.right != null) left = left.right;
            if (node.right != null) left.right = node.right;
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
