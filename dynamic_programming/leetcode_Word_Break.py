"""Word break
leetcode

Given a string s and a dictionary of words dict, determine if s can be
segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
"""


class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        if s in wordDict:
            return True
        n = len(s)
        dp = [False for _ in xrange(n)]

        for i in xrange(n):
            if s[:i + 1] in wordDict:
                dp[i] = True
            else:
                for j in xrange(i):
                    if s[j + 1:i + 1] in wordDict and dp[j]:
                        dp[i] = True
                        break
        return dp[-1]


def main():
    sol = Solution()
    s = "leetcode"
    d = {"leet", "code"}
    assert sol.wordBreak(s, d)


if __name__ == '__main__':
    main()
