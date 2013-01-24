/*Interleaving_String

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
For example,
Given:
s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

import java.util.Stack;


class leetcode_Interleaving_String {
    public static void main(String[] args) {
        isInterleave("a", "b", "ab");
    }
    // DP based.
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[] prev = new boolean[s2.length() + 1];
        prev[0] = true;
        for (int i = 0; i < s2.length(); ++i) {
            if (s2.charAt(i) == s3.charAt(i)) {
                prev[i + 1] = prev[i];
            }
        }
        for (int i = 0; i < s1.length(); ++i) {
            boolean[] next = new boolean[s2.length() + 1];
            next[0] = s1.substring(0, i + 1).equals(s3.substring(0, i + 1));
            for (int j = 0; j < s2.length(); ++j) {
                if (s2.charAt(j) == s3.charAt(i + j + 1)) {
                    next[j + 1] = next[j];
                }
                if (s1.charAt(i) == s3.charAt(i + j + 1)) {
                    next[j + 1] = next[j + 1] || prev[j + 1];
                }
            }
            prev = next;
            next = new boolean[s2.length() + 1];
        }
        return prev[prev.length - 1];
    }
    // Way too slow.
    public static boolean is(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        } else if (s2.length() == 0) {
            return s1.equals(s3);
        } else if (s1.length() == 0) {
            return s2.equals(s3);
        }
        Stack<int[]> grid = new Stack<int[]>();
        if (s1.charAt(0) == s3.charAt(0)) {
            grid.push(new int[] {1, 0});
        }
        if (s2.charAt(0) == s3.charAt(0)) {
            grid.push(new int[] {0, 1});
        }
        for (int i = 1; i < s3.length(); ++i) {
            if (grid.size() == 0) {
                return false;
            }
            Stack<int[]> next = new Stack<int[]>();
            while(grid.size() != 0) {
                int[] pos = grid.pop();
                if (pos[0] < s1.length() && s1.charAt(pos[0]) == s3.charAt(i)) {
                    next.push(new int[] {pos[0] + 1, pos[1]});
                }
                if (pos[1] < s2.length() && s2.charAt(pos[1]) == s3.charAt(i)) {
                    next.push(new int[] {pos[0], pos[1] + 1});
                }
            }
            grid = next;
            next = new Stack<int[]>();
        }
        return true;
    }
}
