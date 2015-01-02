/**
 * facebook_Next_Node_In_Binary_Search_Tree.
 * facebook.
 *
 * Given a node in BST, return the next larger node. If there is no such one
 * return null.
 */

public class facebook_Next_Node_In_Binary_Search_Tree {

  public static void main(String[] args) {
    new facebook_Next_Node_In_Binary_Search_Tree().test();
  }

  public void test() {
    TreeNode root = new TreeNode(5);

    root.left = new TreeNode(2);
    root.left.parent = root;

    root.left.left = new TreeNode(1);
    root.left.left.parent = root.left;

    root.left.right = new TreeNode(3);
    root.left.right.parent = root.left;

    root.left.right.right = new TreeNode(4);
    root.left.right.right.parent = root.left.right;

    root.right = new TreeNode(6);
    root.right.parent = root;

    System.out.println(next(root.left.left).val == 2);
    System.out.println(next(root.left).val == 3);
    System.out.println(next(root.left.right).val == 4);
    System.out.println(next(root.left.right.right).val == 5);
    System.out.println(next(root).val == 6);
    System.out.println(next(root.right) == null);
  }

  /**
   * There are three cases.
   *
   * case 1: root.right != null
   * Find the left-most child of the root.right
   *
   * case 2: root.right == null && root.parent == null
   * Return null.
   *
   * case 3: root.right == null && root.parent.left == root
   * Return root.parent.
   *
   * case 4: root.right == null && root.parent.right == root
   * Trace back till the first left child relationship. Return parent.
   */
  public TreeNode next(TreeNode root) {
    // Edge case.
    if (root == null) {
      return null;
    }

    // Case 1.
    if (root.right != null) {
      root = root.right;

      while (root.left != null) {
        root = root.left;
      }

      return root;
    } else if (root.parent == null) {
      // Case 2.
      return null;
    } else {
      TreeNode parent = root.parent;
      // Case 3.
      if (parent.left == root) {
        return parent;
      } else {
        // Case 4.
        while (parent != null && parent.right == root) {
          parent = parent.parent;
          root = root.parent;
        }

        return parent; // parent might be null.
      }
    }
  }

  /**
   * Tree node class.
   */
  private static class TreeNode {

    public int val;

    public TreeNode parent;
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
