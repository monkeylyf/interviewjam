/*Unique Paths

A robot is located at the top-left corner of a m x n grid (marked 'Start' in
the diagram below).
The robot can only move either down or right at any point in time. The robot is
trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
Note: m and n will be at most 100.
*/


class leetcode_116 {
    public static void main(String[] args) {
    }
    public static int uniquePaths(int m, int n) {
        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i = 0; i < n; ++i) prev[i] = 1;
        for (int i = 1; i < m; ++i) {
            for (int j  = 0; j < n; ++j) {
                if (j == 0) {
                    next[j] = 1;
                } else {
                    next[j] = next[j - 1] + prev[j];
                } 
            }
            prev = next;
            next = new int[n];
        }
        return prev[prev.length - 1];
    }
}
