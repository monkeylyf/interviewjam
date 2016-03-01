"""Shortest Palindrome
leetcode

Given a string S, you are allowed to convert it to a palindrome by adding
characters in front of it. Find and return the shortest palindrome you can find
by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
"""


class Solution(object):
    def shortestPalindromeDP(self, s):
        """TLE...

        :type s: str
        :rtype: str
        """
        n = len(s)
        dp = [[None for _ in xrange(n)] for _ in xrange(n)]
        for span in xrange(n):
            for i in xrange(n - span):
                j = i + span
                if j == i:
                    dp[i][j] = True
                elif i + 1 == j:
                    dp[i][j] = s[i] == s[j]
                else:
                    dp[i][j] = s[i] == s[j] and dp[i + 1][j - 1]
        i = n - 1
        while i >= 0 and not dp[0][i]:
            i -= 1
        prefix = ''.join(reversed(s[i + 1:]))
        return prefix + s

    def shortestPalindrome(self, s):
        """Find the longest overlap between s and its reverse.

        :type s: str
        :rtype: str
        """
        reversed_s = ''.join(reversed(s))
        n = len(s)
        offset = 0
        while offset < n:
            if s[:n - offset] == reversed_s[offset:]:
                break
            else:
                offset += 1
        return reversed_s[:offset] + s

    def shortestPalindromeTwoPointer(self, s):
        """TLE as well.

        :type s: str
        :rtype: str
        """
        n = len(s)
        i = 0
        j = n - 1
        end = n - 1
        while i < j:
            if s[i] == s[j]:
                i += 1
                j -= 1
            else:
                i = 0
                end -= 1
                j = end
        return ''.join(reversed(s[end + 1:])) + s


def main():
    sol = Solution()
    assert sol.shortestPalindrome('aacecaaa') == 'aaacecaaa'
    assert sol.shortestPalindrome('abcd') == 'dcbabcd'


if __name__ == '__main__':
    main()
