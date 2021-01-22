# https://leetcode.com/problems/minimum-cost-for-tickets/

from typing import List

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if not days:
            return 0

        n = len(days)
        dp = [float('inf')] * n
        one, seven, thirty = costs

        for i, day in enumerate(days):
            # Day pass.
            j = i - 1
            while j >= 0 and days[j] > day - 1:
                j -= 1
            if j >= 0:
                dp[i] = min(dp[i], dp[j] + one)
            else:
                dp[i] = min(one, dp[i])

            # 7-day pass.
            j = i - 1
            while j >= 0 and days[j] > day - 7:
                j -= 1
            if j >= 0:
                dp[i] = min(dp[i], dp[j] + seven)
            else:
                dp[i] = min(dp[i], seven)
            # 30-day pass.
            j = i - 1
            while j >= 0 and days[j] > day - 30:
                j -= 1
            if j >= 0:
                dp[i] = min(dp[i], dp[j] + thirty)
            else:
                dp[i] = min(dp[i], thirty)

        return dp[-1]


def main():
    sol = Solution()
    print(sol.mincostTickets([1, 4, 6, 7, 8, 20], [2, 7, 15]))
    print(sol.mincostTickets([1,2,3,4,5,6,7,8,9,10,30,31], [2, 7, 15]))


if __name__ == '__main__':
    main()
