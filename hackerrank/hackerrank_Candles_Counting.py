"""hackerrank_Candles_Counting.py

https://www.hackerrank.com/contests/101hack18/challenges/candles-2
"""


def add_mod(arr, i, value, mod=10**9+7):
    while i < len(arr):
        arr[i] = (arr[i] + value) % mod
        i |= i + 1 # 2 ** i - 1


def sum_mod(arr, i, mod=10**9+7):
    s = 0

    while i >= 0:
        s = (s + arr[i]) % mod
        i = (i & (i + 1)) - 1

    return s


def main():
    """DP.


    """
    (n, k) = map(int, raw_input().split())

    max_height = 50001
    max_color_mask = 1 << k

    dp = [[0] * max_height for _ in xrange(max_color_mask)]

    # init.
    add_mod(dp[0], 0, 1)
    return
    from pprint import pprint as p
    print(dp[0])

    for i in xrange(n):
        h, c = map(int, raw_input().split())
        c -= 1

        for j in xrange(max_color_mask):
            value = sum_mod(dp[j], h - 1)
            add_mod(dp[j | (1 << c)], h, value )

    res = sum_mod(dp[(1 << k) - 1], max_height - 1)
    print res


if __name__ == '__main__':
    main()
