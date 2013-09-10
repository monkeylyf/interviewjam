/*Path_Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path
such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
*/


public class leetcode_Path_Sum {

    public static void main(String[] args) {

    }
	
	// I thought:
	// if (root == null) return sum == 0 else return dfs(root.left, sum - root.val) || dfs(root.right, sum -root.val)
	// can solve the problem.
	// But based on the test results on OJ, a tree with only one node has no root-to-leaf path at all. Weird.
	// 
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
			return nextSum(root, sum);
		}
    }   

    public static boolean nextSum(TreeNode node, int sum) {
        if (node.left == null & node.right == null) {
            // root-to-leaf path.
            return node.val == sum;
        }
        boolean left = false, right = false; 
        if (node.left != null) {
            left = nextSum(node.left, sum - node.val);
        }
        if (node.right != null) {
            right = nextSum(node.right, sum - node.val);
        }
        return left || right;
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
