"""Ugly number II
leetcode

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
"""

from collections import deque


class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        primes = (2, 3, 5)
        ugly_num = 1
        queues = {prime: deque([prime]) for prime in primes}

        while n > 1:
            ugly_num, prime = min((v[0], k) for k, v in queues.iteritems())
            queues[prime].popleft()

            for i in primes:
                if i >= prime:
                    queues[i].append(ugly_num * i)
            n -= 1

        return ugly_num


def main():
    sol = Solution()
    assert sol.nthUglyNumber(1) == 1
    assert sol.nthUglyNumber(2) == 2
    assert sol.nthUglyNumber(3) == 3
    assert sol.nthUglyNumber(4) == 4
    assert sol.nthUglyNumber(5) == 5
    assert sol.nthUglyNumber(6) == 6
    assert sol.nthUglyNumber(7) == 8


if __name__ == '__main__':
    main()
