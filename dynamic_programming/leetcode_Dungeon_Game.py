"""Dungeon Game
leetcode

The demons had captured the princess (P) and imprisoned her in the bottom-right
corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid.
Our valiant knight (K) was initially positioned in the top-left room and must
fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at
any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative
integers) upon entering these rooms; other rooms are either empty (0's) or
contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to
move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is
able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be
at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

-2 (K)  -3      3
-5      -10     1
10      30      -5 (P)
"""


class Solution(object):

    """DP solution.

    Thinking that, we already know both the min HP required for next cell and
    whether there are demons or magic orb in current cell. What's the min HP
    required for current cell?
    max(hp_required_for_next_cell - val_in_current_cell, 0)

    If hp_required_for_next_cell is less than val_in_current_cell, implying it
    is magic orb not demons, The min HP required to enter this room is 0,
    because what you gain in this room is already enough for next.
    Else it's intuitive.

    Minimum HP to keep alive it set to 1, which is annoying for calculate.
    Set it to 0 and set it back when return.
    """

    def calculateMinimumHP(self, dungeon):
        """"""
        n = len(dungeon)
        m = len(dungeon[0])

        # Init dp. 0-base.
        dp = [0] * m
        # Calculate the last row first.
        for j in reversed(xrange(m)):
            if j == m - 1:
                dp[j] = max(-dungeon[n - 1][j], 0)
            else:
                dp[j] = max(dp[j + 1] - dungeon[n - 1][j], 0)

        for i in reversed(xrange(n - 1)):
            cur_dp = [0] * m
            for j in reversed(xrange(m)):
                if j == m - 1:
                    # Can only go down.
                    cur_dp[j] = max(dp[j] - dungeon[i][j], 0)
                else:
                    # Can go down or go right.
                    go_down = max(dp[j] - dungeon[i][j], 0)
                    go_right = max(cur_dp[j + 1] - dungeon[i][j], 0)

                    cur_dp[j] = min(go_right, go_down)

            dp = cur_dp

        return dp[0] + 1  # Turn to 1 based.


def main():
    dungeon = [
        [-2, -3, 3],
        [-5, -10, 1],
        [10, 30, -5]
    ]

    assert Solution().calculateMinimumHP(dungeon) == 7


if __name__ == '__main__':
    main()
