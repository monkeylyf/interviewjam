#
# https://code.google.com/codejam/contest/2418487/dashboard#s=p0
#

import sys

rl = sys.stdin.readline
T = int(rl())


for case in xrange(1, T + 1):
    r, t = map(int, rl().strip().split())
    lo, hi = 0, t
    while lo + 1 < hi:
        if case == 1:
            print lo, hi
        mid = (lo + hi) / 2
        if (2 * r + 2 * mid - 1) * mid <= t:
            lo = mid
        else:
            hi = mid
    print "Case #{0}: {1}".format(case, lo)
