/**
 * leetcode_Find_Minimum_in_Rotated_Sorted_Array.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 */

public class leetcode_Find_Minimum_in_Rotated_Sorted_Array {

  public static void main(String[] args) {
    leetcode_Find_Minimum_in_Rotated_Sorted_Array solution = new leetcode_Find_Minimum_in_Rotated_Sorted_Array();

    int[] num;
    num = new int[] {4, 5, 6, 7, 0, 1, 2};
    System.out.println(solution.findMin(num) == 0);
    num = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
    System.out.println(solution.findMin(num) == 0);
    num = new int[] {6, 7, 8, 1, 2, 3, 4};
    System.out.println(solution.findMin(num) == 1);
    num = new int[] {2, 1};
    System.out.println(solution.findMin(num) == 1);
    num = new int[] {1};
    System.out.println(solution.findMin(num) == 1);
    num = new int[] {5, 1, 2, 3, 4};
    System.out.println(solution.findMin(num) == 1);
  }

  /**
   * Binary search is quite obviou since linear approach is obviously not good
   * enough.
   *
   * Special case for head + 1 = tail: just return min(arr[head], arr[tail])
   *
   */
  public int findMin(int[] num) {
    int head = 0;
    int tail = num.length - 1;

    while (head + 1 < tail) {
      int mid = (tail - head) / 2 + head;
      if (mid > 0 && num[mid - 1] > num[mid]) {
        return num[mid];
      } else if (num[mid] > num[head]) {
        if (num[head] > num[tail]) {
          // 4 5 6 7 0 1 2
          head = mid + 1;
        } else {
          // 1 2 3 4 5 6 7
          tail = mid - 1;
        }
      } else {
        tail = mid - 1;
      }
    }

    return Math.min(num[head], num[tail]);
  }

}
