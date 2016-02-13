/**
 * facebook_Find_Longest_Subarray_With_Sum_K.
 * facebook
 *
 * Given an int array and int k, find the longest subarray that sums up to k.
 * If such subarray does not exist, return empty array.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class facebook_Find_Longest_Subarray_With_Sum_K {

  public static void main(String[] args) {
	facebook_Find_Longest_Subarray_With_Sum_K instance = new facebook_Find_Longest_Subarray_With_Sum_K();
	instance.solve();
  }

  public void solve() {
	// Test case.
	p(subarraySumToK(new int[] {1, 4, 2, 3, 6, 9, 4, -4, 1, 2, 2, -29}, 5));
	p(subarraySumToK(new int[] {1, 1, 1, 1, 1, 1, 1, 1}, 8));
	p(subarraySumToK(new int[] {1, 1, 1, 1, 1, 1, 1}, 8));
	p(subarraySumToK(new int[] {1, -1, 1, -1, 2, -2, 3, -3}, 0));
  }

  public int[] subarraySumToK(int[] arr, int k) {
	int n = arr.length;
	int[] acc = new int[n];

	int start = -1;
	int end = -1;


	int max_length = 0;

	// acc[i] = arr[0 : i + 1]
	for (int i = 0; i < n ; ++i) {
	  acc[i] = (i == 0) ? arr[i] : arr[i] + acc[i - 1];
	  if (acc[i] == k) {
		end = i;
		max_length = i + 1;
	  }
	}

	Map<Integer, Integer> indices = new HashMap<>();
	for (int i = 0; i < n; ++i) {
	  Integer index = indices.get(acc[i]);
	  if (index == null) {
		index = i;
	  }
	  // For arr[0 : i + 1], only cache the right-most index .
	  indices.put(acc[i], Math.max(i, index));
	}

	for (int left = 0; left < n; ++left) {
	  Integer right = indices.get(k + acc[left]);
	  if (right == null) {
		continue;
	  }

	  if (right - left > max_length) {
		start = left;
		end = right;
		max_length = right - left;
	  }

	}

	// If not match found, start = -1 and end = -1, return empty int array.
	return Arrays.copyOfRange(arr, start + 1, end + 1);
  }

  public void p(int[] arr) {
	for (int i : arr) {
	  System.out.print(i + " ");
	}
	System.out.println();
  }
}
