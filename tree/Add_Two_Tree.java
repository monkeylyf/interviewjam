/**
 * Add_Two_Tree.
 *
 * Given two binary tree with integer val, Adding them up by adding the vals
 * at the same node position, if one of nodes is null then take the val of
 * other node.
 *
 * Return the root node of the new tree. *DO NOT* modified the given trees.
 */


public class Add_Two_Tree {

  public static void main(String[] args) {

  }

  public TreeNode add(TreeNode a, TreeNode b) {
    if (a == null) {
      return b;
    }

    if (b == null) {
      return a;
    }

    TreeNode node = new TreeNode(a.val + b.val);

    node.left = add(a.left, b.left);
    node.right = add(a.right, b.right);

    return node;
  }

  private static class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }

    public String toString() {
      return "<" + this.val + ">";
    }
  }
}
