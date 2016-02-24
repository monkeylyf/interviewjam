/*kth_Maximum_Element_in_Sorted_Matrix
google

Find the k-th maximum element in a sorted matrix.

e.g,.
[
    [1, 2, 6, 10]
    [3, 4, 7, 13]
    [5, 9, 11, 14]
    [8, 12,15, 16]
]

For a sorted, matrix, every row is sorted and every column is sorted.

Please check:
cap_Search_a_Sorted_Matrix

These two questions are strongly-related.
*/

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class google_kth_Maximum_Element_in_Sorted_Matrix {

    public static void main(String[] args) {
		// Test case for search.
        int[][] matrix = {{1, 2, 6, 10},
                          {3, 4, 7, 13},
                          {5, 9, 11, 14},
                          {8, 12, 15, 16}};
		for (int i = 0; i < 16; ++i) {
			System.out.println(String.format("%d: %d", i, search(matrix, i)));
		}
		// Test case for getOrder.
		int[][] m = {{1, 3, 5},
					 {2, 4, 8},
					 {6, 9, 10}};
		for (int i = 1; i < 11; ++i) {
			System.out.println(String.format("%d: %d", i, getOrder(m, 3, 3, i)));
		}
    }
	
	// Binary search.
	// Time complexity O(lg(m*n)*(m+n) + (m+n))
	// Space complexity O(1)
    public static int search(int[][] m, int k) {
		int row = m.length, col = m[0].length;
		int low = m[0][0], high = m[row - 1][col - 1];
		int mid = 0, order;
		// Binary search. Find a int mid, no matther it exists in matrix or not, there are k
		// elements less than mid.
		while (true) {
			mid = (low + high) / 2;
			order = getOrder(m, row, col, mid);
			if (order == k) {
				break;	
			} else if (order > k) {
				high = mid - 1;	
			} else {
				low = mid + 1;
			}
		} // End of while.

		// Find the largest element in matrix less than mid.
		int rowCursor = 0, colCursor = col - 1;
		int ret = mid;
		while (rowCursor < row && colCursor >= 0) {
			if (m[rowCursor][colCursor] < mid) {
				ret = (m[rowCursor][colCursor] > ret) ? m[rowCursor][colCursor] : ret;
				++rowCursor;
			} else {
				--colCursor;	
			}
		}
		return ret;
    }
	
	// Given target, find what's the order of target in matrix.
	// Time complexity O(m+n)
	// Space complexity O(1)
	public static int getOrder(int[][] m, int row, int col, int k) {
		int rowCursor = 0, colCursor = col - 1, order = 0;
		while (rowCursor < row && colCursor >= 0) {
			if (m[rowCursor][colCursor] < k) {
				order += (colCursor + 1);
				++rowCursor;
			} else {
				--colCursor;	
			}
		}
		return order;
	}

	// The idea behind this is using min heap to add element in Young tableau.
	// Advantage: easy to understand.
	// Disadvantage: Space O(M * N) to track the status of each element(added or not).
	//               Time O(n^2 logn)
    public static int kthMaximum(int[][] m, int k) {
        int ret = 0;
        int row = m.length;
        int col = m[0].length;
        Comparator<Integer> max = new minComparator();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(100, max);
        HashMap<Integer, int[]> dict= new HashMap<Integer, int[]>();
        minHeap.offer(m[row - 1][col - 1]);
        dict.put(m[row - 1][col - 1], new int[] {row - 1, col - 1});
        while (k > 0) {
            ret = minHeap.poll();
            int[] cor = dict.get(ret);
            if (cor[0] > 0 && !dict.containsKey(m[cor[0] - 1][cor[1]])) {
                minHeap.offer(m[cor[0] - 1][cor[1]]);
                dict.put(m[cor[0] - 1][cor[1]], new int[] {cor[0] - 1, cor[1]});
            }
            if (cor[1] > 0 && !dict.containsKey(m[cor[0]][cor[1] - 1])) {
                minHeap.offer(m[cor[0]][cor[1] - 1]);
                dict.put(m[cor[0]][cor[1] - 1], new int[] {cor[0], cor[1] - 1});
            }
            --k;
        }
        return ret;
    }
}


class minComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        if (a < b) {
            return 1;
        } else if (a > b) {
            return -1;
        } else {
            return 0;
        }
    }
}
