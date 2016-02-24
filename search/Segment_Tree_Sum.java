/*Segment_Tree_Sum

Topcoder link:
http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=lowestCommonAncestor#Segment_Trees

Segment tree is a good tool to solve RMQ(Range Minimum Query) Question.

            [0:4]
		  /       \
	   [0:2]     [3:4]
	  /    \    /     \
	[0:1]  [2] [3]    [4]
	/   \
  [0]   [1]
*/


public class Segment_Tree_Sum {

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
        return rangeSum(stree, n, start, end);
    }
    
    // Update Setment Tree.
    public static void updateSTree(int arr[], int[] STree, int n, int i, int val) {
        if (i >= n || i < 0) {
            return; // Illegal index.
        }
        int diff = val - arr[i];
        arr[i] = val;
        updateSTreeUtil(STree, 0, n - 1, i, diff, 0);
    }
    
    private static void updateSTreeUtil(int[] STree, int start, int end, int i, int diff, int index) {
        if (i < start || i > end) {
            return;
        }
        STree[index] += diff;
        if (start != end) {
            int mid = start + (end - start) / 2;
            updateSTreeUtil(STree, start, mid, i, diff, 2 * index + 1);
            updateSTreeUtil(STree, mid + 1, end, i, diff, 2 * index + 2);
        }
    }
    
    // Query Segment Tree.
    public static int rangeSum(int[] STree, int n, int start, int end) {
        if (start < 0 || end >= n || start > end) {
            return Integer.MIN_VALUE;
        }
        return rangeSumUtil(STree, 0, n - 1, start, end, 0);
    }
    
    private static int rangeSumUtil(int[] STree, int start, int end, int qStart, int qEnd, int index) {
        if (qStart <= start && qEnd >= end) {
            return STree[index]; // The query range is larger than range current node represents.
        } else if (end < qStart || start > qEnd) {
            return 0; // Range mismatch.
        } else { // There is overlap and mismatch.
			int mid = start + (end - start) / 2;
			return rangeSumUtil(STree, start, mid, qStart, qEnd, 2 * index + 1) +
				   rangeSumUtil(STree, mid + 1, end, qStart, qEnd, 2 * index + 2);
		}
    }

    // Build Segment Tree.
    public static int[] buildSTree(int[] arr) {
		// Calculate the height of Segment Tree.
        int height = (int)(Math.ceil(Math.log(arr.length) / Math.log(2)));
		// Calculate the length of heap-like array.
        int maxSize = 2 * (int)(Math.pow(2, height)) - 1;
        int[] STree = new int[maxSize];
        buildSTreeUtil(arr, 0, arr.length - 1, STree, 0);
        return STree;
    }
    
    private static int buildSTreeUtil(int[] arr, int start, int end, int[] STree, int index) {
        if (start == end) {
            STree[index] = arr[start];
            return arr[start];
        } else {
			int mid = start + (end - start) / 2;
			STree[index] = buildSTreeUtil(arr, start, mid, STree, index * 2 + 1) +
						   buildSTreeUtil(arr, mid + 1, end, STree, index * 2 + 2);
			return STree[index];
		}
    }
}
