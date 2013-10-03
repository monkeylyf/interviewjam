/*leetcode_Single_Number_II
leetcode

Given an array of integers, every element appears three times except for one.
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it
without using extra memory?
*/


public class leetcode_Single_Number_II {
	
	public static void main(String[] args) {
		// Test case 1.
		System.out.println(singleNumber(new int[] {1, 1, 1, 2}));
		// Test case 2.
		System.out.println(singleNumber(new int[] {-2,-2,1,1,-3,1,-3,-3,-4,-2}));
	}

	public static int singleNumber(int[] A) {
		char[] bits = new char[32];
		int i, j, sum, bit;
		for (i = 0; i < 32; ++i) {
			sum = 0;
			for (j = 0; j < A.length; ++j) {
				bit = (A[j] >> i) % 2;	
				sum += bit;
			}
			bits[31 - i] = (sum % 3 == 0) ? '0' : '1';
		}
		print(bits);
		if (bits[0] == '1') {
			// Reverse and add one due to two's complement.
			for (i = 0; i < 32; ++i) {
				bits[i] = (bits[i] == '1') ? '0' : '1';
			}
			return -Integer.parseInt(new String(bits), 2) - 1;
		} else {
			return Integer.parseInt(new String(bits), 2);
		}
	}

	// Helper function.
	public static void print(char[] arr) {
		for (char c : arr) System.out.print(c + " ");
		System.out.println();	
	}
}
