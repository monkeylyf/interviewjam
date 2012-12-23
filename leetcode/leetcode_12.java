/*Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).
For example:
Given binary tree {3,9,20,#,#,15,7},
return its level order traversal as:
[
    [3],
    [9,20],
    [15,7]
]
*/

import java.util.ArrayList;


class leetcode_12 {
    public static void main(String[] args) {
    }
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> unvisited = new LinkedList<TreeNode>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        unvisited.add(root);
        int count = 1;
        while (true) {
            TreeNode node = unvisited.remove();
            tmp.add(node.val);
            if (node.left != null) unvisited.add(node.left);
            if (node.right != null) unvisited.add(node.right);
            if (--count == 0) {
                result.add(tmp);
                tmp = new ArrayList<Integer>();
                count = unvisited.size();
            }
            if (unvisited.isEmpty()) break;
        }
        return result;
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
