/*Search_in_Rotated_Sorted_Array
careercup

Given a sorted array of n integers that has been rotated an unknown number of
times,give an O(logn) algorithm that finds an element in the array. You may
assume that the array was originally sorted in increasing order
EXAMPLE:
input: find 5 in array(15, 16, 19, 20, 25, 1, 3, 4, *5*, 7, 10, 14)
Output: 8


mark as dupplicate
leetcode_Search_in_Rotated_Sorted_Array
*/

class cap_Search_in_Rotated_Sorted_Array {
	public static void main(String[] args) {
		int[] input = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		for (int i : input) System.out.println(findIndexOf(input, i));
	}
	public static int findIndexOf(int[] arr, int a) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (arr[middle] == a) {
                return middle;
			} else if (arr[start] <= arr[middle]) {
				if (a > arr[middle]) {
                    start = middle + 1;
				} else if (a >= arr[start]) {
                    end = middle - 1;
				} else {
                    start = middle + 1;
                }
			}
			else if (a < arr[middle]) {
                end = middle  - 1;
			} else if (a <= arr[end]) {
                start = middle + 1;
			} else {
                end = middle - 1;
            }
		}
		return Integer.MAX_VALUE;
	}
}
