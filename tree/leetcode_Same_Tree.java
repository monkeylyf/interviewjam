/*Same_Tree

Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical and
the nodes have the same value.
*/


import java.util.*;


public class leetcode_Same_Tree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(1);
        TreeNode b = new TreeNode(1);
        b.right = new TreeNode(1);
        isSame(a, b);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static boolean isSame(TreeNode a, TreeNode b) {
        Queue<TreeNode> aQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> bQueue = new LinkedList<TreeNode>();
        TreeNode A, B;
        aQueue.add(a);
        bQueue.add(b);
        while (!aQueue.isEmpty() && !bQueue.isEmpty()) {
            A = aQueue.poll();
            B = bQueue.poll();
            if ((A == null && B != null) || (A != null && B == null)) {
                return false;
            } else if (A != null && B != null) {
                if (A.val != B.val) {
                    return false;
                } else {
                    aQueue.add(A.left);
                    aQueue.add(A.right);
                    bQueue.add(B.left);
                    bQueue.add(B.right);
                }
            }
        }
        return true;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int x) {
        this.left = null;
        this.right = null;
        this.val = x;
    }
}
