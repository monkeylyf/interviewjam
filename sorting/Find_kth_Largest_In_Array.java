/*Find the ith smallest element of the array in O(n).

Sorted an int array takes O(nlog) but we can do it in O(n)
*/

import java.util.Random;


public class Find_kth_Largest_In_Array {

	/**
	 * This solution is based on quickSort.
	 * Another working solution is heap but it's trivial.
	 */

    public static void main(String[] args) {
        // The idea behind this is quick sort.
        for (int i = 1; i < 7; ++i) {
            System.out.println(my(new int[] {4,3,2,5,1,7}, i));
            System.out.println();
        }
    }

    public static int my(int[] arr, int i) {
        return kthSmallest(arr, 0, arr.length - 1, i);
    }

    private static int kthSmallest(int[] arr, int left, int right, int i) {
        if (left == right) {
            return arr[left];
        }
        int pivot = randomPartition(arr, left, right);
		// Partition length represents how 
        int left_partition_length = pivot - left + 1;
		// In this special case we only care that kth largest element is at kth position.
		// The first k-1 elements do not need to be sorted so do all the element after k.
        if (i == left_partition_length) {
            return arr[pivot];
        } else if (i < left_partition_length) {
            return kthSmallest(arr, left, pivot - 1, i);
        } else {
            return kthSmallest(arr, pivot + 1, right, i - left_partition_length);
        }
    }

    public static int randomPartition(int[] arr, int left, int right) {
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

	// Helper function to swap two elements in array.
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

	// Helper function to print array.
    public static void print(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
