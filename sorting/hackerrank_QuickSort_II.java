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
    static void quickSort(int[] ar) {
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
            printArray(Arrays.copyOfRange(ar, left, right + 1));
        }
    }
/* Tail starts here */
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt(); 
        }
        quickSort(ar);
    }    
}
