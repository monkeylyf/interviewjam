/*Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root
node down to the farthest leaf node.
*/

class leetcode_48 {
    public static void main(String[] args) {
    }
    public static int maxDepth(TreeNode root) {
        return nextMax(root);
    }
    public static int nextMax(TreeNode node) {
        if (node == null) return 0;
        return Math.max(nextMax(node.right), nextMax(node.left)) + 1;
    }
}
