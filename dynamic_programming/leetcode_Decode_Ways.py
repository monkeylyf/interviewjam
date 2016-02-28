"""Decode ways
leetcode

A message containing letters from A-Z is being encoded to numbers using the
following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways
to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
"""


class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s or s[0] == '0':
            return 0

        prev = cur = 1
        for i in xrange(1, len(s)):
            take_two = s[i - 1] != '0' and int(s[i - 1:i + 1]) <= 26
            take_one = s[i] != '0'

            if take_two and take_one:
                prev, cur = cur, prev + cur
            elif take_two:
                prev, cur = cur, prev
            elif take_one:
                prev, cur = cur, cur
            else:
                return 0
        return cur


def main():
    sol = Solution()
    assert sol.numDecodings('12') == 2


if __name__ == '__main__':
    main()
