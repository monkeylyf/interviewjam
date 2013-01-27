/*Unique Binary Search Trees

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


class leetcode_114 {
    public static void main(String[] args) {
        numTrees(3);
    }
    public static int numTrees(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = i + 1;
        ArrayList<TreeNode> all = new ArrayList<TreeNode>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        nextNode(nums, tmp, all, set);
        for (ArrayList<Integer> i : set) System.out.println(i);
        return all.size();
    }
    public static void nextNode(int[] nums, ArrayList<Integer> tmp, ArrayList<TreeNode> all, HashSet<ArrayList<Integer>> set) {
        if (nums.length == 0) {
            TreeNode root = null;
            for (Integer i : tmp) root = insert(root, i);
            ArrayList<Integer> arr = preorderTraversal(root);
            if (!set.contains(arr)) {
                set.add(arr);
                all.add(root);
            }
        } else {
            for (int i = 0; i < nums.length; ++i) {
                tmp.add(nums[i]);
                nextNode(removeIndex(nums, i), tmp, all, set);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    public static int[] removeIndex(int[] arr, int index) {
        int[] res = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (i != index) {
                res[j] = arr[i];
                ++j;
            }
        }
        return res;
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
}


class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x) {
        left = null;
        right = null;
        val = x;
    }
}