/*Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
*/

class leetcode_21 {
    public static void main(String[] args) {
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return nextNode(preorder, inorder);
    }
    public static TreeNode nextNode(int[] pre, int[] in) {
        if (pre.length != 0 && in.length != 0) {
            TreeNode node = new TreeNode(pre[0]);
            // Get the root index of current subtree (assume no duplicates!).
            int index = 0;
            for (int i = 0; i < in.length; ++i) if (in[i] == pre[0]) index = i;
            // Create inorder & preorder for right child node.
            int[] right_in = new int[in.length - index - 1];
            int[] right_pre = new int[in.length - index - 1];
            for (int i = index + 1; i < in.length; ++i) {
                right_in[i - index - 1] = in[i];
                right_pre[i - index - 1] = pre[i];
            }
            // Create inorder & preorder for left child node.
            int[] left_in = new int[index];
            int[] left_pre = new int[index];
            for (int i = 0; i < index; ++i) {
                left_in[i] = in[i];
                left_pre[i] = pre[i + 1];
            }
            node.left = nextNode(left_pre, left_in);
            node.right = nextNode(right_pre, right_in);
            return node;
        } else return null;
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
