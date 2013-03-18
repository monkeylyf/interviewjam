/*Maximum_Subarray
careercup

You are given an array of integers (both positive and negative). Find the 
continuous sequence with the largest sum. Return the sum.
EXAMPLE
Input: {2, -8, 3, -2, 4, -10}
Output: 5 (i.e., {3, -2, 4})

Mark as duplicate. Pleace check:
../arr/leetcode_Maximum_Subarray
*/

import java.util.*;


class cap_Maximum_Subarray {
	public static void main(String[] args) {
		int[] input = {2, -8, 3, -2, 4, -10};
	}
	public static int findLargest(int[] n) {
		int sum = 0;
		int max = 0;
		for (int i : n) {
			sum += i;
			if (max < sum) {
                max = sum;
			} else if (sum < 0) {
                sum = 0;
            }
		}
		return max;
	}
}
