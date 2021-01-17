# https://leetcode.com/problems/stone-game/

from typing import List

class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        if not piles:
            return False

        n = len(piles)
        dp = [[0 for _ in range(n)] for _ in range(n)]
        for step in range(n):
            for i in range(n):
                e = i + step
                if e >= n:
                    continue
                if step == 0:
                    dp[i][i] = piles[i]
                elif step == 1:
                    dp[i][e] = max(piles[i], piles[e]) - min(piles[i], piles[e])
                else:
                    take_first = piles[i] - dp[i + 1][e]
                    take_last = piles[e] - dp[i][e - 1]
                    dp[i][e] = max(take_first, take_last)
        return dp[0][-1] > 0


def main():
    sol = Solution()
    print(sol.stoneGame([5, 3, 4, 5]))
    print(sol.stoneGame([3, 2, 10, 4]))


if __name__ == '__main__':
    main()
