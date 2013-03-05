/*Insertion_Sort_II

Input Format
There will be two lines of input:

s - the size of the array
ar - the list of numbers that makes up the array
Output Format
On each line, output the entire array every time an item is inserted into its place.

Constraints
1<=s<=1000 
-1000<=x<= 1000 , x ∈ ar

Sample Input

6
1 4 3 5 6 2
Sample Output

1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6 
*/

import java.util.*;

class hackerrank_Insertion_Sort_II {
    public static void main(String[] args) {
        Solution test = new Solution();
        test.insertionSort(new int[] {1,4,3,5,6,2});
    }
}

class Solution {
    public static void insertionSort(int[] ar) {
        if (ar == null || ar.length < 1) {
            return;
        }
        for (int i = 1; i < ar.length; ++i) {
            int tmp = ar[i];
            int j = i - 1;
            while (j >= 0 && ar[j] > tmp) {
                ar[j + 1] = ar[j];
                --j;
            }
            ar[j + 1] = tmp;
            printArray(ar);
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
        insertionSort(ar);
    }
}
