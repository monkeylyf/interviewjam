/*Random_Number_Generator
geeksforgeeks

Given n numbers, each with some frequency of occurrence. Return a random number
with probability proportional to its frequency of occurrence.

Example:

Let following be the given numbers.
  arr[] = {10, 30, 20, 40}  

Let following be the frequencies of given numbers.
  freq[] = {1, 6, 2, 1}  

The output should be
  10 with probability 1/10
  30 with probability 6/10
  20 with probability 2/10
  40 with probability 1/10 
*/


import java.util.*;


public class Random_Number_Generator {

	public static void main(String[] args) {
		// A naive solution is to create a array with freq[0] number of arr[0] and
		// freq[1] number of arr[1]... in it. Then randomly pick a number from [0, len -1]
		// with uniform distribution. BUT it comsumes a lot of memory because there might
		// be a huge number of duplicates in it.


		// O(n) space: Given freq, generate a freq incre arr representinng range
		// e.g., given [10, 5, 20, 100], generate[10, 15, 35, 135].
		// Uniformly generate a token within [0, 135),  find out with range it falls in.
		RandomNumberGenerator gen = new RandomNumberGenerator(new int[] {1, 2, 3, 4}, new int[] {10, 5, 20, 100});

		// Test case.
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 20000; ++i) {
			int ret = gen.rand();
			if (map.containsKey(ret)) {
				map.put(ret, map.get(ret) + 1);
			} else {
				map.put(ret, 1);	
			}
		}
		System.out.println(map);
	}
}


class RandomNumberGenerator {
	int[] incre;
	int[] arr;
	int n;

	public RandomNumberGenerator(int[] arr, int[] freq) {
		this.arr = arr;
		this.n = freq.length;
		this.incre = new int[n];
		for (int i = 0; i < this.n; ++i) {
			this.incre[i] = (i == 0) ? freq[i] : this.incre[i - 1] + freq[i];
		}
	}

	private int binarySearch(int head, int tail, int token) {
		int mid = (tail - head) / 2 + head;
		if (mid == 0) {
			if (token < this.incre[mid]) {
				return mid;
			} else {
				return -1;	
			}
		} else if (this.incre[mid] > token && this.incre[mid - 1] <= token) { // [ this.incre[i], this.incre[i+1] )
			return mid;
		} else if (this.incre[mid - 1] > token) {
			return binarySearch(head, mid - 1, token);	
		} else {
			return binarySearch(mid + 1, tail, token);
		}
	}
	
	public int rand() {
		int token = new Random().nextInt(this.incre[this.n - 1]);
		//System.out.print("token: " + token);
		int idx = binarySearch(0, this.n - 1, token);
		//System.out.println(" index: " + idx);
		return this.arr[idx];
	}

	public void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
