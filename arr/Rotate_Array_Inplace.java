/*Rotate_Array_Inplace

Given array [a1..ai,ai+1..an], output [ai+1..an,a1..ai]

Requirement: O(n) time complexity. No extra space(inplace)
*/


class Rotate_Array_Inplace {
    public static void main(String[] args) {
        Rotate(new int[] {1, 2, 3, 4 ,5}, 0);
        Rotate(new int[] {1, 2, 3, 4 ,5}, 1);
        Rotate(new int[] {1, 2, 3, 4 ,5}, 2);
        Rotate(new int[] {1, 2, 3, 4 ,5}, 3);
        Rotate(new int[] {1, 2, 3, 4 ,5}, 4);
    }
    public static void Rotate(int[] arr, int pivot) {
        if (pivot >= arr.length || pivot < 1) {
            return;
        }
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, arr.length - pivot - 1);
        reverse(arr, arr.length - pivot, arr.length - 1);
        printArray(arr);
    }
    public static void reverse(int[] arr, int head, int tail) {
        while (head < tail) {
            int tmp = arr[head];
            arr[head++] = arr[tail];
            arr[tail--] = tmp;
        }
    }
    public static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
