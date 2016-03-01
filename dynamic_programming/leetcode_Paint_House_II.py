"""Paint House II
leetcode

There are a row of n houses, each house can be painted with one of the k
colors. The cost of painting each house with a certain color is different.
You have to paint all the houses such that no two adjacent houses have the
same color.

The cost of painting each house with a certain color is represented by a n x k
cost matrix. For example, costs[0][0] is the cost of painting house 0 with
color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Follow up:
Could you solve it in O(nk) runtime?
"""


class Solution(object):

    def minCostII(self, costs):
        """Time complexity O(kn), space complexity O(1).

        Use the given matrix to store the dp states, which requires in-place
        modification. Personally I don't like it but it does save some place.

        The algorithm is based on greedy. Always paint in lowest cost unless
        the previos color is same as current one, which you should use second
        lowest cost. Find the lowest and second lowest cost in previous state
        and update current state.

        :type costs: List[List[int]]
        :rtype: int
        """
        if not costs:
            return 0
        if len(costs[0]) == 1:
            if len(costs) == 1:
                return costs[0][0]
            else:
                return 0

        n = len(costs)
        m = len(costs[0])

        i = 1
        while i < n:
            prev_cost = costs[i - 1]
            curr_cost = costs[i]
            min1, min2 = self.smallest_two(prev_cost)
            for j in xrange(m):
                if j == min1:
                    curr_cost[j] += prev_cost[min2]
                else:
                    curr_cost[j] += prev_cost[min1]
            i += 1

        return min(costs[-1])

    def minCostIISlow(self, costs):
        """Time complexity O(k^2*n), space complexity O(k)

        The slow part is repeatly calling finding min in an array with length k
        for k times.

        :type costs: List[List[int]]
        :rtype: int
        """
        if not costs:
            return 0
        houses = len(costs)
        dp = costs[0][:]
        k = len(dp)

        for i in xrange(1, houses):
            next_dp = [None] * k
            cost = costs[i]
            for j in xrange(k):
                next_dp[j] = cost[j] + self.min_except(dp, j)
            dp = next_dp
        return min(dp)

    def min_except(self, arr, j):
        """"""
        min_val = float('+inf')
        for i, val in enumerate(arr):
            if i != j:
                min_val = min(min_val, val)
        return min_val

    def smallest_two(self, arr):
        """"""
        min1 = None
        min2 = None

        for i, val in enumerate(arr):
            if min1 is None:
                min1 = i
            elif arr[min1] >= val:
                min1, min2 = i, min1
            elif min2 is None or arr[min2] >= val:
                min2 = i
            else:
                pass
        return min1, min2


def main():
    sol = Solution()
    assert sol.minCostII([[1, 5, 3], [2, 9, 4]]) == 5
    assert sol.smallest_two([1, 2, 3, 4]) == (0, 1)
    assert sol.smallest_two([1]) == (0, None)
    assert sol.smallest_two([3, 2, 1, 6, 3, 5, 1]) == (6, 2)


if __name__ == '__main__':
    main()
