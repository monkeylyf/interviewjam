"""One edit distance
leetcode

Given two strings S and T, determine if they are both one edit distance apart.
"""


class Solution(object):

    def isOneEditDistance(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if abs(len(s) - len(t)) >= 2:
            return False
        elif len(s) == len(t):
            # Must be one char diff and do swap.
            seen_diff = False
            for i in xrange(len(s)):
                if s[i] != t[i]:
                    if seen_diff:
                        return False
                    else:
                        seen_diff = True
            return seen_diff
        else:
            # Must be insert/delete
            if len(s) > len(t):
                s, t = t, s
            i = 0
            for i in xrange(len(s)):
                if s[i] != t[i]:
                    return s[i:] == t[i + 1:]

            return True


def main():
    sol = Solution()
    assert sol.isOneEditDistance('ab', 'abc')


if __name__ == '__main__':
    main()
