/*Partition_Even_Odd

Given an integer array, design a function to partition the integer so that
rearrange all odd numbers are on the left and even numbers are on the right.

Requirement: order of numbers can not be changed/
             space complexity: in-place/ time complexity: O(N)?

e.g.,
input [5,6,8,2,3,9,4]
output [5,3,9,6,8,2,4]
*/

public class Partition_Even_Odd {

    public static void main(String[] args) {
        Solution test  = new Solution();
        test.partition(new int[] {5, 6, 8, 2, 3, 9, 4});
    }
}


class Solution {

    public void partition(int[] arr) {
        printArray(arr);
        int head = 0;
        for (int i = 0; i < arr.length; ++i) { // Find the first even number in arr.
            if (arr[i] % 2 == 0) {
                head = i;
                break;
            }
        }
        int pivot = arr[head];
        int tail = arr.length - 1;
        while (head < tail) {
            while (arr[tail] % 2 == 0) {
                --tail;
            }
            if (head < tail) {
                arr[head++] = arr[tail];
            }
            while (arr[head] % 2 == 1) {
                ++head;
            }
            if (head < tail) {
                arr[tail--] = arr[head];
            }
        }
        arr[head] = pivot;
        printArray(arr);
    }

    public void swap(int[] arr, int head, int tail) {
        int tmp = arr[head];
        arr[head] = arr[tail];
        arr[tail] = tmp;
    }

    public void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
