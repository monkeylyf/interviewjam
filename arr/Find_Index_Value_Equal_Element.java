/**
 * Find_Index_Value_Equal_Element.
 * ZocDoc
 *
 * Given a int array, all elemtns are *DISTINCT*, non-continuing and increasing.
 * Find all elements whose index is equal to its value
 */


public class Find_Index_Value_Equal_Element {

  public static void main(String[] args) {
    Find_Index_Value_Equal_Element solution = new Find_Index_Value_Equal_Element();
    solution.test();
  }

  public void test() {
    System.out.println(binarySearchIter(new int[] {-3, -1, 1, 3, 5, 7}) == 3);
    System.out.println(binarySearchIter(new int[] {1, 2, 3, 4, 5}) == -1);
    System.out.println(binarySearchIter(new int[] {-1, 0, 1, 2, 4}) == 4);
  }

  public void solve(int[] arr) {
    //System.out.println(binarySearchRec(0, arr.length - 1, arr));
  }

  /**
   * Recursion way.
   */
  public int binarySearchRec(int head, int tail, int[] arr) {
    if (head > tail) {
      return -1; // Find nothing.
    }
    int mid = (tail - head) / 2 + head;
    if (arr[mid] == mid) {
      return mid;
    } else if (arr[mid] < mid) {
      return binarySearchRec(mid + 1, tail, arr);
    } else {
      return binarySearchRec(head, mid - 1, arr);
    }
  }

  /**
   * Iterative way.
   */
  public int binarySearchIter(int[] arr) {
    int head = 0;
    int tail = arr.length - 1;

    while (head <= tail) {
      int mid = (tail - head) / 2 + head;

      if (arr[mid] == mid) {
        return mid;
      } else if (arr[mid] > mid) {
        tail = mid - 1;
      } else {
        head = mid + 1;
      }
    }

    // Not found.
    return -1;
  }
}
