/*Binary_Tree_Inorder_Traversal

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.Stack;


public class leetcode_Binary_Tree_Inorder_Traversal {

    public static void main(String[] args) {

    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> all = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.add(node);
                node = node.left;
            } else {
                node = s.pop();
                all.add(node.val);
                node = node.right;
            }
        }
        return all;
    }

    // Recursive.
    public static ArrayList<Integer> inorderTraverse(TreeNode root) {
        ArrayList<Integer> all = new ArrayList<Integer>();
        inorder(root, all);
        return all;
    }

    public static void inorder(TreeNode node, ArrayList<Integer> all) {
        if (node != null) {
            inorder(node.left, all);
            all.add(node.val);
            inorder(node.right, all);
        }
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
