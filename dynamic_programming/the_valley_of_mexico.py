"""mexico

http://www.ioinformatics.org/locations/ioi06/contest/day2/mexico/mexico.pdf
"""

from pprint import pprint as p
from collections import defaultdict as dd


def main():
    c = int(raw_input())
    n = int(raw_input())

    agrmt = dd(set)
    for _ in xrange(n):
        a, b = map(lambda x: int(x) - 1, raw_input().split())
        agrmt[a].add(b)
        agrmt[b].add(a)

    left_dp  = [[False for _ in xrange(c)] for _ in xrange(c)]
    right_dp = [[False for _ in xrange(c)] for _ in xrange(c)]
    p(agrmt)
    for i in xrange(c):
        for j in xrange(i, c):
            if i == j:
                left_dp[i][j]  = True
                right_dp[i][j] = True
                continue

            left_dp[i][j] = (left_dp[i][j - 1] and j in agrmt[j - 1]) or \
                            (right_dp[j - 1])



if __name__ == '__main__':
    main()
