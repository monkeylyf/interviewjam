"""Two Arrays Arrangement
hackerrank
Is there an arrangement of the arrays such that Ai+Bi>=K for all i where Ai
denotes the ith element in the array A.

You are free to permute the order of the elements in the arrays.

https://www.hackerrank.com/contests/101aug13/challenges/two-arrays
"""

import sys


rl = sys.stdin.readline

def solve(N, K, A, B):
    A = sorted(A, reverse=True)
    B = sorted(B)
    for idx in xrange(N):
        if A[idx] + B[idx] < K:
            print 'NO'
    print 'YES'


T = int(rl())
for _ in xrange(T):
    (N, K, ) = map(int, rl().strip().split())
    A = map(int, rl().strip().split())
    B = map(int, rl().strip().split())
    if sum(A) + sum(B) < N * K:
        print 'NO'
    else:
        solve(N, K, A, B)
