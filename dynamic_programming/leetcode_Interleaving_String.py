"""Interleaving string
leetcode

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
"""

class Solution(object):
    def isInterleave(self, s1, s2, s3):
        """dp[i][j] indicates whether s1[:i] and s2[:j] can interleave and
        form s3

        :type s1: str
        :type s2: str
        :type s3: str
        :rtype: bool
        """
        s1l = len(s1)
        s2l = len(s2)
        s3l = len(s3)
        # Edge cases
        if s1l + s2l != s3l:
            return False
        if (s1l == 0 and s2 == s3) or (s2l == 0 and s1 == s3):
            return True

        # Init dp state: empty string '' and s1 can form s3
        dp = [False] * (s1l + 1)
        dp[0] = True
        for i, char in enumerate(s1):
            if char == s3[i]:
                dp[i + 1] = True
            else:
                break

        for i, s2c in enumerate(s2):
            # s2[:i] and '' can form s3
            nx = [False] * (s1l + 1)
            nx[0] = dp[0] and s2c == s3[i]
            for j, s1c in enumerate(s1):
                if s2c == s3[i + j + 1]:
                    nx[j + 1] = dp[j + 1]
                if not nx[j + 1] and s1c == s3[i + j + 1]:
                    nx[j + 1] = nx[j]
            dp = nx
        return dp[-1]


def main():
    sol = Solution()
    s1 = 'aabcc'
    s2 = 'dbbca'
    s3 = 'aadbbcbcac'

    assert sol.isInterleave(s1, s2, s3)
    s3 = 'aadbbbaccc'
    assert not sol.isInterleave(s1, s2, s3)
