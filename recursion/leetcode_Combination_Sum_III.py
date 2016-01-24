"""Combination sum III
leetcode

Find all possible combinations of k numbers that add up to a number n, given
that only numbers from 1 to 9 can be used and each combination should be a
unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
"""


class Solution(object):

    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        def dfs(i, k, acc, container, n):
            """"""
            if k < 0 or (k == 0 and n != 0):
                # More than k numbers selected or exactly  k selected but
                # doesn't add up
                return
            elif k == 0 and n == 0:
                container.append(acc[:])
            else:
                for j in xrange(i, 9 + 1):
                    if j <= n:
                        acc.append(j)
                        dfs(j + 1, k - 1, acc, container, n - j)
                        acc.pop()

        container = []
        dfs(1, k, [], container, n)
        return container


def main():
    sol = Solution()
    assert sol.combinationSum3(3, 9) == [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
    assert sol.combinationSum3(3, 7) == [[1, 2, 4]]


if __name__ == '__main__':
    main()
