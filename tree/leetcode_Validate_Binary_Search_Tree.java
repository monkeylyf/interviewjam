/*Validate_Binary_Search_Tree

Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's
key.
The right subtree of a node contains only nodes with keys greater than the
node's key.
Both the left and right subtrees must also be binary search trees.
*/


public class leetcode_Validate_Binary_Search_Tree {

    public static void main(String[] args) {

    }

    public static boolean isValidBST(TreeNode root) {
        // The idea behind this is deserializing the BST and traversing
        // the array to check if value of every node is less than the latter one.
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        inorderTravesal(root, inorder);
        for (int i = 0; i < inorder.size() - 1; ++i) {
            if (inorder.get(i) >= inorder.get(i + 1)) {
                return false;
            }
        }
        return true;   
    }

    public static void inorderTravesal(TreeNode node, ArrayList<Integer> inorder) {
        if (node != null) {
            inorderTravesal(node.left, inorder);
            inorder.add(node.val);
            inorderTravesal(node.right, inorder);
        }
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
