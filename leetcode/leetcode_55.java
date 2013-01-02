/*Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root
node down to the nearest leaf node.
*/


class leetcode_55 {
    public static void main(String[] args) {
    }
    public static minDepth(TreeNode root) {
        return nextMin(root);
    }
    public int nextMin(TreeNode root) {
        if (root == null) return 0;
        int left_depth = nextMin(root.left);
        int right_depth = nextMin(root.right);
        if (left_depth == 0 && right_depth == 0) return 1;
        else if (left_depth == 0) return right_depth + 1;
        else if (right_depth == 0) return left_depth + 1;
        else return Math.min(left_depth, right_depth) + 1; 
    } 
}
