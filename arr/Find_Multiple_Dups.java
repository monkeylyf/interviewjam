/*Find_Multiple_Dups

geeksforgeeks

Given an array of n elements which contains elements from 0 to n-1, with any of
these numbers appearing any number of times. Find these repeating numbers in
O(n) and using only constant memory space.
*/



class Find_Multiple_Dups {

	public static void main(String[] args) {
		solve(new int[] {1, 2, 3, 4, 3, 2});
	}

	public static void solve(int[] arr) {
		int i;
		for (i = 0; i < arr.length; ++i) {
			if (arr[Math.abs(arr[i])] >= 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else {
				System.out.println(Math.abs(arr[i]));
			}
		}
	}
}
