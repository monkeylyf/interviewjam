"""Paint House
leetcode

There are a row of n houses, each house can be painted with one of the three
colors: red, blue or green. The cost of painting each house with a certain color
is different. You have to paint all the houses such that no two adjacent houses
have the same color.

The cost of painting each house with a certain color is represented by a n x 3
cost matrix. For example, costs[0][0] is the cost of painting house 0 with color
red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.
"""


class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        if not costs:
            return 0
        for i, cost in enumerate(costs):
            if i == 0:
                dp = costs[i]
            else:
                dp = [
                    cost[0] + min(dp[1], dp[2]),
                    cost[1] + min(dp[0], dp[2]),
                    cost[2] + min(dp[0], dp[1])
                ]
        return min(dp)


def main():
    sol = Solution()
    costs = [
        [1, 2, 4],
        [2, 3, 3],
        [1, 1, 5],
        [3, 3, 1],
        [4, 1, 3]
    ]
    assert sol.minCost(costs) == 7


if __name__ == '__main__':
    main()
