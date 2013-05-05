# https://code.google.com/codejam/contest/2434486/dashboard

import sys


rl = sys.stdin.readline



T = int(rl())


def solve(A, N, arr, t):
    if A == 1:
        print 'Case #{0}: {1}'.format(t, len(arr))
        return

    arr = sorted(arr)
    rm_remain = N # remove all remaining.
    all_add = 0 # add necessary to eat all.
    for i in range(N):
        # if A can eat next, eat and grow.
        if A <= arr[i]:
            #:param op: int, the number of add ops needed to be capable of eating next.
            op = 0
            while (A <= arr[i]):
                A = 2 * A - 1
                op += 1
            # all_add + N - i: remove all remaining motes.
            rm_remain = min(all_add + N - i, rm_remain)
            all_add += op
        A = A + arr[i]
    print 'Case #{0}: {1}'.format(t, min(rm_remain, all_add))


for t in range(1, T + 1):
    # read input
    A, N = map(int, rl().split())
    arr = map(int, rl().split())
    solve(A, N, arr, t)
