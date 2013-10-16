/*Count_Inversion

Inversion Count for an array indicates – how far (or close) the array is from
being sorted. If array is already sorted then inversion count is 0. If array is
sorted in reverse order that inversion count is the maximum. 
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j]
and i < j


Followup:
if you want pairs that a[i] > a[j] and i > j, then you only need to change the
stdout part to:
for (i = index + 1; i < sorted.length; ++i) {
	    System.out.println(cur + "/" + sorted[i]);
}

*/

import java.util.*;

class Count_Inversion {

	public static void main(String[] args) {
		solve(new int[] {6, 9, 1, 14, 8, 12, 3, 2});
	}

	public static void solve(int[] arr) {
		int n = arr.length, cur, index, i;
		int[] sorted = Arrays.copyOfRange(arr, 0, n);
		Arrays.sort(sorted);
		while (arr.length > 0) {
			cur = arr[0];
			index = binarySearch(sorted, cur);
			for (i = 0; i < index; ++i) {
			//for (i = index + 1; i < sorted.length; ++i) {
				System.out.println(cur + "/" + sorted[i]);
			}
			// Remove cur from arr and sorted.
			arr = removeIndex(arr, 0);
			sorted = removeIndex(sorted, index);
		}
	}
	
	// Remove element with index n from array.
	public static int[] removeIndex(int[] arr, int index) {
		int[] ret = new int[arr.length - 1];
		int i = 0, ptr = 0;
		while (i < arr.length) {
			if (i != index) {
				ret[ptr] = arr[i];
				ptr = ptr + 1;
			}
			i = i + 1;
		}
		return ret;
	}
	
	// Binary Search Util.
	public static int binarySearch(int[] arr, int target) {
		return binarySearchUtil(0, arr.length - 1, arr, target);
	}
	
	public static int binarySearchUtil(int head, int tail, int[] arr, int target) {
		if (head > tail) {
			return -1;
		}
		int middle = (head + tail) / 2;
		if (arr[middle] == target) {
			return middle;
		} else if (arr[middle] > target) {
			return binarySearchUtil(head, middle - 1, arr, target);
		} else {
			return binarySearchUtil(middle + 1, tail, arr, target);
		}
	}
	
	// Helper function to print out array.
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
