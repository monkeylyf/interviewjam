"""hackerrank_Lucy_And_Flowers.py

https://www.hackerrank.com/contests/w4/challenges/lucy-and-flowers
"""

def solve():
    """dp[i] is the number of all possible unique bst (subset) including empty set.
    
    What means empty set counts as 1.
    
    Initial state of dp is dp[0] = 1 and dp[1] = 2.
    For all i, which i >= 2, find a pivot j in [0, i) and accumulate dp[i] * dp[i - 1 - j]
    """
    mod = 10 ** 9 + 9
    max_n = 5000

    dp = [ 1 ] * (max_n + 1)
    dp[1] = 2

    for i in xrange(2, max_n + 1):
        for j in xrange(i):
            dp[i] += dp[j] * dp[i - 1 - j]
            dp[i] %= mod

    return dp


def pascal(n):
    """Better way to generate combination #."""
    mod = 10 ** 9 + 9
    n += 1
    cache = [ [ 0 for _ in xrange(n) ] for _ in xrange(n) ]

    for i in xrange(n):
        Cnk = 1
        for k in xrange(n):
            cache[i][k] = Cnk
            Cnk = ((Cnk * (i - k)) % mod) / (k + 1)

    return cache

def combination(a, b):
    """ C(a, b). i.e, C(4, 2) = 4 * 3 / (1 * 2)
    
    Too fucking slow. Repetitive computation.
    """
    b = min(b, a - b)
    numerator = 1
    denominator = 1

    c = 1
    for i in xrange(b):
        numerator *= a
        a -= 1
        denominator *= c
        c += 1

    return numerator / denominator


def precompute(n):
    """ETL.

    But you can precomputer the status less than 5000 offline and upload the data.
    I love cheating.
    """
    mod = 10 ** 9 + 9

    dp = [ 0 ] * (n + 1)
    ar = [ 0 ] * (n + 1)

    combination_cache = pascal(n)
    
    dp[1] = 1
    dp[2] = 2

    for i in xrange(3, n + 1):
        dp[i] = 2 * dp[i - 1] % mod
        for j in xrange(1, i - 1):
            dp[i] += (dp[j] * dp[i - 1 - j]) % mod

    for i in xrange(1, n + 1):
        for j in xrange(1, i + 1):
            
            ar[i] = (ar[i] + dp[j] * combination_cache[i][j]) % mod

    return ar


def main():
    T = int(raw_input())
    dp = solve()

    for _ in xrange(T):
        # exclude empty set count.
        print dp[int(raw_input())] - 1


if __name__ == '__main__':
    main()
