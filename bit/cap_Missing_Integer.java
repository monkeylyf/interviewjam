/*Missing_Integer
careercup

An array A[1...n] contains all the integers from 0 to n except for one number
which is missing. In this problem, we cannot access an entire integer in A with
a single operation. The elements of A are represented in binary, and the only
operation we can use to access them is "fetch the jth bit of A[i]", which takes
constant time. Write code to find the missing integer. Can you do it in O(n)
time?
*/

class cap_Missing_Integer {
	public static void main(String[] args) {
		int[] input = {5, 1, 0, 2, 4};
		fetchbit(input, 1);
		fetchbit(input, 30);
		fetchbit(input, 31);
		fetchbit(input, 32);
		fetchbit(input, 33);
	}
	public static int fetchbit(int[] arr, int i) {
		// Assume int has 32 bits.
		int index = i / 32;
		int position = 32 - (i % 32);
		System.out.println("Position is " + position);
		int tmp = arr[index];
		System.out.println("Number is " + tmp);
		while (position-- >= 0) {
			int shit = tmp / 2; 
			tmp %= 2;
			System.out.println(tmp);
		}
		System.out.println(tmp);
		return tmp;
	}
	public static int findMissing(int[] input, int n) {
		return 1;
	}
}
