/*Find the ith smallest element of the array in O(n).

Sorted an int array takes O(nlog) but we can do it in O(n)*/

import java.util.Random;

class extra_2 {
    public static void main(String[] args) {
        // The ihea behind this is quick sort.
        for (int i = 1; i < 7; ++i)
            System.out.println(my(new int[] {4,3,2,5,1,7}, i));
    }
    public static int my(int[] arr, int i) {
        return iThSmallest(arr, 0, arr.length - 1, i);
    }
    public static int iThSmallest(int[] arr, int left, int right, int i) {
        if (left == right) {
            return arr[left];
        }
        int pivot = random_partition(arr, left, right);
        int left_partition_length = pivot - left + 1;
        if (i == left_partition_length) {
            return arr[pivot];
        } else if (i < left_partition_length) {
            return iThSmallest(arr, left, pivot - 1, i);
        } else {
            return iThSmallest(arr, pivot + 1, right, i - left_partition_length);
        }
    }
    public static int random_partition(int[] arr, int left, int right) {
        int pivot = new Random().nextInt(right - left + 1) + left;
        swap(arr, pivot, right);
        int pivot_value = arr[right];
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (arr[j] <= pivot_value) {
                ++i;
                swap(arr, i, j);
            }
       }
       swap(arr, i + 1, right);
       return i + 1;
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
