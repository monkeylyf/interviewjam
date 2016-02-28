"""Combinations
leetcode

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
"""


class Solution(object):
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        container = []
        self.solve(1, n, k, [], container)
        return container

    def solve(self, i, n, k, acc, container):
        if len(acc) == k:
            container.append(acc[:])
        elif i > n:
            return
        else:
            acc.append(i)
            self.solve(i + 1, n, k, acc, container)
            acc.pop()
            self.solve(i + 1, n, k, acc, container)


def main():
    sol = Solution()
    assert sol.combine(4, 2) == [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]


if __name__ == '__main__':
    main()
