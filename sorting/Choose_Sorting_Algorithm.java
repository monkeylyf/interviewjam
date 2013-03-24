/*Choose_Sorting_Algorithm
careercup

If you have a 2 GB file with one string per line, which sorting algorithm
would you use to sort the file and why?
*/

import java.util.*;


class cap_Choose_Sorting_Algorithm {
    public static void main(String[] args) {
    }
    // merge sort. O(nlogn). stable. Non-in-place.
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        left = mergeSort(left);
        right = mergeSort(right);
        int[] ret = new int[arr.length];
        System.arraycopy(left, 0, ret, 0, middle);
        System.arraycopy(right, 0, ret, middle, right.length);
        return merge(left, right);
    }
    public static int[] merge(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int ptr = 0, leftPtr = 0, rightPtr = 0;
        while (leftPtr < left.length || rightPtr < left.length) {
            if (leftPtr < left.length && rightPtr < right.length) {
                if (left[leftPtr] <= right[rightPtr]) {
                    ret[ptr++] = left[leftPtr++];
                } else {
                    ret[ptr++] = right[rightPtr++];
                }
            } else if (leftPtr < left.length) {
                while(leftPtr < left.length) {
                    ret[ptr++] = left[leftPtr++];
                }
            } else if (rightPtr < right.length) {
                while (rightPtr < right.length) {
                    ret[ptr++] = right[rightPtr++];
                }
            }
        }
        return ret;
    }
    // quick sort. O(nlog). inplace. non-stable.
    public static void quickSort(int[] ar) {
        if (ar == null) {
            return;
        }
        partition(ar, 0, ar.length - 1);
    }
    public static void partition(int[] ar, int left, int right) {
        if (left < right) {
            int pivot = ar[left];
            int head = left;
            int tail = right;
            while (head < tail) {
                while (ar[tail] >= pivot && head < tail) {
                    --tail;
                }
                if (head < tail) {
                    ar[head++] = ar[tail];
                }
                while (ar[head] < pivot && head < tail) {
                    ++head;
                }
                if (head < tail) {
                    ar[tail--] = ar[head];
                }
            }
            ar[head] = pivot;
            partition(ar, left, head - 1);
            partition(ar, head + 1, right);
        }
    }
    // insert sort. O(n + d). Stable. In-place. Online.
    public static void insertionSort(int[] ar){
        if (ar == null || ar.length < 1) {
            return;
        }
        for (int i = 1; i < ar.length; ++i) {
            insertionSortByIndex(ar, i);
        }
    }
    static void insertionSortByIndex(int[] ar, int index) {
        if (ar == null || ar.length == 0 || index < 1) {
            return;
        }
        int tmp = ar[index];
        int i = index - 1;
        while (i >= 0 && ar[i] > tmp) {
            ar[i + 1] = ar[i];
            i -= 1;
        }
        ar[i + 1] = tmp;  
    }
    // radix sort.
}
