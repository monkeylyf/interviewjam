/*You are given an array of integers (both positive and negative). Find the 
continuous sequence with the largest sum. Return the sum.
EXAMPLE
Input: {2, -8, 3, -2, 4, -10}
Output: 5 (i.e., {3, -2, 4})*/

import java.util.*;


class test_129 {
	public static void main(String[] args) {
		int[] input = {2, -8, 3, -2, 4, -10};
		System.out.println(findLargestSum(input));
		System.out.println(findLargest(input));
	}

	public static int findLargestSum(int[] n) {
		int retval = Integer.MIN_VALUE;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < n.length; ++i) if (n[i] >= 0) arr.add(i);
		for (int i = 0; i < arr.size(); ++i) {
			for (int j = 0; j < arr.size(); ++j) {
				int sum = 0;
				for (int h = arr.get(i); h <= arr.get(j); ++h) sum += n[h];
				if (sum > retval) retval = sum;
			}
		}
		return retval;
	}

	public static int findLargest(int[] n) {
		int sum = 0;
		int max = 0;
		for (int i : n) {
			sum += i;
			if (max < sum) max = sum;
			else if (sum < 0) sum = 0;
		}
		return max;
	}
}
