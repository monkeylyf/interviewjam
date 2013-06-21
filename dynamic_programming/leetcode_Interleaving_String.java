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

    /* DP based.
	s3 start with either s1[0] or s2[0]. Otherwise return false.

	if s3 start with s1[0], subproblem: s1[1:], s2, s[1:]
	if s3 start with s2[0], subproblem: s, s2[1:], s[1:]
	(if s1[0] == s2[0], take or operation)

	if s1[:i-1] and s2[:j-1] is interleaving word, then dp[i][j] == true else false.
	*/

    public static void main(String[] args) {
		//  isInterleave("XXY", "XXZ", "XXZXXXY");
    	//	isInterleave("XY" ,"WZ" ,"WZXY");
    	//	isInterleave ("XY", "X", "XXY");
    	//	isInterleave ("YX", "X", "XXY");
    	//	isInterleave ("XXY", "XXZ", "XXXXZY");
    	//  isInterleave("a", "b", "ab");
		isInterleave("aabcc", "dbbca", "aadbbcbcac");
		//	isInterleave("aabcc", "dbbca", "aadbbbaccc");
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
		// Time complexity O(mn). Space Complexity O(m)
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
		int i, j;
		// Init dp. Empty string state is considered.
        boolean[] prev = new boolean[s2.length() + 1], next;
        prev[0] = true;
        for (i = 0; i < s2.length(); ++i) { // "" and s2 are interleaving.
            if (s2.charAt(i) == s3.charAt(i)) {
                prev[i + 1] = prev[i];
            }
        }
		print(prev);
		// DP. checking if s1[:i] and s2[:j] is interleaving with s3[:i+j]
        for (i = 0; i < s1.length(); ++i) {
            next = new boolean[s2.length() + 1];
            next[0] = s1.substring(0, i + 1).equals(s3.substring(0, i + 1));
            for (j = 0; j < s2.length(); ++j) {
				// if s2[j] == s3[i+j+1], then dp[i][j] = dp[i][j-1]
				// check if s2[:j-1] and s1[:i] is interleaving
                if (s2.charAt(j) == s3.charAt(i + j + 1)) {
                    next[j + 1] = next[j];
                }
				// if s1[i] == s3[i+j+1], then dp[i][j] = dp[i-1][j]
				// check if s1[:i-1] and s2[:j] is interleaving
                if (s1.charAt(i) == s3.charAt(i + j + 1)) {
                    next[j + 1] = next[j + 1] || prev[j + 1];
                }
            }
            prev = next;
			print(prev);
        }
        return prev[s2.length()];
    }

	public static void print(boolean[] arr) {
		for (boolean i : arr) System.out.print((i) ? 'T' : 'F');
		System.out.println();
	}

    // Way too slow. Random walk.
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

	// A recursive way to solve the problem. Way too slow.
	// Worst case time complexity O(2 ** n) because it repeats computing some
	// same subproblem.
    public boolean util(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        } else if (s1.equals("")) {
            return s2.equals(s3);
        } else if (s2.equals("")) {
            return s1.equals(s3);
        } else if (s1.charAt(0) != s3.charAt(0) && s2.charAt(0) != s3.charAt(0)) {
            return false;
        } else if (s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            return util(s1.substring(1), s2, s3.substring(1)) || util(s1, s2.substring(1), s3.substring(1));
        } else if (s1.charAt(0) == s3.charAt(0)) {
            return util(s1.substring(1), s2, s3.substring(1));
        } else {
            return util(s1, s2.substring(1), s3.substring(1));
        }
    }
}
