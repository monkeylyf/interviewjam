/*Palindrome_Partitioning

Given a string s, partition s such that every substring of the partition is a
palindrome.
Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
      ["aa","b"],
      ["a","a","b"]
  ]
*/

import java.util.ArrayList;


public class leetcode_Palindrome_Partitioning {

    public static void main(String[] args) {
        Solution test = new Solution("amanaplanacanalpanama");
        System.out.println(test.partition());
    }
}


class Solution {

    private String s;
    private int n;
    private boolean[][] status;

    Solution(String s) {
        this.s = s;
        this.n = s.length();
        this.status = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            this.status[i][i] = true; // Single char is considered palindromic.
        }
        for (int i = n - 2; i >= 0; --i) {
            this.status[i][i + 1] = s.charAt(i) == s.charAt(i + 1); // Check string with length two.
            for (int j = i + 2; j < n; ++j) {
                this.status[i][j] = (s.charAt(i) == s.charAt(j)) && status[i + 1][j - 1];
            }
        }
    }

    public ArrayList<ArrayList<String>> partition() {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> tmp = new ArrayList<String>();
        nextPalindrome(0, res, tmp);
        return res;
    }

    private void nextPalindrome(int index, ArrayList<ArrayList<String>> res, ArrayList<String> tmp) {
        if (index == this.n) {
            ArrayList<String> copy = new ArrayList<String>();
            for (String i : tmp) {
                copy.add(i);
            }
            res.add(copy);
        }
        for (int i = index; i < this.n; ++i) {
            if (this.status[index][i]) {
                tmp.add(this.s.substring(index, i + 1));
                nextPalindrome(i + 1, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        } 
    }
}


/* Python Version
def partition(self, s):
    # Nested function.
    def dfs(idx, conb):
        if idx == len(s):
            ret.append(conb[::1])
        else:
            for i in xrange(idx, len(s)):
                if dp[idx][i]:
                    conb.append(s[idx : i + 1])
                    dfs(i + 1, conb)
                    conb.pop()

    # Cook the dp status of palindrome
    dp = [ [ True if i == j else False for i in xrange(len(s)) ] for j in xrange(len(s)) ]

    for i in reversed(xrange(len(s) - 1)):
        for j in xrange(i + 1, len(s)):
            dp[i][j] = (s[i] == s[j]) and (i + 1 == j or dp[i + 1][j - 1])

    ret = []
    dfs(0, [])

    return ret
*/
