/*QuickSort

Input Format
There will be two lines of input:

n - the size of the array
ar - the n numbers of the array
Output Format
Print every partitioned sub-array on a new line.

Constraints
1<=n<=1000 
-1000<=x<= 1000 , x ∈ ar
There are no duplicate numbers.

Sample Input

7
5 8 1 3 7 9 2

Sample Output
2 3 
1 2 3 
7 8 9 
1 2 3 5 7 8 9

Explanation
This is a diagram of QuickSort operating on the sample array:
*/

import java.util.*;


class hackerrank_QuickSort_II {
    public static void main(String[] args) {
        Solution test = new Solution();
        //test.quickSort(new int[] {});
        //test.quickSort(new int[] {0});
        //test.quickSort(new int[] {0, 0});
        //test.quickSort(new int[] {0, 1});
        //test.quickSort(new int[] {1, 1});
        //test.quickSort(new int[] {1, 2, 3, 4});
        //test.quickSort(new int[] {4, 3, 2, 1});
        test.quickSort(new int[] {5, 8, 1, 3, 7, 9, 2});
    }
}


/* Head ends here */
class Solution {
    public static void main(String[] args) {
    }
    static void quickSort(int[] ar) {
        if (ar == null) {
            return;
        }
        partition(ar, 0, ar.length - 1);
    }
    public static void partition(int[] ar, int left, int right) {
        // Since during partitioning, the order of numbers can not be changed,
        // we need extra space to buffer the numbers.
        if (left < right) {
            int pivot = ar[left];
            int count = 0;
            int[] tmp = new int[right - left + 1];
            for (int i = left + 1; i <= right; ++i) {
                if (ar[i] <= pivot) {
                    tmp[count++] = ar[i];
                }
            }
            int partition = count + left;
            tmp[count++] = pivot;
            for (int i = left + 1; i <= right; ++i) {
                if (ar[i] > pivot) {
                    tmp[count++] = ar[i];
                }
            }
            int j = left;
            for (int i = 0; i < tmp.length; ++i) {
                ar[j++] = tmp[i];
            }
            partition(ar, left, partition - 1);
            partition(ar, partition + 1, right);
            printArray(ar, left, right);
        }
    }
}
