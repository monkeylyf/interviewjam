/*Next_Permutation

Implement next permutation, which rearranges numbers into the lexicographically
next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest
possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its
corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/


public class leetcode_Next_Permutation {

    public static void main(String[] args) {
        nextPermutation(new int[] {5,4,7,5,3,2});
        nextPermutation(new int[] {1,1});
    }

    public static void nextPermutation(int[] num) {
        if (num.length == 1) {
            return;
        }
        int i = num.length -2;
        // Find the digit need to be swapped.
        // for [5,4,7,5,3,2], i = 1. 
        for (; i >= 0; --i) {
            if (num[i] < num[i + 1]) {
                break; 
            }
        }
        // Find the num in [i + 1:] which the next larger number of num[i].
        // Swap if such digit is found.
        if (i >= 0) {
            int index = i + 1;
            for (int j = i + 1; j < num.length; ++j) {
                if (num[j] > num[i] && num[j] < num[index]) {
                    index = j;
                }
            }
            int swap = num[i];
            num[i] = num[index];
            num[index] = swap;
        }
        // Sort [i + 1:] ascending.
        for (int k = i + 1; k < num.length - 1; ++k) {
            for (int h = i + 1; h < num.length - 1; ++h) {
                if (num[h] > num[h + 1]) {
                    int swap = num[h];
                    num[h] = num[h + 1];
                    num[h + 1] = swap;
                }
            }
        }
    }
}
