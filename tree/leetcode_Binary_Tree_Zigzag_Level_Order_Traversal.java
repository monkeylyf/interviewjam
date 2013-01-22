/*Binary_Tree_Zigzag_Level_Order_Travesral

Given a binary tree, return the zigzag level order traversal of its nodes'
values. (ie, from left to right, then right to left for the next level and
alternate between).
For example:
Given binary tree {3,9,20,#,#,15,7},
return its zigzag level order traversal as:
[
    [3],
    [20,9],
    [15,7]
]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class leetcode_Binary_Tree_Zigzag_Level_Order_Travesral {
    public static void main(String[] args) {
    }
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> unvisited = new LinkedList<TreeNode>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        unvisited.add(root);
        int count = 1;
        int reverse = 0;
        while (true) {
            TreeNode node = unvisited.remove();
            tmp.add(node.val);
            if (node.left != null) unvisited.add(node.left);
            if (node.right != null) unvisited.add(node.right);
            if (--count == 0) {
                if (reverse++ % 2 == 1) {
                    int head = 0;
                    int tail = tmp.size() - 1;
                    while (head < tail) {
                        int swap = tmp.get(head);
                        tmp.set(head++, tmp.get(tail));
                        tmp.set(tail--, swap);
                    }
                }
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
