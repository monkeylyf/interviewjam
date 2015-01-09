"""leetcode_Dungeon_Game.py

https://oj.leetcode.com/problems/dungeon-game/
"""

from pprint import pprint as p


class Solution(object):

    """DP solution."""

    def __init__(self):
        """"""
        pass

    def calculateMinimumHP(self, dungeon):
        """"""
        n = len(dungeon)
        m = len(dungeon[0])

        def min_health(cur, prev):
            """Key function.

            if current grid contains power-ups, and is larger than
            previous(right/down), the init status when hitting this grid is
            0.
            """
            if cur > 0 and cur >= prev:
                return 0
            else:
                return prev - cur

        # Init dp. 0-base.
        dp = [0] * m
        for j in reversed(xrange(m)):
            if j == m - 1:
                dp[j] = min_health(dungeon[n - 1][j], 0)
            else:
                dp[j] = min_health(dungeon[n - 1][j], dp[j + 1])

        for i in reversed(xrange(n - 1)):
            cur_dp = [0] * m
            for j in reversed(xrange(m)):
                if j == m - 1:
                    cur_dp[j] = min_health(dungeon[i][j], dp[j])
                else:
                    go_down  = min_health(dungeon[i][j], dp[j])
                    go_right = min_health(dungeon[i][j], cur_dp[j + 1])

                    cur_dp[j] = min(go_right, go_down)

            dp = cur_dp

        return dp[0] + 1 # Turn to 1 based.


def main():
    dungeon = [[-2, -3, 3],
               [-5, -10, 1],
               [10, 30, -5]]

    print Solution().calculateMinimumHP(dungeon)


if __name__ == '__main__':
    main()
