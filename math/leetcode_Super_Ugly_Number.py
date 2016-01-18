"""Super Ugly Number.
leetcode

Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given
prime list primes of size k. For example,
[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28,32] is the sequence of the first 12 super
ugly numbers given primes = [2, 7, 13, 19] of size 4.
"""

from collections import deque

class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """Return nth super ugly number.

        Ugly numbers [u1(is 1), u2, u3, ...un] and given primes [p1, p2, .. pm]
        to construct a queue for each prime:

        p1: p1, p1 * u2, p1 * u3, ... p1 * un
        p2: p2, p2 * u2, p2 * u3, ... p2 * un
        ...
        pm: pm, pm * u2, pm * u3, ... pm * un

        If these m queues are interleaving each other properly, you can have another
        ungly numbers sequence. To reverse engineer it, we can construct these
        queues to find the ugly number sequence.

        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        num = 1
        queues = {prime: deque([prime]) for prime in primes}
        for i in xrange(n - 1):
            tops = [(value[0], key) for key, value in queues.iteritems()]
            num, prime_idx = min(tops)
            queues[prime_idx].popleft()

            for prime in primes:
                if prime >= prime_idx: queues[prime].append(num * prime)
        return num


def main():
    sol = Solution()
    assert sol.nthSuperUglyNumber(12, [2, 7, 13, 19]) == 32


if __name__ == '__main__':
    main()
