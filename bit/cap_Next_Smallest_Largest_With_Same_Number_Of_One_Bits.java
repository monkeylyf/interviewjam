/*Next_Smallest_Largest_With_Same_Number_Of_One_Bits
careercup

Given an integer, print the next smallest and next largest number that have
the same number of 1 bits in their binary representation.

FOLLOWUP
1. Given an integer, print the next smallest and next largest number that have the
same number of 0, 1, 2, ... 9, in their deximal representation.
2. Permutate a string
*/

import java.util.*;


public class cap_Next_Smallest_Largest_With_Same_Number_Of_One_Bits {

	public static void main(String[] args) {
		// Test case for nextlargest.
		int input = 121;
		nextLargest(input);
		// Test case for nextSmallest.
		// nextSmallest(input);
		// Test case for followup
		// followup(123456789);
		// followup(123654321);
		// followup(987654321);
		// Test case for Permutate.
		// permutate(12345);
	}

	public static void nextLargest(int input) {
		String str = Integer.toBinaryString(input);
		char[] arr = str.toCharArray();
		int one_pos = 0, one_count = 0, i = j = arr.length - 1;
		for (; i >= 0; --i) {
			// Find the first 1's from right to left and mark its index.
			if (arr[i] == '1') {
				one_pos = i;
				one_count += 1;
			} else if (arr[i] == '0' && one > 0) {
				// Find the first 0's after finding the first 1's
				// Swap their value.
				arr[i] = '1';
				arr[one_pos] = '0';
				break;
			}
		}
		// Scan from right to left again.
		for (; i < j; --j) {
			if (one_count > 1) {
				arr[j] = '1';
				--one_count;
			} else {
				arr[j] = '0';
			}
		}
		System.out.println(str);
		System.out.println(new String(arr));
	}

	public static void nextSmallest(int input) {
		String str = Integer.toBinaryString(input);
		char[] arr = str.toCharArray();
		int zero = 0;
		int zero_count = 0;
		int i = 0;
		for (i = arr.length - 1; i >= 0; --i) {
			if (arr[i] == '0') {
				zero = i;
				zero_count += 1;
			}
			if (arr[i] == '1' && zero > 0) {
				arr[i] = '0';
				arr[zero] = '1';
				break;
			}
		}
		for (int j = arr.length - 1; i < j; --j) {
			if (zero_count > 1) {
				arr[j] = '0';
				--zero_count;
			} else{
				arr[j] = '1';
			}
		}
		System.out.println(str);
		System.out.println(new String(arr));
	}

	public static int followup(int input) {
		String str = Integer.toString(input);
		char[] arr = str.toCharArray();
		int tail = arr.length - 1;
		int head = 0;
		for (head = tail; head > 0; --head) {
			if (arr[head] > arr[head - 1]) {
				for (int j = tail; j >= head; --j) {
					if (arr[j] > arr[head - 1]) {
						char swap = arr[head - 1];
						arr[head - 1] = arr[j];
						arr[j] = swap;
						break;
					}
				}
				break;
			}
		}
		if (head != 0) {
			while (head < tail) {
				char swap = arr[head];
				arr[head] = arr[tail];
				arr[tail] = swap;
				++head;
				--tail;
			}
		}
		return Integer.parseInt(new String(arr));
	}

	public static void permutate(int input) {
		int result = followup(input);
		System.out.println(input);
		if (result == input) {
			return;
		}
		permutate(result);
	}
}
