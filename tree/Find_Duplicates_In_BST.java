/**
 * Find_Duplicates_In_BST.
 *
 * Usualy, bst is defined as: if an element is less than the value of
 * current node then it goes left. If it's larger than the value of
 * current node then it goes right.
 *
 * Let's redefine it: if an element is equal or larger than the value of
 * current node then it goes right.
 *
 * For example, a bst is generated with such rule might look like:
 *
 *    1
 *   / \
 *  0   1
 *
 * Question, given the root of the bst, check if this tree has duplicates
 * elements.
 */


public class Find_Duplicates_In_BST {
  public static void main(String[] args) {
    test();
  }

  public static void test() {
    TreeNode root;
    // Test case 1.
    root = new TreeNode(1);
    root.right = new TreeNode(1);
    System.out.println(hasDuplicates(root));

    // Test case 2.
    root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(2);
    System.out.println(hasDuplicates(root));

    // Test case 3.
    root = new TreeNode(1);
    root.right = new TreeNode(4);
    root.right.right = new TreeNode(8);
    root.right.right.left = new TreeNode(7);
    root.right.right.left.left = new TreeNode(4);
    System.out.println(hasDuplicates(root));
  }

  public static boolean hasDuplicates(TreeNode root) {
    return (root == null) ? false :
          rec(root.left, root.val) || rec(root.right, root.val);
  }

  private static boolean rec(TreeNode root, int carry) {
    if (root == null) {
      return false;
    } else if (root.val == carry) {
      return true;
    } else {
      return rec(root.left, carry) || rec(root.right, root.val);
    }
  }

  private static class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public final int val;

    public TreeNode(final int val) {
      this.left = null;
      this.right = null;
      this.val = val;
    }
  }
}
