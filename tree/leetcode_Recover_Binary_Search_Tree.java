/*Recover_Binary_Search_Tree

Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a
constant space solution?
*/


import java.util.ArrayList;


public class leetcode_Recover_Binary_Search_Tree {

    public static void main(String[] args) {

    }

    public static void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();
        inorderTraverse(root, inorder); // inorder traversal of tree.
        TreeNode nodeOne = null, nodeTwo = null;
        // Now the question become two elements of a sorted array are swap by
        // mistake. Recover thee array.
        for (int i = 0; i < inorder.size() - 1; ++i) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                nodeOne = inorder.get(i);
                break;
            }
        }
        for (int i = inorder.size() - 1; i > 0; --i) {
            if (inorder.get(i).val < inorder.get(i - 1).val) {
                nodeTwo = inorder.get(i);
                break;
            }
        }
        int swap = nodeOne.val;
        nodeOne.val = nodeTwo.val;
        nodeTwo.val = swap;
    }

    public static void inorderTraverse(TreeNode root, ArrayList<TreeNode> inorder) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, inorder);
        inorder.add(root);
        inorderTraverse(root.right, inorder);
    }
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
		this.left = null;
		this.right = null;
        this.val = val;
    }
}
