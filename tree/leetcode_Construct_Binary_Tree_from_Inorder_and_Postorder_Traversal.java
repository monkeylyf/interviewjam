/*Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

import java.util.*;


class leetcode_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public static void main(String[] args) {
        buildTree(new int[] {1,3,2}, new int[] {3,2,1});
        buildTree(new int[] {-1}, new int[] {-1});
    }

    public static TreeNode buildTree(int[] in, int[] post) {
        if (in.length != 0 && post.length != 0) {
            TreeNode root = new TreeNode(post[post.length - 1]);
            int idx = 0;
            for (; idx < in.length; ++idx) { // Find the index of root val.
                if (in[idx] == root.val) {
                    break;
                }
            }
            // Create inorder & postorder for left child node.
            int[] left_in = new int[idx], left_post = new int[idx];
            for (int i = 0; i < idx; ++i) {
                left_in[i] = in[i];
                left_post[i] = post[i];
            }
            // Create inorder & postorder for right child node.
            int[] right_in = new int[in.length - idx - 1], right_post = new int[in.length - idx - 1];
            for (int i = idx + 1; i < in.length; ++i) {
                right_in[i - idx - 1] = in[i];
                right_post[i - idx - 1] = post[i - 1];
            }
            root.left = buildTree(left_in, left_post);
            root.right = buildTree(right_in, right_post);
            return root;
        } else {
            return null;
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
