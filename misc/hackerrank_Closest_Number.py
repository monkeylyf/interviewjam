"""hackerrank_Closest_Number

1 <= T <= 10**5 
1 <= x <= 10**9 
0 < a**b <= 10**9 
1 <= a <= 10**9 
-10**9 <= b <= 10**9

https://www.hackerrank.com/contests/w5/challenges/closest-number
"""

from math import ceil


def solve(a, b, x):
    p = pow(a, b)
    r = int(ceil(2 * p)) / 2
    mod = r % x

    if mod > x / 2.0:
        print r + x - mod
    else:
        print r - mod


def main():
    T = int(raw_input())
    for _ in xrange(T):
        (a, b, x) = map(int, raw_input().split())
        solve(a, b, x)


if __name__ == '__main__':
    main()
