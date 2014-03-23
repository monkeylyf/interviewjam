/*Binary_Tree_Maximum_Path_Sum

Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
For example:
Given the below binary tree,
    1
   / \
  2   3
Return 6.*/

public class leetcode_Binary_Tree_Maximum_Path_Sum {

    public static void main(String[] args) {
        Solution test = new Solution(); 
    }
}


class Solution {
    private int max;

    public int maxPathSum(TreeNode root) {
        this.max = root.val;
        nextPath(root);
        return this.max;
    }

    public int nextPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = nextPath(root.left);
        int right = nextPath(root.right);
        int localMax = root.val;
        if (left > 0) {
            localMax += left;
        }
        if (right > 0) {
            localMax += right;
        }
        this.max = Math.max(this.max, localMax);
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
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

/* Python Version

class Solution:
    # @param root, a tree node
    # @return an integer
    def __init__(self):
        self.max_sum = None
    
    def maxPathSum(self, root):
        def postorder(root):
            if not root:
                return 0
            left = postorder(root.left)
            right = postorder(root.right)
            
            local_max = root.val
            
            if left > 0:
                local_max += left
            if right > 0:
                local_max += right
                
            self.max_sum = max(self.max_sum, local_max)
            return max(root.val, max(root.val + left, root.val + right))
        if not root:
            return 0

        self.max_sum = root.val
        postorder(root)
        return self.max_sum
*/
