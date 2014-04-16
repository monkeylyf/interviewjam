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


public class leetcode_Unique_Binary_Search_Trees_II {

  public static void main(String[] args) {
	generateTrees(3);
  }

  public static ArrayList<TreeNode> generateTrees(int n) {
	return gen(1, n);
  }

  public static ArrayList<TreeNode> gen(int start, int end) {
	ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
	if (start > end) {
	  ret.add(null);
	} else if (start == end) {
	  TreeNode root = new TreeNode(start);
	  ret.add(root);
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

  /* This solution is obsolete.*/ 
  public static ArrayList<TreeNode> generateTrees1(int n) {
	boolean[] used = new boolean[n];
	int[] nums = new int[n];
	for (int i = 0; i < n; ++i) {
	  nums[i] = i + 1;
	}
	ArrayList<Integer> tmp = new ArrayList<Integer>();
	HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
	ArrayList<TreeNode> all = new ArrayList<TreeNode>();
	nextNode(nums, tmp, used, set, all);
	return all;
  }

  public static void nextNode(int[] nums, ArrayList<Integer> tmp, boolean[] used, HashSet<ArrayList<Integer>> set, ArrayList<TreeNode> all) {
	if (tmp.size() == nums.length) {
	  TreeNode root = null; 
	  for (Integer i : tmp) { 
		root = insert(root, i);
	  }
	  ArrayList<Integer> arr = preorderTraversal(root);
	  if (!set.contains(arr)) {
		set.add(arr);
		all.add(root);
	  }
	} else {
	  for (int i = 0; i < nums.length; ++i) {
		if (!used[i]) {
		  tmp.add(nums[i]);
		  used[i] = true;
		  nextNode(nums, tmp, used, set, all);
		  tmp.remove(tmp.size() - 1);
		  used[i] = false;
		}
	  }
	}
  }

  public static TreeNode insert(TreeNode root, int x) {
	TreeNode node = new TreeNode(x);
	return insertNode(root, node);
  }

  public static TreeNode insertNode(TreeNode root, TreeNode node) {
	if (root == null) {
	  root = node;
	} else if (node.val < root.val) {
	  root.left = insertNode(root.left, node);
	} else {
	  root.right = insertNode(root.right, node);
	}
	return root;        
  }

  public static ArrayList<Integer> preorderTraversal(TreeNode root) {
	ArrayList<Integer> ret = new ArrayList<Integer>();
	preorder(root, ret);
	return ret;
  }

  public static void preorder(TreeNode root, ArrayList<Integer> ret) {
	if (root != null) {
	  ret.add(root.val);
	  preorder(root.left, ret);
	  preorder(root.right, ret);
	}
  }

  static class TreeNode {
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
