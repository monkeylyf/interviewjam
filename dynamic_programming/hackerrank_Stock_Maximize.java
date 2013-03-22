/*Stack_Maximize
hackerrank

Your algorithms have become so good at predicting the market that you now know
what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the
next N days.

Each day, you can either buy one share of WOT, or sell any number of shares of
WOT that you own. What is the maximum profit you can obtain with an optimum
trading strategy?

Constraints

1 <= T <= 10
1 <= N <= 50000

All share prices are between 1 and 100000

Sample Input

3
3
5 3 2
3
1 2 100
4
1 3 1 2
Sample Output

0
197
3
Explanation

For the first case, you cannot obtain any profit because the share price never
rises. For the second case, you can buy one share on the first two days, and
sell both of them on the third day.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int j = 0;j < n; ++j) {
                arr[j] = sc.nextInt();
            }
            max(arr);
        }
    }
    public static void max(int[] arr) {
        int n = arr.length, localMax = arr[n - 1];
        long sum = 0;
        int i;
        for (i = n - 2; i >= 0; --i) {
            if (arr[i] < localMax) {
                sum += localMax - arr[i];
            } else {
                localMax = arr[i];
            }
        }
        System.out.println(sum);
    }
}
