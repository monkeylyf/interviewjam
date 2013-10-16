/*Longest_Palindrome_Substring

Given a string s, find the longest palindrome substring in s.
*/


class Longest_Palindrome_Substring {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubstring(""));
        System.out.println(manacher(""));
        System.out.println(longestPalindromeSubstring("a"));
        System.out.println(manacher("a"));
        System.out.println(longestPalindromeSubstring("abbac"));
        System.out.println(manacher("abbac"));
    }
    public static String longestPalindromeSubstring(String s) {
        if (s.length() == 0) {
            return s;
        }
        int n = s.length(), start = 0, end = 0, longest = 1, i, j;
        boolean[][] status = new boolean[n][n];

        for (i = 0; i < n; ++i) {
            status[i][i] = true;
        }
        for (i = n - 2; i >= 0; --i) {
            status[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            for (j = i + 2; j < n; ++j) {
                status[i][j] = (s.charAt(i) == s.charAt(j)) && status[i + 1][j - 1];
                if (status[i][j] && j - i + 1 > longest) {
                    longest = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
    // Manacher algorithm.
    public static String manacher(String A) {
        if (A.length() == 0) {
            return A;
        }
        // Pre-processing: "abba" ==> "^#a#b#b#a#$".
        int n = A.length();
        if (n == 0) {
            return "";
        }
        String T = "^"; // Starting with "^"
        for (int i = 0; i < n; ++i) {
            T += "#" + A.substring(i, i + 1);
        }
        T += "#$"; // Ending with "$". Pre-processing finished.
        n = T.length();
        int longestRadius = 1;
        int longestPivot = 2;
        int[] status = new int[n]; 
        int pivot = 0; // pivot of the longest palindrome substring found so far.
        int rightEdge = 0; // right edge of longest palindrome substring found so far.
        for (int i = 1; i < n - 1; ++i) {
            // pivot = (i + mirror) / 2. Find the symmetry point of i against on pivot.
            int mirror = 2 * pivot - i;
            // 1. rightEdge > i, 
            // why status[i] = Math.min(stats[mirror], rightEdge - i) ?
            // if (rightEdge - i > status[mirror]) status[i] = status[mirror];
            // else /* P[j] >= mx - i */    status[i] = rightEdge - i;
            // 2. rightEdge <= i, the range of current longest palindrome substring outreaches i. Symmetric info can no be reused. set statuc[i] = 0. 
            status[i] = (rightEdge > i) ? Math.min(rightEdge - i, status[mirror]) : 0;
            while (T.charAt(i + 1 + status[i]) == T.charAt(i - 1 - status[i])) {
                // expand if symmetry chars are equal.
                ++status[i];
            }
            if (i + status[i] > rightEdge) { // Updating pivot and rightEdge.
                pivot = i;
                rightEdge = status[i] + i;
            }
            if (status[i] > longestRadius) {
                longestRadius = status[i];
                longestPivot = i;
            }
        }
        return A.substring((longestPivot - longestRadius) / 2 , (longestPivot + longestRadius) / 2);
    }
}
