/*Binary_Tree_Level_Order_Traversal_II

Given a binary tree, return the bottom-up level order traversal of its nodes'
values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree {3,9,20,#,#,15,7},
return its bottom-up level order traversal as:
[
    [15,7]
    [9,20],
    [3],
]
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class leetcode_Binary_Tree_Level_Order_Traversal_II {

    public static void main(String[] args) {
    
    }

    public static ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
			return result;
		}
        Queue<TreeNode> unvisited = new LinkedList<TreeNode>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        unvisited.add(root);
        int count = 1;
        while (!unvisited.isEmpty()) {
            TreeNode node = unvisited.remove();
            tmp.add(node.val);
            if (node.left != null) {
				unvisited.add(node.left);
			}
            if (node.right != null) {
				unvisited.add(node.right);
			}
            if (--count == 0) {
                result.add(tmp);
                tmp = new ArrayList<Integer>();
                count = unvisited.size();
            }
        }
        // Reserve it to be bottom-up level order. Reverse result.
        int head = 0, tail = result.size() - 1;
        while (head < tail) {
           ArrayList<Integer> swap = result.get(head);
           result.set(head++, result.get(tail));
           result.set(tail--, swap);
        }
        return result;
    }
}
