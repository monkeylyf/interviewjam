"""Distinct subsequences
leetcode

Given a string S and a string T, count the number of distinct subsequences of
T in S.

A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters. (ie, "ACE" is a subsequence of
"ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
"""


class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        if len(s) < len(t):
            return 0
        n = len(s)
        dp = [1] * (n + 1)
        for i, c in enumerate(t):
            nx_dp = [0] * (n + 1)
            for j, ss in enumerate(s):
                if c == ss:
                    nx_dp[j + 1] = nx_dp[j] + dp[j]
                else:
                    nx_dp[j + 1] = nx_dp[j]
            dp = nx_dp
        return nx_dp[-1]


def main():
    sol = Solution()
    s = 'rabbbit'
    t = 'rabbit'

    assert sol.numDistinct(s, t) == 3
    assert sol.numDistinct('ccc', 'c') == 3



if __name__ == '__main__':
    main()
