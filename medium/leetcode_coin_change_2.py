# https://leetcode.com/problems/coin-change-2/

from typing import List

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        if amount == 0:
            return 1

        if not coins:
            return 0

        n = len(coins)
        prev = [0] * (amount + 1)
        prev[0] = 1
        cur = [0] * (amount + 1)
        coins.sort()
        for i in range(1, n + 1):
            coin = coins[i - 1]
            cur[0] = 1
            for j in range(1, amount + 1):
                cur[j] = prev[j] + (cur[j - coin] if j >= coin else 0)
            prev = cur
            cur = [0] * (amount + 1)
        return prev[-1]


def main():
    sol = Solution()
    print(sol.change(5, [1, 2, 5]))
    print(sol.change(6, [1, 2, 5]))
    print(sol.change(3, [2]))
    print(sol.change(10, [10]))
    print(sol.change(500, [2, 7, 13]))


if __name__ == '__main__':
    main()
