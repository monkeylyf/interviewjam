# https://code.google.com/codejam/contest/2437488/dashboard#s=p0

import sys


rl = sys.stdin.readline



T = int(rl())

def solve(name, n, t):
    res = 0
    acc = 0 # Accumulator for consecutive consonants.
    last = -1
    for i in xrange(len(name)):
        char = name[i]
        acc = 0 if char == 'a' or char == 'e' or char == 'i' or char == 'o' or \
            char == 'u' else acc + 1
        if (acc >= n):
            # update index of first char in last seen n-consecutive consonants.
            last = i - n + 1 
        res = res + last + 1
        #print 'char: {0} acc: {1} last: {2} res: {3}'.format(char, acc, last, res)
    print 'Case #{0}: {1}'.format(t, res)
    

for t in range(1, T + 1):
    # read input
    ln = rl().split()
    name = str(ln[0])
    n = int(ln[1])
    solve(name, n, t)
