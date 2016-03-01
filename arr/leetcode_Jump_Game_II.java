/**
 * Jump_Game_II.

 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from
 * index 0 to 1, then 3 steps to the last index.)
 */


class leetcode_Jump_Game_II {

  public static void main(String[] args) {
    System.out.println(jump(new int[] {2, 1}));
  }

  public static int jump(int[] A) {
    int cur_jump_max_reach = 0;
    int prev_jump_max_reach = 0;
    int min_jump = 0;

    for (int i = 0; i < A.length; ++i) {
      if (i > prev_jump_max_reach) {
        prev_jump_max_reach = cur_jump_max_reach;
        min_jump += 1;
      }
      cur_jump_max_reach = Math.max(cur_jump_max_reach, i + A[i]);
    }

    return min_jump;
  }
}

/* Python Version

def jump(self, A):
	# cur_jump_max_reach is the largest distance with ret + 1 steps.
	cur_jump_max_reach = prev_jump_max_reach = ret = 0
	for i, val in enumerate(A):
		if i > prev_jump_max_reach:
			prev_jump_max_reach = cur_jump_max_reach
			ret += 1
		# Init cur_jump_max_reach when i == 0
		# For each elem, update largest distance can be reached with last jump.
		cur_jump_max_reach = max(cur_jump_max_reach, i + val)

	return ret
*/
