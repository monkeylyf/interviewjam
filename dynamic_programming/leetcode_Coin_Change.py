"""Coin change
leetcode

You are given coins of different denominations and a total amount of money
amount. Write a function to compute the fewest number of coins that you need
to make up that amount. If that amount of money cannot be made up by any
combination of the coins, return -1.
"""

class Solution(object):

    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        coins.sort()
        dp = [float('+inf')] * (amount + 1)
        dp[0] = 0

        for coin in coins:
            for i in xrange(1, amount + 1):
                if i >= coin:
                    # Note that float('-inf') + 1 is stll float('inf') because
                    # it's negative infinity, which is quite convinient.
                    dp[i] = min(dp[i], dp[i - coin] + 1)

        if dp[-1] == float('+inf'):
            return -1
        else:
            return dp[-1]


def main():
    sol = Solution()
    assert sol.coinChange([1], 1) == 1
    assert sol.coinChange([2], 1) == -1
    assert sol.coinChange([1, 2, 5], 11) == 3
    assert sol.coinChange([186,419,83,408], 6249) == 20
    assert sol.coinChange([357,445,294,411,447,285,11], 3343) == 8


if __name__ == '__main__':
    main()
