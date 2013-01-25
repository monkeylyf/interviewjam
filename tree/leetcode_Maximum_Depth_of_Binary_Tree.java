/*Maximum_Depth_of_Binary_Tree

Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root
node down to the farthest leaf node.
*/

class leetcode_Maximum_Depth_of_Binary_Tree {
    public static void main(String[] args) {
    }
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
