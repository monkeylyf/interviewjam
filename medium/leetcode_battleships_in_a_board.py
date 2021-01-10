# https://leetcode.com/problems/battleships-in-a-board/

from typing import List

class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        # Since the map is guaranteed to be valid, only counts the
        # ship head, the one at left-most or upper-most.
        total = 0
        if not board:
            return total

        n = len(board)
        m = len(board[0])

        for i in range(n):
            for j in range(m):
                if board[i][j] == '.':
                    continue
                if i > 0 and board[i - 1][j] == 'X':
                    continue
                if j > 0 and board[i][j - 1] == 'X':
                    continue
                total += 1

        return total
