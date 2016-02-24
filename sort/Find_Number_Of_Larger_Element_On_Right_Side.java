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
    System.out.println(Arrays.toString(solution.solveByMergeSort(arr)));

    arr = new int[] {1, 1, 1, 4};
    System.out.println(Arrays.toString(solution.solveByBST(arr)));
    System.out.println(Arrays.toString(solution.solveByMergeSort(arr)));
  }

  /**
   * Variation of merge sort.
   */
  public Item[] solveByMergeSort(int[] arr) {
    int[] count = new int[arr.length];

    Item[] items = new Item[arr.length];
    for (int i = 0; i < arr.length; ++i) {
      items[i] = new Item(arr[i]);
    }

    return mergeSortAndCount(items);
  }

  private Item[] mergeSortAndCount(Item[] items) {
    if (items.length == 0 || items.length == 1) {
      return items;
    }

    int mid = items.length / 2;

    Item[] left = Arrays.copyOfRange(items, 0, mid);
    Item[] right = Arrays.copyOfRange(items, mid, items.length);

    Item[] sortedLeft = mergeSortAndCount(left);
    Item[] sortedRight = mergeSortAndCount(right);

    Item[] rv =  merge(sortedLeft, sortedRight);

    return rv;
  }

  /**
   * The part where magic happens...
   *
   * 1 3 5     2 4 6  -->>  1 2 3 4 5 6
   * 2 1 0     2 1 0        5 4 3 2 1 0
   *
   *
   */
  private Item[] merge(Item[] left, Item[] right) {
    Item[] ret = new Item[left.length + right.length];

    int i = 0;
    int j = 0;

    while (i < left.length && j < right.length) {
      if (left[i].num < right[j].num) {
        ret[i + j] = new Item(left[i].num, left[i].count + right[j].count + 1);
        i += 1;
      } else if (left[i].num == right[j].num) {
        ret[i + j] = new Item(left[i].num, left[i].count + right[j].count);
        i += 1;
      } else {
        ret[i + j] = new Item(right[i].num, right[i].count);
        j += 1;
      }
    }

    while (i < left.length) {
      ret[i + j] = left[i];
      i += 1;
    }

    while (j < left.length) {
      ret[i + j] = right[j];
      j += 1;
    }

    return ret;
  }

  private static class Item {

    public final int num;
    public int count;

    public Item(final int num) {
      this.num = num;
      this.count = 0;
    }

    public Item(final int num, final int count) {
      this.num = num;
      this.count = count;
    }

    public String toString() {
      return "<num: " + this.num + " count: " + this.count + ">";
    }
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
        if (root.val >= i) {
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
