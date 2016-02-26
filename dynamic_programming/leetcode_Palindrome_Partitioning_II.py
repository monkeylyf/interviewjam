"""Palindrome partitioning II
leetcode

Given a string s, partition s such that every substring of the partition is a
palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using
1 cut.
"""


class Solution(object):

    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp = self.palindrome_state(s)
        cut_dp = [None] * n
        for i in xrange(n):
            if dp[0][i]:
                # Itself is palindrome, needs 0 cut.
                cut_dp[i] = 0
            else:
                cut_dp[i] = i

                for j in xrange(1, i + 1):
                    if dp[j][i]:
                        cut_dp[i] = min(cut_dp[i], cut_dp[j - 1] + 1)
        return cut_dp[-1]

    def palindrome_state(self, s):
        """This is the crux of palindrome related questions.

        Find the palindrome state of given string with O(n^2).
        dp[i][j] indicates that whether substring s[i:j+1] is palindrome.
        Three cases.
        I. single char is always palindrome
        II. two chars are parlindrome if char_a == char_b
        III, More than two chars, s[i] == s[j] and dp[i + 1][j - 1], meaning
             left and right equal and middle part is palindrome
        """
        n = len(s)
        dp = [[False for _ in xrange(n)] for _ in xrange(n)]

        for span in xrange(n):
            for i in xrange(n - span):
                j = i + span
                if i == j:
                    dp[i][j] = True
                elif i + 1 == j:
                    dp[i][j] = s[i] == s[j]
                else:
                    dp[i][j] = s[i] == s[j] and dp[i + 1][j - 1]

        return dp


def main():
    sol = Solution()
    assert sol.minCut('aab') == 1


if __name__ == '__main__':
    main()
