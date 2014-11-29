"""hackerrank_AntiPalindromic_Strings.py

https://www.hackerrank.com/contests/101hack19/challenges/antipalindromic-strings
"""


def main():
    """if n == 1, then there is m antipalindromic string.

    if n == 2, then there is m * (m - 1) antipalindromic string
    if n >= 3, then there is m * (m - 1) * (m - 1)...
    Then all you need to do is to implement pow with mod and multi with mod.
    """
    t = int(raw_input())
    for _ in xrange(t):
        n, m = map(int, raw_input().split())
        if n == 1:
            print m
        elif n == 2:
            print multi_mod(m, m - 1)
        else:
            print multi_mod(multi_mod(m, m - 1), pow_mod(m - 2, n - 2))


def multi_mod(a, b, mod=10**9+7):
    return ((a % mod) * (b % mod)) % mod


def pow_mod(a, n, mod=10**9+7):
    if n == 0:
        return 1

    base = a

    ret = 1
    while n:
        if n % 2 == 1:
            ret = (ret *base) % mod

        base = (base * base) % mod
        n /= 2

    return ret


if __name__ == '__main__':
    main()
