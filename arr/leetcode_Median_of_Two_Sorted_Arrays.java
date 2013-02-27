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
    public static double MedianOfFour(int a, int b, int c, int d) {
        int min = Math.min(d, Math.min(c, Math.min(b, a)));
        int max = Math.max(d, Math.max(c, Math.max(b, a)));
        return (a + b + c + d - min - max) / 2.0;
    }
    public static double MedianOfThree(int a, int b, int c) {
        int min = Math.min(c, Math.min(b, a));
        int max = Math.max(c, Math.max(b, a));
        return (a + b + c - min - max);
    }
    public static double findMedianSortedArrays(int[] A, int[] B) {
        if (B.length >= A.length) {
            return medianSortedArrays(A, B);
        } else {
            return medianSortedArrays(B, A);
        }
    }
    public static double medianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0) {
            if (m % 2 == 1) {
                return B[m / 2];
            } else {
                return (B[m / 2 - 1] + B[m / 2]) / 2.0;
            }
        } else if (n == 1) {
            if (m == 1) {
                return (A[0] + B[0]) / 2.0;
            } else if (m % 2 == 1) { // m is odd.
                return (B[m / 2] + MedianOfThree(A[0], B[m / 2 - 1], B[m / 2 + 1])) / 2.0;
            } else { // m is even.
                return MedianOfThree(A[0], B[m / 2 - 1], B[m / 2]);
            }
        } else if (n == 2) {
            if (m == 2) {
                return MedianOfFour(A[0], A[1], B[0], B[1]);
            }
            if (m % 2 == 1) { // m is odd.
                return MedianOfThree(B[m / 2], Math.min(A[0], B[m / 2 + 1]), Math.max(A[1], B[m / 2 - 1]));
            } else { // m is even.
                return MedianOfFour(B[m / 2 - 1], B[m / 2], Math.min(A[0], B[m / 2 + 1]), Math.max(A[1], B[m / 2 - 2]));
            }
        }
        int minRemoved = 0, idxA = n / 2, idxB = m / 2;
        if (A[idxA] < B[idxB]) {
            if (n % 2 == 0) {
                --idxA;
            }
            minRemoved = Math.min(idxA, m - idxB - 1);
            return medianSortedArrays(Arrays.copyOfRange(A, minRemoved, A.length), Arrays.copyOfRange(B, 0, B.length - minRemoved));
        } else {
            if (m % 2 == 0) {
                --idxB;
            }
            minRemoved = Math.min(n - idxA - 1, idxB);
            return medianSortedArrays(Arrays.copyOfRange(A, 0, A.length - minRemoved), Arrays.copyOfRange(B, minRemoved, B.length));
        }
    }
}
