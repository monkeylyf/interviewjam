/*Merge_K_Sorted_Arrays
Twitter

Given k sorted arrays with length n. Merge them into one sorted arrays.
*/


import java.util.*;

public class Merge_K_Sorted_Arrays {

    public static void main(String[] args) {
        mergeTestSuite();
    }

    public static void mergeTestSuite() {
        int[][] test1 = new int[][] { { 1, 3, 5, 7, 9 }, { 2, 4, 6, 8, 10 } };
        printArray(merge(test1));
    }

    public static int[] merge(int[][] arrays) {
        // The idea behind this is using min-heap to track the heads of arrays.
        // When k is large this helps reduce the time complexity O(n * k * logk).
        // When k is relatively small, brutal force merging will be better.
        int n = arrays.length, m = arrays[0].length, ptr = m * n - 1, i, j;
        int[] ret = new int[n * m];
        PriorityQueue<Cell> q = new PriorityQueue<Cell>();
        for (i = 0; i < n; ++i) {
            q.add(new Cell(m - 1, i, arrays[i][m - 1]));
        }
        while (!q.isEmpty()) {
            Cell cur = q.poll();
            System.out.println(cur);
            ret[ptr] = cur.val;
            if (cur.index > 0) {
                q.add(new Cell(cur.index - 1, cur.arrayIndex,
                        arrays[cur.arrayIndex][cur.index - 1]));
            }
            --ptr;
        }
        return ret;
    }

    public static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}

class Cell implements Comparable<Cell> {
    int index;
    int arrayIndex;
    int val;

    Cell(int index, int arrayIndex, int val) {
        this.index = index;
        this.arrayIndex = arrayIndex;
        this.val = val;
    }

    @Override
    public int compareTo(Cell e) {
        return e.val - this.val;
    }

    public String toString() {
        return "[" + this.arrayIndex + ", " + this.index + "]: " + this.val;
    }
}
