/**
 * Find_Largest_Element_But_Less_Than_Target_In_Array.
 *
 * Given a sorted array, find the largest element in array that is less than target.
 * Return its index. If not found, return -1.
 */

public class Find_Largest_Element_But_Less_Than_Target_In_Array {

  public static void main(String[] args) {
    System.out.println(search(new int[] {1, 2, 2, 4}, 3) == 2);
    System.out.println(search(new int[] {1, 2, 2, 4}, 2) == 0);
    System.out.println(search(new int[] {1, 2, 2, 2, 4}, 3) == 3);
    System.out.println(search(new int[] {1, 2, 2, 4}, 1) == -1);
    System.out.println(search(new int[] {1, 2, 2, 4}, 5) == 3);
    System.out.println(search(new int[] {1, 2, 3, 4, 5}, 6) == 4);
    System.out.println(search(new int[] {1, 2, 3, 4, 5}, 5) == 3);
    System.out.println(search(new int[] {1, 2, 3, 4, 5}, 4) == 2);
    System.out.println(search(new int[] {1, 2, 3, 4, 5}, 3) == 1);
    System.out.println(search(new int[] {1, 2, 3, 4, 5}, 2) == 0);
  }

  public static int search(int[] arr, int target) {
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
  }
}
