/*QuickSort_I

Given an array ar and a number p, can you partition the array, so that all
elements greater than p are to the right of it and all the numbers smaller
than p are to its left?

Besides for necessary partitioning, the numbers should otherwise remain in the
same order. This means if n1 was before n2 in the original array, it must
remain before it in the partitioned array, unless n1 > p > n2.

Constraints
1<=n<=1000 
-1000<=x<= 1000 , x ∈ ar

Sample Input
5
4 5 3 7 2

Sample Output
3 2 4 5 7

Explanation
p = 4. The 5 was moved to the right of the 4, and the 2 was moved to the left of
4. The numbers otherwise remained in the same order.
*/


/* Head ends here */
import java.util.*;

class hackerrank_QuickSort_I {
    public static void main(String[] args) {
        Solution test = new Solution();
        test.partition(new int[] {});
        test.partition(new int[] {1});
        test.partition(new int[] {4,5,3,7,2});
        test.partition(new int[] {1,2,3,4,5});
        test.partition(new int[] {5,4,3,2,1});
    }
}


class Solution {
    static void partition(int[] ar) {
        if (ar == null || ar.length < 1) {
            return;
        }
        int pivot = ar[0];
        int head = 0;
        int tail = ar.length - 1;
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
        printArray(ar);
    }
/* Tail starts here */
    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i] = in.nextInt(); 
        }
        partition(ar);
    }    
}
