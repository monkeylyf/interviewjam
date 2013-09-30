/*Find_Peak

Given an array of integers. Find a peak element in it. An array element
is peak if it is NOT smaller than its neighbors. For corner elements, we
need to consider only one neighbor. For example, for input array {5, 10,
20, 15}, 20 is the only peak element. For input array {10, 20, 15, 2, 23,
90, 67}, there are two peak elements: 20 and 90. Note that we need to
return any one peak element.
       --------------------

Example:
Input:
{5, 10, 20, 15}
Output:
20

*/


public class Find_Peak {

	public static void main(String[] args) {
		solve(new int[] {5, 10, 20, 15});
		solve(new int[] {1, 3, 20, 4, 1, 0});
	}

	public static void solve(int[] arr) {
		System.out.println(binarySearch(0, arr.length - 1, arr));
	} 

	// Binary search approach.
	public static int binarySearch(int head, int tail, int[] arr) {
		int n = arr.length;
		int mid = head + (tail - head) / 2;	// avoid int overflow.
		if (( mid == 0 || arr[mid - 1] <= arr[mid] ) && ( mid == n - 1 || arr[mid + 1] <= arr[mid] )) {
			// if mid is neither 0 or n - 1.  arr[mid - 1] <= arr[mid] >= arr[mid + 1] then return.
			// else consider only one neighbor.
			return mid;
		} else if (mid > 0 && arr[mid - 1] > arr[mid]) {
			return binarySearch(head, mid -1, arr);
		} else {
			return binarySearch(mid + 1, tail, arr);
		}
	}
}
