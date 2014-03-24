/*Path_Sum_II

Given a binary tree and a sum, find all root-to-leaf paths where each path's
sum equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
*/


import java.util.ArrayList;


public class leetcode_Path_Sum_II {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        ArrayList<ArrayList<Integer>> all = pathSum(root, 1);
        for (ArrayList<Integer> i : all) {
			System.out.println(i);
		}
    }

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        if (root != null) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			nextSum(root, sum, all, tmp);
		}
        return all;
    }

	// Then it's inorder traversal.
    public static void nextSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> all, ArrayList<Integer> tmp) {
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
				// Find path.
                ArrayList<Integer> addOne = new ArrayList<Integer>();
                for (int i : tmp) {
                    addOne.add(i);
                }
                addOne.add(node.val);
                all.add(addOne);
            }
        } else {
            tmp.add(node.val);
            if (node.left != null) {
                nextSum(node.left, sum - node.val, all, tmp);
            }
            if (node.right != null) {
                nextSum(node.right, sum - node.val, all, tmp);
            }
			// Recursion return to upper level so we need to remove the current node from tmp path.
            tmp.remove(tmp.size() - 1);
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

/* Python Version
class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a list of lists of integers
    def __init__(self):
        self.container = []
    
    
    def pathSum(self, root, sum):
        def dfs(root, acc, path):
            if not root:
                return
            
            path.append(root.val)
            if not root.left and not root.right and root.val == acc:
                self.container.append(path[::1])
            else:
                # GO left.
                dfs(root.left, acc - root.val, path)
                # Go right.
                dfs(root.right, acc - root.val, path)
            path.pop()
            
        dfs(root, sum, [])
        return self.container
*/
