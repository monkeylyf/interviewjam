/*Google: Given an int array, design an algorithm to rearrange this array so
that the output look like: arr[0] < arr[1] > arr[2] < arr[3] ...*/

import java.util.Random;

class extra_1 {
    public static void main(String[] args) {
       shit(new int[] {4,3,2,5,1,7});
       shit(new int[] {4,3,2,5,1,7,9,-1});
    }
    public static int[] shit(int[] arr) {
        int even = -1;
        int odd = -1;
        int median = getMedian(arr);
        for (int i = 0; i < arr.length; ++i) {
            if (i % 2 == 0 && arr[i] > median) even = i;
            if (i % 2 == 1 && arr[i] <= median) odd = i;
            if (even >= 0 && odd >= 0) {
                swap(arr, even, odd);
                even = -1;
                odd = -1;
            }
        }
        for (int i : arr) System.out.println(i);
        return arr;
    }
    public static int getMedian(int[] arr) {
        return iThSmallest(arr, 0, arr.length -1, (arr.length + 1) / 2);
    }
    public static int iThSmallest(int[] arr, int left, int right, int i) { 
        if (left == right) return arr[left];
        int pivot = random_partition(arr, left, right);
        int left_partition_length = pivot - left + 1;
        if (i == left_partition_length) return arr[pivot];
        else if (i < left_partition_length) return iThSmallest(arr, left, pivot - 1, i);
        else return iThSmallest(arr, pivot + 1, right, i - left_partition_length);
    }
    public static int random_partition(int[] arr, int left, int right) { 
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
    public static void swap(int[] arr, int i, int j) { 
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
