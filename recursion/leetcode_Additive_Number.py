"""Additive number
leetcode

Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the
first two numbers, each subsequent number in the sequence must be the sum of
the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence:
1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is:
1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
"""


class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        def rec(prev, cur, num):
            """Return num is additive number given previous/current number.

            :param prev: str
            :param cur: str
            :param num: str
            """
            # Both prev/cur and be '0' but cannot have leading '0', as stated.
            if (len(prev) > 1 and prev[0] == '0') or (len(cur) > 1 and cur[0] == '0'):
                return False
            next_sum = str(int(prev) + int(cur))
            length = len(next_sum)
            if next_sum == num:
                # Perfect match.
                return True
            elif length >= len(num):
                # Mismatch or no enough char left.
                return False
            elif num[:length] == next_sum:
                # Match and continue to recurse.
                return rec(cur, next_sum, num[length:])
            else:
                # No match.
                return False

        n = len(num)
        for i in xrange(1, n / 2 + 1):
            for j in xrange(1, n / 2 + 1):
                if rec(num[:i], num[i: i + j], num[i + j:]):
                    return True
        return False


def main():
    sol = Solution()
    assert sol.isAdditiveNumber("199100199")
    assert sol.isAdditiveNumber("112358")
    assert sol.isAdditiveNumber("101")

    assert not sol.isAdditiveNumber("112359")
    assert not sol.isAdditiveNumber("212358")
    assert not sol.isAdditiveNumber("1023")


if __name__ == '__main__':
    main()
