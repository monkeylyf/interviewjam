/*Tug_of_War


*/


import java.util.*;


class Tug_of_War {
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

	TugOfWar(int[] arr) {
		this.arr = arr;
		this.n = arr.length;
		this.track = new int[this.n / 2];
		this.ret = new int[this.n / 2];
		this.sum = getSum(arr);
		this.minDiff = this.sum;
	}

	public static int getSum(int[] arr) {
		int ret = 0;
		for (int i : arr) {
			ret = ret + i;	
		}
		return ret;
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

	public int indexToSum(int[] index) {
		int ret = 0;
		for (int i : index) {
			ret = ret + this.arr[i];
		}
		return ret;
	}

	public void next(int ptr, int cur) {
		if (this.n - cur < this.n / 2 - ptr) {
			return;	// Trim. if what is left is less than what we need, stop.
		} else if (ptr == track.length) {
			int diff = Math.abs(this.sum - 2 * indexToSum(this.track));
			if (diff < this.minDiff) {
				this.minDiff = diff;
				this.ret = Arrays.copyOfRange(this.track, 0, this.track.length);
			}
		} else {
			for (int i = cur; i < arr.length; ++i) {
				track[ptr] = i;
				next(ptr + 1, i + 1);
			}	
		}
	}
	
	public void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
