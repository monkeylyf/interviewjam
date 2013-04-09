/*Range_Minimum_Query
google

Suppose on your server there is a huge integer array. Clients will request for
local min of subarray A[start:end] given start index and end index.

Write a function to find the local min as fast as possible.
Known as RMQ
*/
/*
1. No brainer:
Create table int[n][n] for each indexes pair. By using dynamic programming,
it's <O(N^2), O(1)>.  Space complexity is a concern for large data set.


2.
Split the array in sqrt(n) places.


Given A[1,...,n], compute B[1,...,n]
where B[i] =  j such that for any k, i <= k <= j,
we have A[k] >= A[i] > A[j + 1]

For example:
index 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
array[9, 5, 1, 2, 0,-1, 3, 6, 4, 10, 11, 7, -2,  8, -3]
     --  -  ----  - --------  ---------  -  ------  --
local 0  1  3  3  4  7  7  7  10 10  10  11 13  13  14


For more solutions:
http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=lowestCommonAncestor
or
http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
*/


class google_Range_Minimum_Query {
    public static void main(String[] args) {
        int[] input = new int[] {9, 5, 1, 2, 0,-1, 3, 6, 4, 10, 11, 7, -2,  8, -3};
        searchArray arr = new searchArray(input);
        for (int i = 0; i < input.length; ++i) {
            for (int j = i; j < input.length; ++j) {
                System.out.print(arr.localMin(i, j) + " ");
            }
            System.out.println();
        }
    }
    public static int[][] noBrainer(int[] A) {
        // Solution 1, no brainer, dp based
        // Space complexity O(N^2), Status matrix creation time complexity O(N^2)
        // Search time complexity O(1).
        int n = A.length;
        int[][] status = new int[n][n];
        for (int i = 0; i < n; ++i) {
            status[i][i] = i; // Given start i end i, min is A[i]
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (A[status[i][j - 1]] > A[j]) {
                    status[i][j] = j;
                } else {
                    status[i][j] = status[i][j - 1];
                }
            }
        }
        return status;
    }
    public static int[] sqrtN(int[] A) {
        int width = Math.sqrt(A.length);
        int[] status = new int[width];
        for (int i = 0; i < width; ++i) {
            int locaMin = i * width;
            for (int j = i * width + 1; j < (i + 1) * width; ++j) {
                if (A[j] < A[localMin]) {
                    localMin = j;
                } 
            }
            status[i] = localMin;
        }
    }
    public static class searchArray {
        int[] array;
        private int[] local;
        private int len;
        searchArray(int[] arr) {
            array = arr;
            len = arr.length;
            local = new int[len];
            localInit();
        }
        private void localInit() {
            local[len - 1] = len - 1;
            int i = 0;
            while (i < len - 1) {
                int cur = array[i];
                int j = i;
                while (j < len - 1) {
                    if (array[j] > array[j + 1]) {
                        break;
                    }
                    ++j;
                }
                for (int k = i; k <= j; ++k) {
                    local[k] = j;
                }
                if (i == j) {
                    ++i;
                } else {
                    i = j;
                }
            }
        }
        public int localMin(int start, int end) {
            if (start < 0 || end >= len || start > end) {
                return Integer.MAX_VALUE;
            }
            int retval = array[start];
            while (start <= end) {
                retval = Math.min(retval, array[start]);
                start = local[start] + 1;
            }
            return retval;
        }
    }
    public static class Node {
        //  0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
        // [9, 5, 1, 2, 0,-1, 3, 6, 4, 10, 11, 7, -2,  8, -3]
        //                           (7,6)
        //              /                              \
        //             (3,2)                       (11,7)
        //       /               \          /                   \
        //      (1,5)        (5,-1)        (9,10)           (13,8)
        //    /       \    /        \    /         \     /            \
        //  (0,9)  (2,1)  (4,0)  (6,3)  (8,4)  (10,11)  (12,-2)  (14,-3)
        //
        // For example, start = 3, end = 11
        // minStart = min of start=3 right kids
        // minEnd = min of end=11 left kids.
        //                           (7,6)
        //              /                              \
        //             (3,2)                       (11,7)
        //       /               \          /                   \
        //      (1,5)        (5,-1)        (9,10)           (13,8)
        //    /       \    /        \    /         \     /            \
        //  (0,9)  (2,1)  (4,0)  (6,3)  (8,4)  (10,11)  (12,-2)  (14,-3)
    }
}
