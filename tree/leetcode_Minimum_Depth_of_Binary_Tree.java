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
