/*Median_of_Two_Sorted_Arrays

There are two sorted arrays A and B of size m and n respectively. Find the
median of the two sorted arrays. The overall run time complexity should be
O(log (m+n)).
*/

class leetcode_Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {4}, new int[] {1,2,3}));
        //System.out.println(findMedianSortedArrays(new int[] {1}, new int[] {1}));
        //System.out.println(get(new int[] {1, 2, 3}, 0, 0, 1));
        //System.out.println(get(new int[] {2, 3}, 0, 0, 1));
        //System.out.println(get(new int[] {1}, 0, 0, 1));
        //System.out.println(get(new int[] {}, 0, 0, 1));
    }
    public static double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length == 0) {
            return median(B);
        } else if (B.length == 0) {
            return median(A);
        }
        return findMedian(A, B, 0, A.length - 1);
    }
    public double median(int[] A) {
        int middle = A.length / 2;
        if (A.length % 2 == 0) {
            return (A[middle] + A[middle - 1]) / 2.0;
        } else {
            return A[middle];
        }
    }
    public static double findMedian(int[] A, int[] B, int l, int r) {
        if (l > r) {
            l = Math.max(0, (A.length + B.length) / 2 - A.length);
            r = Math.min(B.length, (A.length + B.length) / 2);
            return findMedian(B, A, 0, B.length - 1);
        }
        int i = (l + r) / 2; // Start with the median of A.
        int j = (A.length + B.length) / 2 - i - 1;
        if (j >= 0 && A[i] < B[j]) {
            // A[i] <= B[j] <= B[j + 1]
            //   1 3 5    with i = 1
            // -1   4 6 7 with j = 1
            // Meaning A[i] is less than the median.
            return findMedian(A, B, i + 1, r); // Binary Search based.
        } else if (j < B.length - 1 && A[i] > B[j + 1]) {
            // B[j] <= B[j + 1] <= A[i]
            //      1 3 5
            // -3 -1 2 4
            // Meaning A[i] is larger than the median.
            return findMedian(A, B, l, i - 1);
        } else {
            // B[j] <= A[i] <= B[j + 1] (or B[j] <= A[i]  B[j + 1]indexOfBoundary)
            // We've got the median A[i]
            if ((A.length + B.length) % 2 == 1 ) {
                return A[i];
            } else if (i > 0) {
                // A.length + B.length is even.
                System.out.println("i " + i + " j " + j);
                return (A[i] + Math.max(B[j], A[i - 1])) / 2.0;
            } else {
                // A.length + B.length is even and i = 0.
                return (A[i] + B[j]) / 2.0;
            }
        }
    }
    public static double Median(int[] A, int[] B) {
        int m = A.length, n = B.length;
        //if m+n is even, then the median is the average of (m+n)/2 and (m+n)/2 - 1
        //if m+n is odd, then the median is (m+n)/2
        int mid = (m + n) / 2;
        //look for mid in A
        //[start, end]: close region to try. inclusive.
        int start = 0, end = m - 1, i = 0, j = 0;
        int median = 0;
        while (start <= end) {
            i = (start + end) / 2;
            j = mid - i;
            if (get(B, j - 1) <= get(A, i) && get(A, i) <= get(B, j)) {
                //index out of bound here.
                median = get(A, i);
                break;
            } else if (get(A, i)< get(B, j-1)) { //A[i] is smaller than the median
                start = i + 1;
                i = (start+end)/2;
                j = mid - i;
            } else if (get(A, i) > get(B, j)) { //A[i] is bigger than the median
                end = i - 1;
                i = (start + end)/2;
                j = mid - i;
            }
        }
        if (start <= end) {
            //found the median
            if ((m+n) % 2 == 0) { //index out of bound here
                int other = Math.max(get(A, i-1), get(B, j-1));
                return (median + other) * 0.5;
            } else {
                return (double)median;
            }
        } else { 
            //not found the median
            //look for median in B
            return Median(B, A);
        }
    }
    public static int get(int[] a, int i){
        if (i < 0) {
            return Integer.MIN_VALUE;
        } else if ( i >= a.length) {
            return Integer.MAX_VALUE;
        } else {
            return a[i];
        }
    }
}
