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
        int[] arr = new int[] {2,4,3,1,6,7,8,9,1,7};
        SegmentTreeMin stree = new SegmentTreeMin(arr);
        System.out.println(stree.query(1, 2));
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
        // #TODO: unfinished
        int width = (int)(Math.sqrt(A.length));
        int[] status = new int[width];
        for (int i = 0; i < width; ++i) {
            int localMin = i * width;
            for (int j = i * width + 1; j < (i + 1) * width; ++j) {
                if (A[j] < A[localMin]) {
                    localMin = j;
                } 
            }
            status[i] = localMin;
        }
        return new int[1];
    }
}


class SegmentTreeMin {
    private int[] arr;
    private int[] stree;
    private int n;
    public SegmentTreeMin(int[] arr) {
        this.arr = arr;
        this.stree = buildSTree(arr);  
        this.n = arr.length;
    }

    public void print() {
        for (int i : this.stree) System.out.print(i + " ");
        System.out.println();
    }

    public int nextRMQ( int start, int end, int qStart, int qEnd, int index) {
        if (qStart <= start && qEnd >= end) {
            return this.stree[index];
        }
        if (end < qStart || start > qEnd) {
            return Integer.MAX_VALUE;
        }
        int mid = start + (end - start) / 2;
        return Math.min(nextRMQ(start, mid, qStart, qEnd, 2 * index + 1),
                nextRMQ( mid + 1, end, qStart, qEnd, 2 * index + 2));
    }

    public int query(int start, int end) {
        if (start < 0 || end >= this.n || start > end) {
            return Integer.MIN_VALUE;
        }
        return nextRMQ(0, this.n - 1, start, end, 0);
    }

    public int[] buildSTree(int[] arr) {
        int height = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        int maxSize = 2 * (int) (Math.pow(2, height)) - 1;
        int[] STree = new int[maxSize];
        buildSegmentTree(arr, 0, arr.length - 1, STree, 0);
        return STree;
    }

    public int buildSegmentTree(int[] arr, int start, int end,
            int[] STree, int index) {
        if (start == end) {
            STree[index] = arr[start];
            return arr[start];
        }
        int mid = start + (end - start) / 2;
        STree[index] = Math.min(
                buildSegmentTree(arr, start, mid, STree, index * 2 + 1),
                buildSegmentTree(arr, mid + 1, end, STree, index * 2 + 2));
        return STree[index];
    }
}
