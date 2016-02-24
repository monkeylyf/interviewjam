/**
 * Find_A_Element_Appears_No_Less_Than_One_Forth_Times_In_Sorted_Array.
 *
 * Find the element that appears no less than n/4 times in a sorted array.
 * n is the length of this array. If there are more than one qualified elements
 * return any of them.
 */


import java.util.Arrays;

public class Find_A_Element_Appears_No_Less_Than_One_Forth_Times_In_Sorted_Array {

  public static void main(String[] args) {
    Find_A_Element_Appears_No_Less_Than_One_Forth_Times_In_Sorted_Array solution =
    new Find_A_Element_Appears_No_Less_Than_One_Forth_Times_In_Sorted_Array();

    System.out.println(solution.solve(new int[] {1, 2, 3, 4, 4, 4, 5}));
  }


  /**
   * First find the range of element in the middle, if it meets the requirement, then return.
   *
   * If not, the array has been divided into three parts, binary search the left and right parts.
   * The tricky part is for the one-level deeper recursion, if still hit, then there is not hit
   * at all for that part. That is because in second recursion, the divided parts are less than
   * length 4/n, no need to keep recursing.
   *
   * Time complexity O(lgn)
   */
  private int solve(int[] arr) {
    return solveUtil(arr, 0);
  }

  /**
   * Recursive funtion which only recurse one level deaper.
   */
  private int solveUtil(int[] arr, int recLvl ) {
    int mid = arr.length / 2;
    Range range = findRangeInSortedArray(arr, arr[mid]);
    if (range.span() >= arr.length / 4) {
      return arr[mid];
    }

    if (recLvl == 1) {
      return -1;
    }

    int leftPartSearchRes = solveUtil(Arrays.copyOfRange(arr, 0, range.start - 1), 1);
    if (leftPartSearchRes != -1) {
      return leftPartSearchRes;
    }

    int rightPartSearchRes = solveUtil(Arrays.copyOfRange(arr, range.end + 1, arr.length - 1), 1);
    if (rightPartSearchRes != -1) {
      return rightPartSearchRes;
    }

    return -1;
  }

  private Range findRangeInSortedArray(int[] arr, int target) {
    int leftBoundIndex = binarySearchLeftBound(arr, 4);
    int rightBoundIndex = binarySearchRightBound(arr, 4);

    return new Range(leftBoundIndex, rightBoundIndex);
  }

  private int binarySearchLeftBound(int[] arr, int target) {
    int head = 0;
    int tail = arr.length - 1;

    while (head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (arr[mid] == target) {
        if (mid - 1 >= 0 && arr[mid - 1] == target) {
          tail = mid -1;
        } else {
          return mid;
        }
      } else if (arr[mid] > target) {
        tail = mid - 1;
      } else {
        head = mid + 1;
      }
    }

    return -1;
  }

  private int binarySearchRightBound(int[] arr, int target) {
    int head = 0;
    int tail = arr.length - 1;

    while (head <= tail) {
      int mid = (tail - head) / 2 + head;
      if (arr[mid] == target) {
        if (mid + 1 < arr.length && arr[mid + 1] == target) {
          head = mid + 1;
        } else {
          return mid;
        }
      } else if (arr[mid] > target) {
        tail = mid - 1;
      } else {
        head = mid + 1;
      }
    }

    return -1;
  }

  /**
   * Range class.
   */
  private static class Range {
    public final int start;
    public final int end;

    public Range(final int start, final int end) {
      this.start = start;
      this.end =  end;
    }

    public int span() {
      return this.end - this.start;
    }

    public String toString() {
      return "[" + this.start + ", " + this.end + "]";
    }
  }

  /**
   * TODO: How to use interface to reduce the duplicate code of binarySearch for
   * left/right boundary?
   */
  private interface compareTo {
    public boolean compare(int i, int j);
  }
}
