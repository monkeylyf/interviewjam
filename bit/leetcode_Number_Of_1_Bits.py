"""Number of 1 bits
leetcode

Write a function that takes an unsigned integer and returns the number of '1'
bits it has (also known as the Hamming weight).
https://en.wikipedia.org/wiki/Hamming_weight

For example, the 32-bit integer '11' has binary representation
00000000000000000000000000001011, so the function should return 3.
"""


class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        # Cheating ;)
        #return bin(n).count('1')
        count = 0
        while n > 0:
            count += n % 2
            n /= 2
        return count


def main():
    sol = Solution()
    print sol.hammingWeight(11)


if __name__ == '__main__':
    main()
