"""Factor combinations
leetcode

Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations
of its factors.

Note:
Each combination's factors must be sorted ascending, for example: The factors
of 2 and 6 is [2, 6], not [6, 2].
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Examples:
input: 1
output:
[]
input: 37
output:
[]
input: 12
output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
input: 32
output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
"""


import math


class Solution(object):

    def getFactors(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        container = []
        self.solve(n, 2, [], container)
        return container

    def solve(self, n, factor, acc, container):
        for next_factor in xrange(factor, int(math.sqrt(n)) + 1):
            if n % next_factor == 0:
                factors = acc[:]
                factors.extend([next_factor, n / next_factor])
                container.append(factors)
                acc.append(next_factor)
                self.solve(n / next_factor, next_factor, acc, container)
                acc.pop()


def main():
    sol = Solution()
    print sol.getFactors(12)
    print sol.getFactors(1)
    print sol.getFactors(32)


if __name__ == '__main__':
    main()
