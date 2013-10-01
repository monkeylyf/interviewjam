/*Median_Interleaving
Google

Given an int array, design an algorithm to rearrange this array so
that the output look like: arr[0] < arr[1] > arr[2] < arr[3] ...
*/

import java.util.Random;

public class google_Median_Interleaving{

	/**
	 * The odd-indexed elements are the peaks, and even-indexed are valleys.
	 * If we can find the median of this array and rearrange all element larger
	 * than median to odd-indexed position, the rearranged array meets the
	 * requirements.
	 */

    public static void main(String[] args) {
	   // Test case 1.
       //medianInterleave(new int[] {4,3,2,5,1,7});
       medianInterleave(new int[] {1,2,3,4,5,7});
	   // Test case 2.
       //medianInterleave(new int[] {4,3,2,5,1,7,9,-1});
    }

    public static int[] medianInterleave(int[] arr) {
        int even = -1, odd = -1;
		// Use quicksort way to find median is overkill.
        int median = getMedian(arr);
		// Rearrange the array in-place.
        for (int i = 0; i < arr.length; ++i) {
			System.out.println(i + ":");
            if (i % 2 == 0 && arr[i] > median) {
				even = i;
				System.out.println("Setting even to " + i);
			} else if (i % 2 == 1 && arr[i] <= median) {
				odd = i;
				System.out.println("Setting odd to " + i);
			}
            if (even >= 0 && odd >= 0) {
				System.out.println("Swapping odd " + odd + " even " + even);
                swap(arr, even, odd);
                even = -1;
                odd = -1;
            }
        }
		print(arr);
        return arr;
    }

    public static int getMedian(int[] arr) {
        return kthSmallest(arr, 0, arr.length -1, (arr.length + 1) / 2);
    }

    public static int kthSmallest(int[] arr, int left, int right, int i) { 
        if (left == right) {
			return arr[left];
		}
        int pivot = randomPartition(arr, left, right);
        int left_partition_length = pivot - left + 1;
        if (i == left_partition_length) {
			return arr[pivot];
        } else if (i < left_partition_length) {
			return kthSmallest(arr, left, pivot - 1, i);
        } else {
			return kthSmallest(arr, pivot + 1, right, i - left_partition_length);
		}
    }

    public static int randomPartition(int[] arr, int left, int right) { 
        Random rand = new Random();
        int pivot = rand.nextInt(right - left + 1) + left;
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

	// Helper function to swap two elements.
    public static void swap(int[] arr, int i, int j) { 
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

	// Helper function to print the array.
	public static void print(int[] arr) {
		for (int i : arr) System.out.print(i + " ");
		System.out.println();
	}
}
