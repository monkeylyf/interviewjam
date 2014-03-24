/*Minimum_Depth_of_Binary_Tree

Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root
node down to the nearest leaf node.
*/


public class leetcode_Minimum_Depth_of_Binary_Tree {

    public static void main(String[] args) {

    }

	// Note: You can't just return Math.min(depth(root.left), depth(root.right)) + 1
	// Case: 
	//  1
	//   \
	//    2
    public static minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_depth = minDepth(root.left);
        int right_depth = minDepth(root.right);
        if (left_depth == 0 && right_depth == 0) {
            return 1;
        } else if (left_depth == 0) {
            return right_depth + 1;
        }   else if (right_depth == 0) {
            return left_depth + 1;
        } else {
            return Math.min(left_depth, right_depth) + 1; 
        }
    } 
}

/* Python Version
class Solution:
    # @param root, a tree node
    # @return an integer
    
    def __init__(self):
        self.min_depth = None
    
    def minDepth(self, root):
        def dfs(root, depth):
            if not root.left and not root.right:
                if not self.min_depth:
                    self.min_depth = depth + 1
                else:
                    self.min_depth = min(self.min_depth, depth + 1)
				return
            if self.min_depth and depth >= self.min_depth:
                return # Pruning
            if root.left:
                dfs(root.left, depth + 1)
            if root.right:
                dfs(root.right, depth + 1)
                
        if not root:
            return 0
        dfs(root, 0)
        return self.min_depth
*/
