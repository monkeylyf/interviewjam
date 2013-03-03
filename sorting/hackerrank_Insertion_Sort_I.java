/*Insertion_Sort
hackerrank

Insert element into sorted list
Given a sorted list with an unsorted number V in the right-most cell, can you
write some simple code to insert V into the array so it remains sorted?

s - the size of the array
ar - the sorted array of integers
Output Format
On each line, output the entire array every time an item is shifted in it.

Constraints
1<=s<=1000 
-1000<=x<= 1000 , x ∈ ar

Sample Input

5
2 4 6 8 3
Sample Output

2 4 6 8 8 
2 4 6 6 8 
2 4 4 6 8 
2 3 4 6 8 
*/

import java.util.Scanner;

class hackerrank_Insertion_Sort {
    public static void main(String[] args) {
        Solution test = new Solution();
        test.insertionSort(new int[] {2, 4, 6, 8, 3});
        test.insertionSort(new int[] {2, 4, 6, 8, 9});
        test.insertionSort(new int[] {2, 4, 6, 8, 0});
        test.insertionSort(new int[] {1, 0});
        test.insertionSort(new int[] {0, 1});
        test.insertionSort(new int[] {0});
        test.insertionSort(new int[] {});
    }
}


/* Head ends here */
class Solution {
    static void insertionSort(int[] ar) {
        if (ar == null || ar.length == 0) {
            return;
        }
        int tmp = ar[ar.length - 1];
        int i = ar.length - 2;
        while (i >= 0 && ar[i] > tmp) {
            ar[i + 1] = ar[i];
            i -= 1;
            printArray(ar);
        }
        ar[i + 1] = tmp;
        printArray(ar);
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
