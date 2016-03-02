"""Best time to buy and sell stock IV
leetcode

Say you have an array for which the ith element is the price of a given stock
on day i.

Design an algorithm to find the maximum profit. You may complete at most k
transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell
the stock before you buy again).
"""

"""
int n = prices.length;
    if (n <= 1)
        return 0;

    //if k >= n/2, then you can make maximum number of transactions.
    if (k >=  n/2) {
        int maxPro = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i-1])
                maxPro += prices[i] - prices[i-1];
        }
        return maxPro;
    }

    int[][] dp = new int[k+1][n];
    for (int i = 1; i <= k; i++) {
        int localMax = dp[i-1][0] - prices[0];
        for (int j = 1; j < n; j++) {
            dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
            localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
        }
    }
    return dp[k][n-1];
}
"""


class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        n = len(prices)
        if n <= 1:
            return 0

        if k >= n / 2:
            # That means you can do all profitable transactions possible.
            total = 0
            i = 1
            while i < n:
                total += max(0, prices[i] - prices[i - 1])
                i += 1
            return total

        # dp[i][j] indicates with most i transactions in j days
        # what's the max profit.
        # dp[i][j] = max(dp[i][j-1], prices[j] - prices[jj] + dp[i-1][jj])
        #          = max(dp[i][j-1], prices[j] + max(dp[i-1][jj] - prices[jj]))
        #            where jj in [0, j-1]
        dp = [[0 for _ in xrange(n)] for _ in xrange(k + 1)]
        for i in xrange(1, k + 1):
            local_max = dp[i - 1][0] - prices[0]
            for j in range(1, n):
                dp[i][j] = max(dp[i][j - 1], prices[j] + local_max)
                local_max = max(local_max, dp[i - 1][j] - prices[j])

        return dp[k][-1]


def main():
    sol = Solution()
    assert sol.maxProfit(3, [1, 2, 3, 4]) == 3


if __name__ == '__main__':
    main()
