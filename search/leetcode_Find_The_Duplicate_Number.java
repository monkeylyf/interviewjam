/**
 * Find the Duplicate Number.
 *
 * leetcode
 * Given an array nums containing n + 1 integers where each integer is between
 * 1 and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated
 * more than once.
 */


public class leetcode_Find_The_Duplicate_Number {

  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int head = 1;
    int tail = nums.length - 1;
    while (head < tail) {
      int mid = (tail - head) / 2 + head;
      int count = 0;
      for (int i = 0; i < nums.length; ++i) {
        if (nums[i] <= mid) {
          count += 1;
        }
      }
      if (count > mid) {
        tail = mid;
      } else {
        head = mid + 1;
      }
    }
    return head;
  }
}
