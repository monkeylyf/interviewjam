/*Binary_Tree_Maximum_Path_Sum

Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
    1
   / \
  2   3
Return 6.*/

class leetcode_Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {
    
    }
    public static int maxPathSum(TreeNode root) {
        int[] mymax = new int[]{root.val};
        int val = maxSum(root, mymax);
        return Math.max(mymax[0], val);
    }
    public int maxSum(TreeNode root, int[] mymax) {
        if (root == null) {
            return 0;
        }
        int left = maxSum(root.left, mymax);
        int right = maxSum(root.right, mymax);
        int localMax = root.val;
        if (left > 0) {
            localMax += left;
        }
        if (right > 0) {
            localMax += right;
        }
        mymax[0] = Math.max(mymax[0], localMax);
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
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
