/*Min_Sum_With_Unique_Index_In_Matrix

Given a matrix m, pick one element from each row and none of their
indexes overlaps. There are lots of combination and find the min/max sum
of them.
*/

import java.util.*;

public class Min_Sum_With_Unique_Index_In_Matrix {

	/* 
     * DPS + Backtraking + Prune.
	 */
	
	public static void main(String[] args) {
		Solution sol;
		// Test case 1.
		sol = new Solution(new int[][] {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}});
		System.out.println(sol.getMin() == 3);
		// Test case 2.
		sol = new Solution(new int[][] {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}});
		System.out.println(sol.getMin() == 6);
		// Test case 3.
		sol = new Solution(new int[][] {{4, 4, 4}, {2, 2, 2}, {1, 1, 1}, {3, 3, 3}});
		System.out.println(sol.getMin() == 6);
		// Test case 4.
		sol = new Solution(new int[][] {{3, 3}, {2, 2}, {1, 1}});
		System.out.println(sol.getMin() == 3);
	}
}


class Solution {
	
	private int min;
	private int[][] mtx;
	private int n;
	private int m;
	
	static final int UNINIT = Integer.MAX_VALUE;
	static final boolean DEBUG = false;
	
	Solution(int[][] mtx) { // Constructor.
		this.mtx = mtx;
		this.n = mtx.length;
		this.m = mtx[0].length;
		this.min = UNINIT;
		
		assert(this.n >= this.m); // # of rows should not be less than # of columns.
	}
	
	public void solve() {
		HashSet<Integer> usedCol = new HashSet<Integer>();
		int cur_row = 0, sum = 0;
		this.next(cur_row, sum, usedCol);
	}
	
	public int getMin() {
		if (this.min == UNINIT) {
			this.solve();
		}
		return this.min;
	}
	
	private void next(int cur_row, int sum, HashSet<Integer> usedCol) {
		if (this.DEBUG) {
			System.out.println(String.format("Current row %d current sum %d", cur_row, sum));
			System.out.println(usedCol);
		}
		// Either done with last row or cellected the exact # of element we need, end recursion.
		if (cur_row == this.n || usedCol.size() == this.m) {
			if (usedCol.size() == this.m && this.min > sum) {
				// Find a valid combination of elements picked with unique index. 
				// Update global min.
				if (this.DEBUG) {
					System.out.println(String.format("Updaing global min from %d to %d", this.min, sum));
				}
				this.min = sum;
			}
		} else {
			// Pick one element for current row.
			int i;
			for (i = 0; i < this.m; ++i) {
				if (this.DEBUG) {
					System.out.println(String.format("Looping..Cur row: %d, cur i: %d", cur_row, i));
				}
				if (!usedCol.contains(i) && sum + this.mtx[cur_row][i] < this.min) {
					// 1. Check if current column index has been used. 
					// 2. If not, then check if the sum of current sum and this element is larger than global min to trim recursion.
					usedCol.add(i);
					// Using the size of hashset to indicate index of current row.
					next(cur_row + 1, sum + this.mtx[cur_row][i], usedCol);
					// Backtracking.
					usedCol.remove(i);
				}
			}
			// No pick. Pass to next row directly.
			// Trim. The # of left row must not be less than # of unpicked column #. 
			if (this.n - cur_row + usedCol.size() >= this.m) {
				if (this.DEBUG) {
					System.out.println(String.format("Passed current row: %d", cur_row));
				}
				next(cur_row + 1, sum, usedCol);
			}
		}
	}
}
