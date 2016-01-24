"""Bitwise and of numbers range
leetcode

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of
all numbers in this range, inclusive.
For example, given the range [5, 7], you should return 4.
"""

class Solution(object):
    def rangeBitwiseAnd(self, m, n):
        """Convert both numbers to binary form and find the different bit.

        On the right side of this bit(including this bit) will all become 0
        during the sequentical bitwise AND operations. So the result will be
        those on the left side(exclusive).

        :type m: int
        :type n: int
        :rtype: int
        """
        def to_binary(n):
            bits = []
            while n > 0:
                bits.append(n % 2)
                n /= 2
            return bits

        m_bin = to_binary(m)
        n_bin = to_binary(n)

        res = 0
        if len(m_bin) == len(n_bin):
            base = 2 ** (len(m_bin) - 1)
            for i in reversed(xrange(len(n_bin))):
                if m_bin[i] == n_bin[i]:
                    res += m_bin[i] * base
                else:
                    return res
                base /= 2
        return res


def main():
    sol = Solution()
    assert sol.rangeBitwiseAnd(2, 2) == 2
    assert sol.rangeBitwiseAnd(5, 7) == 4
    assert sol.rangeBitwiseAnd(0, 2147483647) == 0


if __name__ == '__main__':
    main()
