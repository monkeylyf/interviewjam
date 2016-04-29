"""Regular Expression Matching
leetcode

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") -> false
isMatch("aa","aa") -> true
isMatch("aaa","aa") -> false
isMatch("aa", "a*") -> true
isMatch("aa", ".*") -> true
isMatch("ab", ".*") -> true
isMatch("aab", "c*a*b") -> true
"""


class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        pat_tokens = self.parse_pat(p)
        n = len(pat_tokens)
        m = len(s)

        dp = [False] * (m + 1)
        dp[0] = True

        for i in xrange(1, n + 1):
            token = pat_tokens[i - 1]
            nex = [False] * (m + 1)
            nex[0] = len(token) == 2 and dp[0]
            for j in xrange(1, m + 1):
                char = s[j - 1]
                if len(token) == 2:
                    if token[0] == '.':
                        nex[j] = dp[j - 1] or dp[j] or nex[j - 1]
                    elif token[0] == char:
                        nex[j] = dp[j - 1] or dp[j] or (j >= 2 and s[j - 2] == char and nex[j - 1])
                    else:
                        nex[j] = dp[j]
                else:
                    # len(token) == 1
                    if token == '.' or token == char:
                        nex[j] = dp[j - 1]
                    else:
                        nex[j] = False
            dp = nex

        return dp[-1]

    def parse_pat(self, pat):
        pat_tokens = []
        i = 0
        while i < len(pat):
            if i + 1 < len(pat) and pat[i + 1] == '*':
                pat_tokens.append(pat[i:i + 2])
                i += 2
            else:
                pat_tokens.append(pat[i])
                i += 1
        return pat_tokens


def main():
    sol = Solution()
    assert sol.isMatch("aab", "c*a*b")


if __name__ == '__main__':
    main()
