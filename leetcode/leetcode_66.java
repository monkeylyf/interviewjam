/*Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path
such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/


class leetcode_66 {
    public static void main(String[] args) {
    }
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        boolean left = false;
        boolean right = false;
        if (root.left != null) left = nextSum(root.left, sum - root.val);
        if (root.right != null) right = nextSum(root.right, sum - root.val);
        return left || right;
    }   
    public static boolean nextSum(TreeNode node, int sum) {
        if (node.left == null & node.right == null) return node.val == sum;
        boolean left = false;
        boolean right = false; 
        if (node.left != null) left = nextSum(node.left, sum - node.val);
        if (node.right != null) right = nextSum(node.right, sum - node.val);
        return left || right;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
