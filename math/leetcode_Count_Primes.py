"""Count primes
leetcode

Count the number of prime numbers less than a non-negative number, n.
"""

class Solution(object):
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 3:
            return 0

        primes = [False] * n

        # Skip all even numbers.
        count = n / 2
        i = 3
        while i * i < n:
            if not primes[i]:
                j = i * i
                while j < n:
                    if not primes[j]:
                        count -= 1
                        primes[j] = True
                    j += 2 * i # Skip +i because it makes j even number.
            i += 2

        return count

    def allPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 3:
            return 0
        if n == 3:
            return 1

        primes = [2]

        for i in xrange(3, n, 2):
            upper_bound = int(i ** 0.5)

            is_prime = True
            for prime in primes:
                if prime > upper_bound:
                    break
                if i % prime == 0:
                    is_prime = False
                    break
            if is_prime:
                primes.append(i)

        return primes


def main():
    sol = Solution()
    assert sol.countPrimes(2) == 0
    assert sol.countPrimes(3) == 1
    assert sol.countPrimes(4) == 2
    assert sol.countPrimes(5) == 2
    assert sol.countPrimes(100) == 25
    assert sol.countPrimes(999983) == 78497


if __name__ == '__main__':
    main()
