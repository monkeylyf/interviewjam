/*Segment_Tree_Sum


*/


class Segment_Tree_Sum {
    public static void main(String[] args) {
        System.out.println(segmentTree(new int[] {2,4,3,1,6,7,8,9,1,7}, 2,7));
        System.out.println(segmentTree(new int[] {1, 3,5, 7, 9, 11}, 2,4));
    }
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    public static int segmentTree(int[] A, int start, int end) {
        // segment tree has the same structure as a heap
        // For a non-leaf node numbered x, the left son of x is 2*x and the right son 2*x+1. 
        // Height of segment tree: (int)(Math.ceil(Math.log(A.length) / Math.log(2)))
        // Maximum size of segment tree: 2
        // Update operation time complexity O(logn)
        // Query operation time complexity O(logn)
        int n = A.length;
        int[] stree = buildSTree(A);
        printArray(stree);
        return getSum(stree, n, start, end);
    }
    
    public static int sumNext(int[] STree, int start, int end, int qStart, int qEnd, int index) {
        if (qStart <= start && qEnd >= end) {
            return STree[index];
        }
        if (end < qStart || start > qEnd) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        return sumNext(STree, start, mid, qStart, qEnd, 2 * index + 1) + sumNext(STree, mid + 1, end, qStart, qEnd, 2 * index + 2);
    }
    // Update Setment Tree.
    public static void updateSTree(int arr[], int[] STree, int n, int i, int val) {
        if (i >= n || i < 0) {
            return; // Illegal index.
        }
        int diff = val - arr[i];
        arr[i] = val;
        updateSum(STree, 0, n - 1, i, diff, 0);
    }
    
    public static void updateSum(int[] STree, int start, int end, int i, int diff, int index) {
        if (i < start || i > end) {
            return;
        }
        STree[index] += diff;
        if (start != end) {
            int mid = start + (end - start) / 2;
            updateSum(STree, start, mid, i, diff, 2 * index + 1);
            updateSum(STree, mid + 1, end, i, diff, 2 * index + 2);
        }
    }
    
    // Query Segment Tree.
    public static int getSum(int[] STree, int n, int start, int end) {
        if (start < 0 || end >= n || start > end) {
            return Integer.MIN_VALUE;
        }
        return sumNext(STree, 0, n - 1, start, end, 0);
    }
    
    // Build Segment Tree.
    public static int[] buildSTree(int[] arr) {
        int height = (int)(Math.ceil(Math.log(arr.length) / Math.log(2)));
        int maxSize = 2 * (int)(Math.pow(2, height)) - 1;
        int[] STree = new int[maxSize];
        buildSegmentTree(arr, 0, arr.length - 1, STree, 0);
        return STree;
    }
    
    public static int buildSegmentTree(int[] arr, int start, int end, int[] STree, int index) {
        if (start == end) {
            STree[index] = arr[start];
            return arr[start];
        }   
        int mid = start + (end - start) / 2;
        STree[index] = buildSegmentTree(arr, start, mid, STree, index * 2 + 1) + buildSegmentTree(arr, mid + 1, end, STree, index * 2 + 2);
        return STree[index];
    }
}
