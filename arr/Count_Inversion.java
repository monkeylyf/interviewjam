/**
 * Count_Inversion.
 *
 * Inversion Count for an array indicates – how far (or close) the array is from
 * being sorted. If array is already sorted then inversion count is 0. If array is
 * sorted in reverse order that inversion count is the maximum.
 * Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j]
 * and i < j
 *
 *
 * Follow-up:
 * if you want pairs that a[i] > a[j] and i > j, then you only need to change the
 * stdout part to:
 * for (i = index + 1; i < sorted.length; ++i) {
 *   System.out.println(cur + "/" + sorted[i]);
 * }
 *
 */

import java.util.Arrays;

public class Count_Inversion {

  public static void main(String[] args) {
    Count_Inversion solution = new Count_Inversion();
    solution.test();
  }

  public void test() {
    solve(new int[] {6, 9, 1, 14, 8, 12, 3, 2});
  }

  public void solve(int[] arr) {
    // Get a deep copy of array and sort it.
    int[] sorted = Arrays.copyOfRange(arr, 0, arr.length);
    Arrays.sort(sorted);

    while (arr.length > 0) {
      int cur = arr[0];
      int index = binarySearch(sorted, cur);
      if (index == -1) {
        throw new IllegalArgumentException(cur + " not found in array.");
      }
      for (int i = 0; i < index; ++i) {
        //for (i = index + 1; i < sorted.length; ++i) {
        System.out.println(cur + "/" + sorted[i]);
      }
      // Remove cur from arr and sorted.
      arr = Arrays.copyOfRange(arr, 1, arr.length);
      sorted = removeIndex(sorted, index);
    }
  }

  /**
   * Remove element with index n from array.
   */
  public int[] removeIndex(int[] arr, int index) {
    int[] ret = new int[arr.length - 1];

    for (int i = 0, ptr = 0; i < arr.length; ++i) {
      if (i != index) {
        ret[ptr] = arr[i];
        ptr = ptr + 1;
      }
    }

    return ret;
  }

  /**
   * Binary Search Util.
   */
  public int binarySearch(int[] arr, int target) {
    int head = 0;
    int tail = arr.length - 1;
    while (head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        head = mid + 1;
      } else {
        tail = mid - 1;
      }
    }

    return -1;
  }

  // Helper function to print out array.
  public void print(int[] arr) {
    for (int i : arr) System.out.print(i + " ");
    System.out.println();
  }
}
