/**
 * codeforces_Counting_Kangaroos_Is_Fun.
 *
 * http://codeforces.com/contest/373/problem/C
 */

import java.util.Arrays;

public class codeforces_Counting_Kangaroos_Is_Fun {

  private int globalMin = Integer.MAX_VALUE;

  public static void main(String[] args) {
    codeforces_Counting_Kangaroos_Is_Fun solution = new codeforces_Counting_Kangaroos_Is_Fun();
    solution.test();
  }

  public void test() {
    System.out.println(solve(new int[] {2, 5, 7, 6, 9, 8, 4, 2}) == 5);
    System.out.println(solve(new int[] {9, 1, 6, 2, 6, 5, 8, 3}) == 5);
    System.out.println(solve(new int[] {2, 4, 5, 8}) == 2);
    System.out.println(solve(new int[] {2, 3, 4, 8}) == 2);
  }

  /**
   * O(nlgn) solution.
   *
   * The worst case scenario is n, that is none of them matches, like 1, 1, 1, 1
   * The best case scenario is n / 2, that is they match as many as possible.
   * Sort first. And try to find pairs starting at index i and mid.
   *
   * Basically it's greedy. But can you prove the greedy way works?
   */
  public int solve(int[] arr) {
    Arrays.sort(arr);
    int ptr = arr.length / 2;
    int result = arr.length; // Worst case scenario.

    for (int i = 0; i < arr.length / 2 && ptr < arr.length; ++i) {
      while (ptr < arr.length) {
        if (arr[i] * 2 <= arr[ptr]) {
          result -= 1; // arr[ptr] can hold arr[i]
          break;
        }

        ptr += 1;
      }
    }

    return result;
  }

  /**
   * Expoential time complexity solution.
   */
  public int brutalForce(int[] arr) {
    this.globalMin = Integer.MAX_VALUE;
    Arrays.sort(arr);
    rec(arr, 0);
    return this.globalMin;
  }

  private void rec(int[] arr, int foundPairs) {
    int len = arr.length;
    if (len == 0 || len == 1 || arr[0] * 2 > arr[len - 1]) {
      // no more pairs??
      if (foundPairs + len < this.globalMin) {
        this.globalMin = foundPairs + len;
      }

      return;
    }

    // Scanning the rest of the array.
    for (int i = 0; i < len - 1; ++i) {
      int index = binarySearch(arr, 0, len - 1, arr[i] * 2);
      if (index < i || arr[index] < arr[i] * 2) {
        continue;
      }

      for (int j = index; j < len; ++j) {
        rec(remove(arr, i, j), foundPairs + 1);
      }
    }
  }

  private int binarySearch(int[] arr, int start, int end, int target) {
    int head = start;
    int tail = end;

    while (head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (arr[mid] == target) {
        if (mid - 1 >= start && arr[mid - 1] == target) {
          tail = mid - 1;
        } else {
          return mid;
        }
      } else if (arr[mid] > target) {
        if (mid - 1 >= start && arr[mid - 1] < target) {
          return mid;
        } else {
          tail = mid - 1;
        }
      } else {
        head = mid + 1;
      }
    }

    return tail;
  }

  private int[] remove(int[] arr, int a, int b) {
    int[] retval = new int[arr.length - 2];
    int index = 0;
    for (int i = 0; i < arr.length; ++i) {
      if (i == a || i == b) {
        continue;
      }
      retval[index++] = arr[i];
    }

    return retval;
  }

  private void printArray(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
}
