/**
 * Find_Number_Of_Larger_Element_On_Right_Side.
 *
 * Given an integer array. Count, for each number in this array, how many
 * numbers are there on its right side are larger than itself.
 *
 * For example, given [3, 2, 1, 4], output [1, 1, 1, 0]
 */


import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;


public class Find_Number_Of_Larger_Element_On_Right_Side {

  public static void main(String[] args) {
    Find_Number_Of_Larger_Element_On_Right_Side solution = new Find_Number_Of_Larger_Element_On_Right_Side();

    int[] arr;

    arr = new int[] {3, 2, 1, 4};
    System.out.println(Arrays.toString(solution.solveByBST(arr)));

    arr = new int[] {1, 1, 1, 4};
    System.out.println(Arrays.toString(solution.solveByBST(arr)));
  }


  public int[] solveByMergeSort(int[] arr) {
    int[] count = new int[arr.length];

    return count;
  }

  /**
   * The idea is to use BST to do the counting.
   *
   * Create root node with the right-most element. And then start inserting
   * elements from right to left. It's O(lgn) to insert and return the inserted
   * node.
   *
   * Total number of nodes in subtree is maintained during insertion.
   */
  public int[] solveByBST(int[] arr) {
    int[] count = new int[arr.length];

    TreeNode root = new TreeNode(arr[arr.length - 1]);

    for (int i = arr.length - 2; i >= 0; --i) {
      TreeNode insertedNode = root.insert(arr[i]);
      count[i] = insertedNode.totalNumber();
    }

    return count;
  }


  /**
   * Tree node class.
   *
   * Field 'count' is the total number of subtree.
   */
  private static class TreeNode {

    public final int val;
    public int count;

    public TreeNode left;
    public TreeNode right;

    public TreeNode(final int val) {
      this.val = val;
      this.count = 1;

      this.left = null;
      this.right = null;
    }

    public void increCount() {
      this.count += 1;
    }

    public int totalNumber() {
      int leftTotal  = (this.left == null)  ? 0 : this.left.count;
      int rightTotal = (this.right == null) ? 0 : this.right.count;

      return leftTotal + rightTotal + this.count;
    }

    /**
     * Insert into BST.
     *
     * Incre the count of the visited node by one. By maintaining
     * this value to ge the total # of nodes in its subtree by O(1).
     */
    public TreeNode insert(final int i) {
      TreeNode root = this;

      while (root != null) {
        root.increCount();
        if (root.val == i) {
          return root;
        } else if (root.val > i) {
          // Go left.
          if (root.left == null) {
            root.left = new TreeNode(i);
            return root.left;
          } else {
            root = root.left;
          }
        } else {
          if (root.right == null) {
            root.right = new TreeNode(i);
            return root.right;
          } else {
            root = root.right;
          }
        }
      }

      return root;
    }

    public String toString() {
      return "<Node: " + this.val + " Count: " + this.count + ">";
    }
  }
}
