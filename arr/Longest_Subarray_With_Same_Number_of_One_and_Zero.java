/*Longest_Subarray_With_Same_Number_of_One_and_Zero

Given an int array contains only 1's and 0's.
Find the longest subarray which contains equal number of 1's and 0's.
For example
10101010, the longest subarray is itself.
1101000, the longest subarray is 110100 or 111000
*/

import java.util.*;

public class Longest_Subarray_With_Same_Number_of_One_and_Zero {
	
	static final boolean DEBUG = false;

	public static void main(String[] args) {
		// test case 1.
		int[] arr = new int[] {1, 1, 0, 1, 0, 0, 0};
		solve(arr);
		// test case 2.
		arr = new int[] {1, 0, 1, 0, 1, 0, 1, 0};
		solve(arr);
		// test case 3.
		arr = new int[] {1, 1, 0, 1, 1, 0, 0};
		solve(arr);
	}

	public static void solve(int[] arr) {
		int n = arr.length, i, j;
		// Replace all 0's with -1's and convert the question to:
		// What's the longest subarray which sums to 0.
		for (i = 0; i < n; ++i) {
			arr[i]	= (arr[i] == 0) ? -1 : 1;
		}
		// Iterate through arr and cache sum [:i] in acc.
		HashMap<Integer, ArrayList<Integer>> dict = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> item;
		int[] acc = new int[n];
		for (i = 0; i < n; ++i) {
			acc[i] = (i == 0) ? arr[0] : acc[i - 1] + arr[i];
			item = dict.get(acc[i]);
			if (item == null) {
				item = new ArrayList<Integer>();	
			}
			item.add(i);
			dict.put(acc[i], item);
		}
		if (DEBUG) print(acc);
		// Find the subarray with same acc value and return the longest one. 
		int globalMax = 0, globalStart = 0, globalEnd = 0, localMin = 0, localMax = 0;
		// Base case, key is 0.
		if (dict.containsKey(0)) {
			item = dict.get(0);
			globalStart = 0;
			globalEnd = max(item);
			globalMax = globalEnd;
		}
		for (Integer key : dict.keySet()) {
			item = dict.get(key);
			if (DEBUG) System.out.println("key: " + key + "\n ArrayList: " + item);
			if (key != 0) {
				localMin = min(item) + 1;
				localMax = max(item);
				if (localMax - localMin > globalMax) {
					globalStart = localMin;
					globalEnd = localMax;
					globalMax = localMax - localMin;
				}
			}
		}
		System.out.println("Starting index: " + globalStart + "\nEnding index: " + globalEnd);
	}

	public static int min(ArrayList<Integer> arr) {
		int ret = Integer.MAX_VALUE;
		for (int i : arr) {
			ret = (i < ret) ? i : ret;	
		}
		return ret;
	}

	public static int max(ArrayList<Integer> arr) {
		int ret = Integer.MIN_VALUE;
		for (int i : arr) {
			ret = (i > ret) ? i : ret;
		}
		return ret;
	}

	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");	
		System.out.println();
	}
}
