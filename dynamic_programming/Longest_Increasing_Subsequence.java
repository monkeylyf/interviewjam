/*Longest_Increasing_Subsequence

Example:
0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15

a longest increasing subsequence is
0, 2, 6, 9, 13, 15.

return 6.
*/

import java.util.ArrayList;


class Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        System.out.println(longestSubseq(new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
    public static int longestSubseq(int[] seq) {
        // dp-based
        // Convert the questions to: longest increasing subsequence ends with cur number.
        // Time complexity O(n^2) + O(n)
        // Space sompelxity O(n)
        int[] status = new int[seq.length];
        status[0] = 1;
        print(status);
        for (int i = 1; i < seq.length; ++i) {
            int max = 1;
            for (int j = 0; j < i; ++j) {
                if (seq[i] > seq[j]) {
                    max = Math.max(max, status[j] + 1);
                }
            }
            status[i] = max;
            print(status);
        }
        int res = 0;
        for (int i : status) { // Iterator to find the longest increasing subseq.
            res = Math.max(res, i);
        }
        return res;
    }
    public static int longestSubsequence(int[] seq) {
        // dp-based
        // http://en.wikipedia.org/wiki/Longest_increasing_subsequence
        return 0;
    }
    public static void print(int[] A) {
        for (int i : A) System.out.print(i + " ");
        System.out.println();
    }
}
