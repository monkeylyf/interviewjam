/*facebook_Product_Equation
facebook

Given N, print all  A * B = C * D where A, B, C, D are within [1, N].
For exmaple, N = 2
print:
1 * 1 = 1 * 1
1 * 2 = 1 * 2
1 * 2 = 2 * 1
2 * 1 = 1 * 2
2 * 1 = 2 * 1
2 * 2 = 2 * 2
*/

import java.util.*;


public class facebook_Product_Equation {

	/* 1. n = 2 case might be misleading. n = 4: 1 * 4 = 2 * 2 meets the requirment.
	 * 2. The larget product we can get is n * n 
	 * 3. Find all the factors of n * n can do conbination.
	 */
	
	public static void main(String[] args) {
		// Test case 1.
		//solve(2);
		// Test case 2.
		//solve(3);
		solve(5);
	}

	public static void solve(int n) {
		HashSet<String> all = new HashSet<String>();
		int[] factors;
		ArrayList<int[]> comb;
		for (int i = 0; i <= n * n; ++i) {
			factors = getFactors(i, n);
			comb = twoPair(factors, i);
			for (int[] left : comb) {
				for (int[] right : comb) {
					addFour(left[0], left[1], right[0], right[1], all);
				}
			}
		}

		for (String str : all) {
			System.out.println(str);	
		}
	}

	// For a * b, there are four combinations.
	public static void addFour(int a, int b, int c, int d, HashSet<String> all) {
		String format = "%d * %d = %d * %d";
		all.add(String.format(format, a, b, c, d));
		all.add(String.format(format, a, b, d, c));
		all.add(String.format(format, b, a, c, d));
		all.add(String.format(format, b, a, d, c));
	}

	// Conbination of legal number pairs.
	public static ArrayList<int[]> twoPair(int[] arr, int product) {
		ArrayList<int[]> ret = new ArrayList<int[]>();
		int i, j;
		for (i = 0; i < arr.length; ++i) {
			for (j = i; j < arr.length; ++j) {
				if (arr[i] * arr[j] == product) {
					ret.add(new int[] {arr[i], arr[j]});	
				}
			}	
		}
		return ret;
	}

	// Given a int n, return a ArrayList containing all it's factors
	// For example: n = 10, return <1, 2, 4, 5, 10>.
	public static int[] getFactors(int n, int max) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 1; i <= n; ++i) {
			if (n % i == 0 && i <= max) {
				arr.add(i);
			}	
		}
		int[] ret = new int[arr.size()];
		for (int i = 0; i < arr.size(); ++i) {
			ret[i] = arr.get(i);
		}
		return ret;
	}

	// Helper function to print out tha int array.
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
