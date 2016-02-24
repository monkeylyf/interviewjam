/**
 * leetcode_Find_Minimum_in_Rotated_Sorted_Array_II.
 *
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 */


public class leetcode_Find_Minimum_in_Rotated_Sorted_Array_II {

  public static void main(String[] args) {
    System.out.println("hello world");
  }

  /**
   * With duplicates in array, binary search will not work because there is
   * no way to discard either side of the 'mid'.
   *
   * Linear scan and find min will be good enough.
   */
  public int findMin(int[] num) {
    int min = Integer.MAX_VALUE;
    for (int i : num) {
      min = Math.min(i, min);
    }

    return min;
  }
}
