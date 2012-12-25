/*Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/


class leetcode_20 {
    public static void main(String[] args) {
        buildTree(new int[] {1,3,2}, new int[] {3,2,1});
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return nextNode(inorder, postorder);
    }
    public static TreeNode nextNode(int[] in, int[] post) {
        if (in.length != 0 && post.length != 0) {
            TreeNode node = new TreeNode(post[post.length - 1]);
            int index = 0;
            for (int i = 0 ; i < in.length; ++i) if (in[i] == post[post.length - 1]) index = i;
            // Create inorder & postorder for left child node.
            int[] left_in = new int[index];
            int[] left_post = new int[index];
            for (int i = 0; i < index; ++i) {
                left_in[i] = in[i];
                left_post[i] = post[i];
            }
            // Create inorder & postorder for right child node.
            int[] right_in = new int[in.length - index - 1];
            int[] right_post = new int[in.length - index - 1];
            for (int i = index + 1; i < in.length; ++i) {
                right_in[i - index - 1] = in[i];
                right_post[i - index - 1] = post[i - 1];
            }
            node.left = nextNode(left_in, left_post);
            node.right = nextNode(right_in, right_post);
            return node;
        } else {
            return null;
        }
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {
        val = x;
    }
}
