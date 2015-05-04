/**
 * leetcode_Majority_Element.
 *
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 */

import java.util.HashMap;
import java.util.Map;

public class leetcode_Majority_Element {

  public static void main(String[] args) {
    leetcode_Majority_Element solution = new leetcode_Majority_Element();
    solution.test();
  }

  public void test() {
    //System.out.println(majorityElement(new int[] {3, 3, 1, 3, 2, 3, 5, 3}) == 3);
    //System.out.println(majorityElement(new int[] {1, 1, 2}) == 1);
    //System.out.println(majorityElement(new int[] {1, 1, 1, 1, 1, 0}) == 1);
    //System.out.println(majorityElement(new int[] {3, 3, 1, 3, 2, 3, 5, 3}) == 3);
    //System.out.println(majorityElement(new int[] {3, 1, 3, 1, 3}) == 3);
    //System.out.println(majorityElement(new int[] {3, 1, 3}) == 3);
    //System.out.println(majorityElement(new int[] {1, 1, 1, 3, 3, 3, 3}) == 3);
    //System.out.println(majorityElement(new int[] {6, 5, 5}) == 5);
    //
    int[] arr = new int[] {6,53,53,96,45,79,53,58,53,90,40,53,53,1,53,53,89,53,33,27,53,53,84,42,53,53,87,51,66,53,28,53,53,53,50,39,36,48,19,74,38,53,42,53,99,53,80,53,53,53,53,96,78,52,24,53,53,53,53,64,10,53,53,53,53,82,53,53,53,22,53,53,67,53,53,53,53,53,67,53,19,99,53,53,21,53,69,53,53,53,52,53,96,53,53,51,81,62,4,6};
    System.out.println(majorityElement(arr));
  }

  /**
   * Divide and conquer.
   */
  public int majorityElement(int[] num) {
    System.out.println("length " + num.length);
    int head = 0;
    int tail = num.length - 1;
    System.out.println("Entry " + elementAppearsMost(head, tail, num));

    while (head < tail) {
      if (tail - head + 1 <= 3) {
        Entry entry = elementAppearsMost(head, tail, num);
        return entry.key;
      }

      int mid = (tail - head) / 2 + head;
      Entry entry = elementAppearsMost(head, mid, num);

      System.out.println("Entry " + entry);
      if (entry.count > (tail - head + 1) / 2) {
        tail = mid;
      } else {
        head = mid;
      }
    }

    return num[head];
  }

  public Entry elementAppearsMost(int head, int tail, int[] arr) {
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    int localMax = 0;
    int key = 0;

    for (int i = head; i <= tail; ++i) {
      Integer num = count.get(arr[i]);
      num = (num == null) ? 1 : num + 1;

      if (num > localMax) {
        localMax = num;
        key = arr[i];
      }

      count.put(arr[i], num);
    }

    System.out.println(count);

    return new Entry(key, localMax);
  }

  private static class Entry {

    public final int key;
    public final int count;

    public Entry(final int key, final int count) {
      this.key = key;
      this.count = count;
    }

    public String toString() {
      return this.key + ": " + this.count;
    }
  }
}
