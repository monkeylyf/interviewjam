"""hackerrank_Sherlock_and_Square.py

https://www.hackerrank.com/contests/w11/challenges/sherlock-and-square
"""


def two_pow(n, cache, mod=1000000007):
    """Pow operation with base 2 and mod 10^9+7.

    WTF, too slow?
    """
    res = 1
    base = 2
    while n:
        if cache.has_key(n):
            res = (cache[n] * res) % mod
            break
        if n % 2:
            res = (base * res) % mod
        base *= base
        n /= 2

    # Cache.
    cache[n] = res
    return res


def main():
    """Recurrence relation:

    an = 4                  if n == 4
         4 + 2^(n + 1) - 2  else
    """
    cache = {}

    for i in xrange(int(raw_input())):
        n = int(raw_input())
        #print 4 if n == 0 else 4 + two_pow(n + 1, cache) - 2
        print 4 if n == 0 else 4 + pow(2, n + 1, 1000000007) - 2


if __name__ == '__main__':
    main()
