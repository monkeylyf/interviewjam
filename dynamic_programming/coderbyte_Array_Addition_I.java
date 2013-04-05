/*Array_Addition_I
coderbyte

Have the function ArrayAdditionI(arr) take the array of numbers stored in arr
and return the string true if any combination of numbers in the array can be
added up to equal the largest number in the array, otherwise return the string
false. For example: if arr contains [4, 6, 23, 10, 1, 3] the output should
return true because 4 + 6 + 10 + 3 = 23. The array will not be empty, will not
contain all the same elements, and may contain negative numbers. 
*/

import java.util.*;

public class Array_Addition {
    public static void main(String[] args) {
        testSuite();
    }

    public static void testSuite() {
        System.out.println(solve(new int[] { 5, 7, 16, 1, 2 }) == false);
        System.out.println(solve(new int[] { 1, 22, 23, 24, 27, 29, 33 }) == false);
        System.out.println(solve(new int[] { 1, 22, 23, 25, 26 }) == true);
        System.out.println(solve(new int[] { 3, 5, -1, 8, 1, -2, 12 }) == true);
        System.out.println(solve(new int[] { 0 }) == true);
        System.out.println(solve(new int[] { 0, 25 }) == true);
        System.out.println(solve(new int[] { 5, 4, 3, 1, 2 }) == true);
        System.out.println(solve(new int[] { 3, 5, -1, 8, 12 }) == true);
        System.out.println(solve(new int[] {1,2,3,100}) == false);
        System.out.println(solve(new int[] {10,12,500,1,-5,1,0}) == true);
    }

    public static boolean solve(int[] arr) {
        int min = 0;
        for (int i : arr) {
            if (i == 0) {
                return true;
            }
            min = Math.min(min, i);
        }
        Arrays.sort(arr);
        int n = arr.length - 1, i, j;
        if (min < 0) {
            for (i = 0; i < arr.length; ++i) {
                arr[i] -= min;
            }
        }

        int k = arr[n], cur;
        boolean[][] dp = new boolean[n + 1][k + 1];
        // Init state
        for (i = 0; i <= n; ++i) {
            dp[i][0] = true;
        }
        for (i = 1; i <= n; ++i) {
            cur = arr[i - 1];
            for (j = 1; j <= k; ++j) {
                if (cur > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - cur];
                }
            }
        }
        printMatrix(dp);
        return dp[n][k];
    }

    // Helper function.
    public static void printArray(boolean[] arr) {
        for (boolean i : arr) {
            if (i) {
                System.out.print("T ");
            } else {
                System.out.print("F ");
            }
        }
        System.out.println();
    }

    public static void printMatrix(boolean[][] m) {
        for (boolean[] i : m) {
            printArray(i);
        }
        System.out.println();
    }

}
