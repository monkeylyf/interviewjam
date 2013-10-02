/*Radix Sorting /Google/

Implement Radix sort.
*/

import java.util.ArrayList;
import java.util.HashMap;


public class google_Radix_Sorting {

    public static void main(String[] args) {
		// Test case 1.
        Solution test = new Solution();
		int[] arr = new int[] {170, 45, 75, 90, 802, 24, 2, 66};
        // for (int i : test.radix_sort(arr)) {
		// 	System.out.print(i + " ");
		// }
		// Test case 2.
		arr = new int[] {170, 45, 75, 90, 802, 24, 2, 66};
		radixSort(arr, 10);
    }

	// Radix sort. Base can be 2, 10, 16, etc...
	// This version is cleaner than the Solution class.
	// How to sort array containing negative numbers?
	// Scan the array once and seperate negative and non-negtive number.
	// Sort them seperated and merge two results(negative array needs to be reversed).
	public static void radixSort(int[] arr, int base) {
		// Find the max absolute value.
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			max = Math.max(max, Math.abs(i));
		}
		int passes = (int) (Math.log(max) / Math.log(base) + 1);
		for (int digitNum = 1; digitNum <= base; ++digitNum) {
			merge(sortByDigit(arr, base, digitNum), arr);
		}
		print(arr);
	}

	private static void merge(ArrayList<ArrayList<Integer>> buckets, int[] arr) {
		int ptr = 0;
		for (ArrayList<Integer> bucket : buckets) {
			for (int i : bucket) {
				arr[ptr++] = i;
			}
		}
	}

	private static ArrayList<ArrayList<Integer>> sortByDigit(int[] arr, int base, int digitNum) {
		// Init ArrayList.
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> foo;
		int digit;
		for (int i = 0; i < base; ++i) {
			foo = new ArrayList<Integer>();
			buckets.add(foo);
		}
		for (int num : arr) {
			digit = getDigit(num, base, digitNum);
			buckets.get(digit).add(num);
		}
		return buckets;
	}

	private static int getDigit(int num, int base, int digitNum) {
		return num / (int) Math.pow(base, digitNum) % base;	
	}

	// Helper function to print out the array.
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}


class Solution {

    private HashMap<Integer, ArrayList<Integer>> buckets;
    private int m;
    private int n;
    private boolean nextDigit;

    Solution() {
        this.buckets = new HashMap<Integer, ArrayList<Integer>>();
        this.m = 10;
        this.n = 1;
        nextDigit = true;
    }

    public int[] radix_sort(int[] A) {
        while (nextDigit) {
            boolean shouldContinue = false;
            for (int i : A) {
                if (i / n >= 10) {
                    shouldContinue = true;
                }
                int digit = (i % m) / n;
                ArrayList<Integer> bucket = buckets.get(digit);
                if (bucket == null) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i);
                    buckets.put(digit, tmp);
                } else {
                    bucket.add(i);
                    buckets.put(digit, bucket);
                }
            }
            int count = 0;
            for (int i = 0; i <= 9; ++i) {
                ArrayList<Integer> bucket = buckets.get(i);
                if (bucket != null) {
                    System.out.println(bucket);
                    for (int j : bucket) {
                        A[count++] = j;
                    }
                }
            }
            this.m *= 10;
            this.n *= 10;
            this.buckets = new HashMap<Integer, ArrayList<Integer>>();
            this.nextDigit = shouldContinue;
        }
        return A;
    }
}
