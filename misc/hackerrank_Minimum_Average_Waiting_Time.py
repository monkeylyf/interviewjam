""" hackerrank_Minimum_Average_Waiting_Time

https://www.hackerrank.com/contests/w6/challenges/minimum-average-waiting-time
"""

from heapq import (heappop, heappush)


class Solution(object):

    def __init__(self, costomers):
        self.costomers = costomers
        self.due = None
        self.wait = 0
        self.heap = []

    def solve(self):
        """"""
        while self.costomers:
            if not self.heap or self.costomers[-1][0] < self.due:
                (T, L) = self.costomers.pop()
                # If None then first costomer
                self.due = T if not self.due else self.due
                heappush(self.heap, (L, T)) # __comp__ with L.
            else:
                # Serve costomer whose pizza takes least time.
                self.serve() 

        # Serve waiting costomers.
        while self.heap:
            self.serve() 

        return self.wait

    def serve(self):
        """"""
        (L, T) = heappop(self.heap)
        self.due += L
        self.wait += self.due - T


def main():
    N = int(raw_input())
    costomers = [ map(int, raw_input().split()) for _ in xrange(N) ]
    print Solution(sorted(costomers, reverse=True)).solve() / N


if __name__ == '__main__':
    main()
