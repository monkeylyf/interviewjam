/*Same_Tree

Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and
the nodes have the same value.
*/

class leetcode_Same_Tree {
    public static void main(String[] args) {
    }
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (p == null || q == null) {
            return p == q;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
