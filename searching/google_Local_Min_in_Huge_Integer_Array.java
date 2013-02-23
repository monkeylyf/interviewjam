/*Local_Min_in_Huge_Integer_Array
google

Suppose on your server there is a huge integer array. Clients will request for
local min of subarray A[start:end] given start index and end index.

Write a function to find the local min as fast as possible.

Given A[1,...,n], compute B[1,...,n]
where B[i] =  j such that for any k, i <= k <= j,
we have A[k] >= A[i] > A[j + 1]

For example:
index 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
array[9, 5, 1, 2, 0,-1, 3, 6, 4, 10, 11, 7, -2,  8, -3]
     --  -  ----  - --------  ---------  -  ------  --
local 0  1  3  3  4  7  7  7  10 10  10  11 13  13  14
*/


class google_Local_Min_in_Huge_Integer_Array{
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
