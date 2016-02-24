/*Find_Duplicates.

Given int array with length 10001 and it contains integers from 1 to
10000 and each integer appears only once except one.
Find the duplicated one.
There are multiple ways to solve this problem. How many ways can you think of?
*/


import java.util.*;


public class Find_Duplicates {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(dup(new int[] {1,2,3,4,3}) == dups(new int[] {1,2,3,4,3}));
        System.out.println(dup(new int[] {1,2,3,4,3}) == dups(new int[] {1,2,3,4,3}));
        //
        System.out.println(dup(new int[] {1,2,3,4,3}) == bit(new int[] {1,2,3,4,3}));
        System.out.println(dup(new int[] {1,2,3,4,3}) == bit(new int[] {1,2,3,4,3}));
    }
    
    public static int dup(int[] arr) {
        // Sum of indexes: 0,1,2,..n
        // Sum of values:    1,2,3,n + dup
        int ret = 0;
        for (int i = 0; i < arr.length; ++i) {
            ret += arr[i] - i;
        }
        return ret;
    }
    
    public static int dups(int[] arr) {
        // No-brainer. sum the index up and sum the non-duplicated element up
        // then do the subtraction.
        int ret = 0;
        for (int i = 0; i < arr.length; ++i) {
            ret += arr[i];
        }
        return ret - (arr.length - 1) * arr.length / 2;
    }

    public static int bit(int[] arr) {
        // Using bit operation to avoid int overflow.
        int ret = 0;
        for (int i = 0; i < arr.length; ++i) {
            ret ^= arr[i];
            ret ^= i;
        }
        return ret;
    }
}
