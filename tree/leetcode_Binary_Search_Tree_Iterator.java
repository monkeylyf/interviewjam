/**
 * leetcode_Binary_Search_Tree_Iterator.
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 */

import java.util.Stack;

public class leetcode_Binary_Search_Tree_Iterator {

  public static void main(String[] args) {
    leetcode_Binary_Search_Tree_Iterator solution = new leetcode_Binary_Search_Tree_Iterator();
    solution.test();
  }

  public void test() {
    TreeNode root = new TreeNode(5);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.left.left = new TreeNode(6);
    root.right.right = new TreeNode(10);

    BSTIterator iter = new BSTIterator(root);

    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }

  private static class BSTIterator {

    private final Stack<TreeNode> s;

    public BSTIterator(TreeNode root) {
      this.s = new Stack<TreeNode>();
      initStack(root);
    }

    private void initStack(TreeNode root) {
      while (root != null) {
        this.s.push(root);
        root = root.left;
      }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
      return !this.s.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
      TreeNode cur = this.s.pop();
      initStack(cur.right);

      return cur.val;
    }
  }

    /**
     * Tree node class.
     */
  private static class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val) {
      this.val = val;
    }

    public String toString() {
      return "<" + this.val + ">";
    }
  }

}
