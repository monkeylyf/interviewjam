"""Reverse bits
leetcode

Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as
00000010100101000001111010011100), return 964176192 (represented in binary as
00111001011110000010100101000000).
"""


class Solution(object):
    def reverseBits(self, n):
        """
        :type n: int
        :rtype: int
        """
        bits = []
        while n > 0 or len(bits) < 32:
            bits.append(n % 2)
            n /= 2

        reversed_bits = 0
        base = 1
        for bit in reversed(bits):
            reversed_bits += base * bit
            base *= 2
        return reversed_bits


def main():
    sol = Solution()
    assert sol.reverseBits(43261596) == 964176192


if __name__ == '__main__':
    main()
