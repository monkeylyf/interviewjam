#
# https://code.google.com/codejam/contest/2418487/dashboard#s=p1
#


import sys

rl = sys.stdin.readline


T = int(rl())


for case in xrange(1, T + 1):
    E, R, _ = map(int, rl().strip().split())
    arr = map(int, rl().strip().split())
    dp = [arr[0] * (E + R - x) if x >= R else 0 for x in range(E + 1)]
    #print dp
    for activity in arr[1:]:
        next = [0 for _ in range(E + 1)]
        for i in range(E + 1):
            localMax = 0
            for j in range(E + 1):
                if j >= R and i >= R and j >= i - R:
                    localMax = max(localMax, dp[j] + (j - i + R) * activity)
            next[i] = localMax
        #print next
        dp = next
    print 'Case #{0}: {1}'.format(case, max(dp))
