"""Paint fence.

There is a fence with n posts, each post can be painted with one of the k
colors.

You have to paint all the posts such that no more than two adjacent fence posts
have the same color.

Return the total number of ways you can paint the fence.
"""


class Solution(object):
    def numWays(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        if n == 0:
            return 0
        same = 0
        not_same = k
        for _ in xrange(1, n):
            same, not_same = not_same, (same + not_same) * (k - 1)
        return same + not_same


def main():
    sol = Solution()
    assert sol.numWays(3, 2) == 6
    assert sol.numWays(1, 2) == 2
    assert sol.numWays(2, 2) == 4


if __name__ == '__main__':
    main()
