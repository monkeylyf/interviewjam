/*Symmetric_Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric
around its center).
For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
    3   3
Note:
Bonus points if you could solve it both recursively and iteratively.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class leetcode_Symmetric_Tree {

    public static void main(String[] args) {

    }

    // Recursive way.
    public static boolean isSymmetric(TreeNode root) {
        // The idea behind this is almost same as Same_Tree
        if (root == null) {
            return true;
        }
        return isSameNode(root.left, root.right);
    }

    public static boolean isSameNode(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            // A little difference between Same_Tree.
            // p go left then q go right. p go right then q go left.
            return isSameNode(p.left, q.right) && isSameNode(p.right, q.left);
        }
    }

    // Iterative way.
    public static boolean Symmetric(TreeNode root) {
        // The idea behind this is like print by layer.
        if (root == null) {
            return true;
        }
        Queue<TreeNode> unvisited = new LinkedList<TreeNode>();
        ArrayList<TreeNode> layer = new ArrayList<TreeNode>();
        unvisited.add(root);
        int count = 1;
        while (!unvisited.isEmpty()) {
            TreeNode node = unvisited.remove();
            layer.add(node);
            if (node != null) {
                unvisited.add(node.left);
                unvisited.add(node.right);
            }
            if (--count == 0) {
                // Check if layer is symmetric.
                int head = 0; // Pointing to head.
                int tail = layer.size() - 1; // Pointing to tail.
                while (head < tail) {
                    TreeNode h = layer.get(head);
                    TreeNode t = layer.get(tail);
                    if (h == null && t == null) {
                        ++head;
                        --tail;
                    } else if (h == null || t == null) {
                        return false;
                    } else if (h.val != t.val) {
                        return false;
                    } else {
                        ++head; // Move on.
                        --tail;
                    }
                }
                count = unvisited.size();
                layer = new ArrayList<TreeNode>();
            }
        }
        return true;
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
		this.left = null;
		this.right = null;
        this.val = x;
    }
}
