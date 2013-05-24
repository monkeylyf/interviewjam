/*Find_Multiple_Dups

geeksforgeeks

Given an array of n elements which contains elements from 0 to n-1, with any of
these numbers appearing any number of times. Find these repeating numbers in
O(n) and using only constant memory space.


If there is only two dups in array and they appear twice.
We can:
Iterate through arr and get sum(arr) and sqaure sum of all elements.

Then we know x+y and x^2+y^2
Then solve the function.
*/



class Find_Multiple_Dups {

	public static void main(String[] args) {
		//solve(new int[] {1, 2, 3, 4, 3, 2});
		solve(new int[] {1, 2, 2, 2, 1});
	}

	public static void solve(int[] arr) {
		print(arr);
		int i;
		for (i = 0; i < arr.length; ++i) {
			if (arr[Math.abs(arr[i])] >= 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
				print(arr);
			} else {
				System.out.println(Math.abs(arr[i]));
			}
		}
	}

	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
