/*google_Products_Of_Arrays
google

Given an array of numbers, nums, return an array of numbers products, where 
products[i] is the product of all nums[j], j != i.

Input : [1, 2, 3, 4, 5]
Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
      = [120, 60, 40, 30, 24]
You *MUST* do this in O(N) without using division.
*/


public class google_Products_Of_Arrays {

	/*
	 * Calc the prefix product and suffix product.
	 * If there is 0 in the array, then division can not be used obviously.
	 */
	public static void main(String[] args) {
		solve(new int[] {1, 2, 3, 4, 5});		
	}	
	
	public static void solve(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		long[] left = new long[arr.length];
		long[] right = new long[arr.length];
		long[] product = new long[arr.length];
		// Calc product(arr[:i])
		left[0] = 1;
		for (int i = 1; i < left.length; ++i) {
			left[i] = left[i - 1] * arr[i - 1];
		}
		// Calc product(arr[i:])
		right[arr.length - 1] = 1;
		for (int i = arr.length - 2; i >= 0; --i) {
			right[i] = right[i + 1] * arr[i + 1];
		}
		// Calc product.
		for (int i = 0; i < arr.length; ++i) {
			product[i] = left[i] * right[i];
		}
		// STDOUT.
		print(product);
	}

	public static void print(long[] arr) {
		for (long i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
