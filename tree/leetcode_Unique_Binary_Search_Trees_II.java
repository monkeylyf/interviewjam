/*Unique_Binary_Search_Trees_II

Given n, generate all structurally unique BST's (binary search trees) that
store values 1...n.
For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class leetcode_Unique_Binary_Search_Trees_II {

  public static void main(String[] args) {
	generateTrees(3);
  }

  public static List<TreeNode> generateTrees(int n) {
	return gen(1, n);
  }

  public static List<TreeNode> gen(int start, int end) {
	List<TreeNode> ret = new ArrayList<>();
	if (start > end) {
	  ret.add(null);
	} else if (start == end) {
	  ret.add(new TreeNode(start));
	} else {
	  for (int i = start; i <= end; ++i) {
		for (TreeNode left : gen(start, i - 1)) {
		  for (TreeNode right : gen(i + 1, end)) {
			TreeNode root = new TreeNode(i);
			root.left = left;
			root.right = right;
			ret.add(root);
		  }
		}
	  }
	}

	return ret;
  }

  public static List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> ret = new ArrayList<>();
	preorder(root, ret);
	return ret;
  }

  public static void preorder(TreeNode root, List<Integer> ret) {
	if (root != null) {
	  ret.add(root.val);
	  preorder(root.left, ret);
	  preorder(root.right, ret);
	}
  }

  private static class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val) {
  	this.val = val;
  	this.left = null;
  	this.right = null;
    }
  }
}


/* Python Version

def generateTrees(self, n):
    def dfs(start, end):
        if start > end:
            return [None]

        if start == end:
            return [TreeNode(start)]

        ret = []
        for i in xrange(start, end + 1):
            leftNodes = dfs(start, i - 1)
            rightNodes = dfs(i + 1, end)


            for left in leftNodes:
                for right in rightNodes:
                    node = TreeNode(i)
                    node.left = left
                    node.right = right
                    ret.append(node)
        return ret

    return dfs(1, n)
*/
