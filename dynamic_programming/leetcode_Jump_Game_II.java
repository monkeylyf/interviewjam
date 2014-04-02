/*Jump_Game_II

Given an array of non-negative integers, you are initially positioned at the
first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
For example:
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from
index 0 to 1, then 3 steps to the last index.)
*/

import java.util.ArrayList;


class leetcode_Jump_Game_II {
    public static void main(String[] args) {
        System.out.println(jump(new int[] {2, 1}));
    }

    public static int myJump(int[] A] {
        // dp-based. Did not pass OJ
		// Time complexity O(n^2)
        int[] step = new int[A.length];
        step[A.length - 1] = 0;
        for (int i = A.length - 2; i >= 0; --i) {
            if (i + A[i] >= A.length - 1) {
                step[i] = 1;
            } else if (A[i] == 0) {
                step[i] = Integer.MAX_VALUE;
            } else {
                int localMin = Integer.MAX_VALUE;
                for (int j = i + 1; j <= i + A[i]; ++j) {
                    localMin = Math.min(localMin, step[j]); 
                }
                if (localMin == Integer.MAX_VALUE) {
                    step[i] = Integer.MAX_VALUE;
                } else {
                    step[i] = localMin + 1;
                }
            }
        }
        return step[0];
    }
}

/* Python Version

def jump(self, A):
	# cur is the largest distance with ret + 1 steps.
	# 
	cur = last = ret = 0
	for i in xrange(len(A)):
		if i > last:
			last = cur
			ret += 1
		# Init cur when i == 0
		# For each elem, update largest distance can be reached with last jump.
		cur = max(cur, i + A[i])
	
	return ret
*/
