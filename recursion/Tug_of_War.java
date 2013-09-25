/*Tug_of_War

Try to make two teams balanced for a fair game.
*/


import java.util.*;


public class Tug_of_War {
	public static void main(String[] args) {
		TugOfWar solution = new TugOfWar(new int[] {1,2,3,4,5});
		solution.solve();
		solution = new TugOfWar(new int[] {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4});
		solution.solve();
		solution = new TugOfWar(new int[] {3, 4, 5, -3, 100, 1, 89, 54, 23, 20});
		solution.solve();
	}
}


class TugOfWar {
	int[] arr;
	int[] track;
	int[] ret;
	int n;
	int minDiff;
	int sum;

	TugOfWar(int[] arr) { // Constructor.
		this.arr = arr;
		this.n = arr.length;
		this.track = new int[this.n / 2]; // Status array during backtracking.
		this.ret = new int[this.n / 2]; // Global array storing current best solution.
		this.sum = getSum(arr);
		this.minDiff = this.sum;
	}

	public void solve() {
		next(0, 0);
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : this.ret) {
			set.add(i);
		}
		// Print Team A.
		for (int i = 0; i < this.arr.length; ++i) {
			if (set.contains(i)) {
				System.out.print(i + ": " + this.arr[i] + " ");	
			}
		}
		System.out.println();
		// Print Team B.
		for (int i = 0; i < this.arr.length; ++i) {
			if (!set.contains(i)) {
				System.out.print(i + ": " + this.arr[i] + " ");	
			}
		}
		System.out.println();
	}

	public void next(int ptr, int cur) {
		if (this.n - cur < this.n / 2 - ptr) {
			return;	// Prune. if what is left is less than what we need, stop.
		} else if (ptr == track.length) {
			// Reach the end of array, check if it should update global array.
			int diff = Math.abs(this.sum - 2 * indexToSum(this.track));
			if (diff < this.minDiff) {
				// Update.
				this.minDiff = diff;
				this.ret = Arrays.copyOfRange(this.track, 0, this.track.length);
			}
		} else {
			// Acutally this solution enumerates all possible conbination.
			for (int i = cur; i < arr.length; ++i) {
				track[ptr] = i;
				next(ptr + 1, i + 1);
			}	
		}
	}

	// Helper function to get the sum of int array.
	public static int getSum(int[] arr) {
		int ret = 0;
		for (int i : arr) {
			ret = ret + i;	
		}
		return ret;
	}

	// Hlper function to get the sum of given indexes.
	public int indexToSum(int[] index) {
		int ret = 0;
		for (int i : index) {
			ret = ret + this.arr[i];
		}
		return ret;
	}
	
	public void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
