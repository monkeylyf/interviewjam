"""Palindrome partitioning
leetcode

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
"""


class Solution(object):

    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        dp = self.palindrome_state(s)
        container = []
        self.dfs(0, [], dp, s, container)
        return container

    def dfs(self, idx, acc, dp, s, container):
        """"""
        if idx == len(s):
            container.append(acc[:])
        else:
            for i in xrange(idx, len(s)):
                if dp[idx][i]:
                    acc.append(s[idx:i + 1])
                    self.dfs(i + 1, acc, dp, s, container)
                    acc.pop()

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
    print sol.partition('aab')


if __name__ == '__main__':
    main()
