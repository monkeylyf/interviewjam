#hackerrank_Sherlock_and_Squares
#
#https://www.hackerrank.com/contests/mar14/challenges/sherlock-and-squares

from math import sqrt, floor, ceil


def solve():
    square = sqrt
    fl = floor
    ce = ceil
    T = int(raw_input())
    for _ in xrange(T):
        (a, b) = map(int, raw_input().split())
        print int(fl(square(b)) - ce(square(a)) + 1)
        
        
if __name__ == '__main__':
    solve()
