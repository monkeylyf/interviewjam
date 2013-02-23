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
    // Passed both.
    public static int myJump(int[] A] {
        // dp-based
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
    // Didn't pass the judge large.
    public static int jump(int[] A) {
        if (A.length < 2) return 0;
        ArrayList<Integer> all = new ArrayList<Integer>();
        nextJump(A, 0, 0, all);
        int minSteps = Integer.MAX_VALUE;
        for (int i : all) minSteps = Math.min(minSteps, i);
        return minSteps;
    }
    public static void nextJump(int[] A, int steps, int index, ArrayList<Integer> all) {
        if (index >= A.length - 1) all.add(steps);
        else if (A[index] == 0) return; // Get trapped.
        else {
            for (int i = 1; i <= A[index]; ++i) {
                nextJump(A, steps + 1, index + i, all);
            }
        }
    }
}
