/*Sort_Colors

Given an array with n objects colored red, white or blue, sort them so that
objects of the same color are adjacent, with the colors in the order red, white
and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white,
and blue respectively.
Note:
You are not suppose to use the library's sort function for this problem.
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite
array with total number of 0's, then 1's and followed by 2's.
Could you come up with an one-pass algorithm using only constant space?
*/


class leetcode_Sort_Colors {
    public static void main(String[] args) {
    }
    public static void sortColors(int[] A) {
        // The idea behind this is using three pointers.
        int start = 0;
        int end = A.length - 1;
        int middle = 0;
        while (middle <= end) {
            if (A[middle] == 0) {
                swap(A, middle, start); // all 0s swapped to the left.
                ++start;
                ++middle;
            } else if (A[middle] == 2) {
                swap(A, middle, end); // all 2s swapped to the right
                --end;
            } else {
                // A[start] == 1.
                ++middle; // for 1, swap nothing.
            }
        }
    }
    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
