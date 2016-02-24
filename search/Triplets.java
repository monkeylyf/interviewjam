/**
 * Triplets.
 *
 * Given 10 ^ 6 integers, and number n, find all distinct triplets that sum is
 * less than n. Each number can be used only once.
 */

import java.util.Arrays;


public class Triplets {

  /**
   * The idea is first sort the array in ascending order.
   *
   * Iterate from left to right as the first element  in triplet.
   * Then pick the second element right next to the first one. And now
   * you have two fixed element in a triplet and given n, you now know
   * the range of the third element in a triplet, which should be within range
   * (second, n - first - second). Binary search will help you find the index
   * and the range.
   *
   * Now the move the second element one step right and then do *NOT* use binary
   * search again, simply move the third element one step right until you find
   * the one that meets the requirement and the range.
   *
   * Total time complexity is O(n) * ( O(1) + O(lgn) + O(n)), which is O(n^2).
   */
  public static void main(String[] args) {
    Triplets solution = new Triplets();
    int[] arr = new int[] {2, 3, 4, 5, 1, 1, 7, 6, 4, 8, 4, 1, 8, 9, 5};
    //int[] arr = new int[] {1, 2, 3, 4};
    solution.solve(arr, 8);
  }

  public void solve(int[] arr, int n) {
    Arrays.sort(arr);

    for (int i = 0; i < arr.length - 2; ++i) {
      int j = i + 1;
      int index = binarySearch(arr, n - arr[i] - arr[j], j + 1, arr.length - 1);

      // Find the first base triplet range with i fixed, j fixed.
      stdout(arr, i, j, index);

      while (j < index) {
        j += 1;
        int max = n - arr[i] - arr[j];
        while (j < index && arr[index] >= max) {
          index -= 1;
        }

        stdout(arr, i, j, index);
      }
    }
  }

  /**
   * stdout triplets.
   */
  private void stdout(int[] arr, int i, int j, int index) {
    if (j >= index) {
      return;
    }

    for (int k = j + 1; k <= index; ++k) {
      System.out.println("<" + arr[i] + ", " + arr[j] + ", " + arr[k] + ">");
    }
  }

  /**
   * Find the largest elment that is smaller than n.
   *
   * Return its index.
   * Option one: implement binary search. This method itself can be a
   *             interview question itself. Time complexity O(lgn)
   *
   * Option two: scan from left to right,  Time complexity O(n)
   *
   * The interesting thing here is choosing option two does not effect the
   * time complexity of this triplets question. So if in a real interview
   * process, choosing option two is a win-win and remember discussing with
   * your interviewer about why you pick option one over two and trade-offs
   * blah blah..
   */
  private int binarySearch(int[] arr, int n, int start, int end) {
    int head = 0;
    int tail = arr.length - 1;

    while (head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (arr[mid] == target) {
        tail  = mid - 1;
      } else if (arr[mid] > target) {
        tail = mid - 1;
      } else {
        head = mid + 1;
      }
    }

    return tail;

    // Comment out the code that does the left-to-right scan.
    //int retval = -1;
    //while (start <= end) {
    //  if (arr[start] < n) {
    //    retval = start;
    //  } else {
    //    break;
    //  }

    //  start += 1;
    //}

    //return retval;
  }
}
