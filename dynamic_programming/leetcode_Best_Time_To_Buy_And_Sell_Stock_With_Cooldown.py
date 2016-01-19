"""Best time to buy and sell stock with cooldown
leetcode

Say you have an array for which the ith element is the price of a given stock on
day i.

Design an algorithm to find the maximum profit. You may complete as many
transactions as you like (ie, buy one and sell one share of the stock multiple
times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
"""


class Solution(object):
    def maxProfit(self, prices):
        """Return max possible profit given rules.

        Three states: possess, not_possess, cool_down
        possess ----->     no action -----> possess
        not_possess -----> buy       -----> possess

        not_possess -----> no action -----> not_possess
        cool_down ----->   no action -----> not_possess

        possess ----->     sell      -----> cool_down

        :type prices: List[int]
        :rtype: int
        """
        np = 0
        p = -999999 # MIN_INT
        cd = -999999 # MIN_INT
        for price in prices:
            p, np, cd = max(p, np - price), max(np, cd), p + price
        return max(np, cd)


def main():
    sol = Solution()
    #print sol.maxProfit([1, 2, 3, 0, 2])
    print sol.maxProfit([2, 1])


if __name__ == '__main__':
    main()
