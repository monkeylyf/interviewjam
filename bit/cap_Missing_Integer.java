/*Missing_Integer
careercup

An array A[1...n] contains all the integers from 0 to n except for one number
which is missing. In this problem, we cannot access an entire integer in A with
a single operation. The elements of A are represented in binary, and the only
operation we can use to access them is "fetch the jth bit of A[i]", which takes
constant time. Write code to find the missing integer. Can you do it in O(n)
time?
*/

import java.util.*;

public class cap_Missing_Integer {

	/*
	 * The removal of one number will cause the inbalance of least significant bit(lsb).
	 *
	 * If n is odd, say, 5, then 0, 1, 2, 3, 4, 5. 
	 *							 000, 001, 010, 011, 100, 101
	 * lsb: 0, 1, 0, 1, 0, 1, remove number with lsb 0 or 1
	 * if n is even, say, 6, then 0, 1, 2, 3, 4, 5, 6
	 *							  000, 001, 010, 011, 100, 101, 110
	 * lsb: 0, 1, 0, 1, 0, 1, 0, remove number with lsb 0 or 1.
	 * We can jump to the conclusion that:
	 * If we remove lsb 1, number of 0 is >  number of 1.
	 * if we remove lsb 0, number of 0 is <= number of 1.
	 * Then according to the > or <= we know what lsb the removed number is with.
	 */

	public static void main(String[] args) {
		int[] input;
		// Test case 1.
		input = new int[] {5, 1, 0, 2, 4};
		System.out.println(findMissing(input, 5) == 3);
		// test case 2.
		input = new int[] {0,1,2,3,4,5,6,7,9,10};
		System.out.println(findMissing(input, 10) == 8);
		// Test case for fetchBit.
		//for (int i = 1; i < 32; ++i) {
		//	System.out.println(fetchBit(new int[] {5}, 0, i));
		//}
	}

	// As described, "fetch the jth bit of A[i]".
	// Bit index counting from right to left.
	// :param return: Charactor.
	public static char fetchBit(int[] arr, int i, int j) {
		//System.out.println(binaryFormat + " " + j);
		String binaryFormat = Integer.toBinaryString(arr[i]);
		int numBits = binaryFormat.length();
		if (j > numBits) {
			return '0';	
		} else {
			return binaryFormat.charAt(numBits - j);
		}
	}

	public static int findMissing(int[] arr, int n) {
		boolean[] visited = new boolean[arr.length];
		int numBits = Integer.toBinaryString(n).length();
		int i, j, oneBit, zeroBit;
		String ret = "";
		for (i = 1; i <= numBits; ++i) {
			// Count lsb.
			oneBit = zeroBit = 0;
			for (j = 0; j < arr.length; ++j) {
				if (!visited[j]) {
					if (fetchBit(arr, j, i) == '0') {
						++zeroBit;	
					} else {
						++oneBit;	
					}
				}
			}
			// System.out.println(String.format("Checking position %d.\n0: %d 1: %d", i, zeroBit, oneBit));
			if (zeroBit > oneBit) {
				// the missing number with lsb 0.		
				ret = '1' + ret;
				markVisited(arr, i, '0', visited);
			} else {
				// the missing number with lsb 1.
				ret = '0' + ret;
				markVisited(arr, i, '1', visited);
			}
		}
		return Integer.parseInt(ret, 2);
	}

	// Mark numbers with kth-lsb equal to given lsb as visited.
	public static void markVisited(int[] arr, int k, char lsb, boolean[] visited) {
		for (int i = 0; i < arr.length; ++i) {
			if (!visited[i] && fetchBit(arr, i, k) == lsb)	{
				visited[i] = true;
			}
		}	
	}
}
