/*Same Tree

Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and
the nodes have the same value.
*/

class leetcode_90 {
    public static void main(String[] args) {
    }
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
