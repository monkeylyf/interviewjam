/**
 * Jump_Game.
 *
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */

class leetcode_Jump_Game {
  public static void main(String[] args) {

  }
  // You can always reach the last index as long as you don't step on 0.
  public static boolean canJump(int[] A) {
    int max_reach_dist = 0;
    int i = 0;
    while (i < A.length && max_reach_dist >= i) {
      max_reach_dist = Math.max(max_reach_dist, i + A[i]);
      if (max_reach_dist >= A.length - 1) {
        return true;
      }
      ++i;
    }

    return false;
  }
}

/* Python Version
class Solution(object):
    def canJump(self, A):
        max_reach_dist = 0
        i = 0
        while i < len(A) and max_reach_dist >= i:
            max_reach_dist = max(max_reach_dist, i + A[i])
            if max_reach_dist >= len(A) - 1:
                return True
            i += 1
        return False
*/
