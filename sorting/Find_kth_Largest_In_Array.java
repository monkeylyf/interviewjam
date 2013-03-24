/*Find the ith smallest element of the array in O(n).

Sorted an int array takes O(nlog) but we can do it in O(n)*/

import java.util.Random;

class Find_kth_Largest_In_Array {
    public static void main(String[] args) {
        // The idea behind this is quick sort.
        for (int i = 1; i < 7; ++i) {
            System.out.println(my(new int[] {4,3,2,5,1,7}, i));
            System.out.println();
        }
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
        int pivot_value = arr[pivot];
        System.out.println("pivot " + pivot);
        swap(arr, pivot, right);
        for (int j = left; j < right; ++j) {
            if (arr[j] <= pivot_value) {
                swap(arr, left, j);
                ++left;
            }
            print(arr);
       }
       swap(arr, left, right);
       return left;
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void print(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
