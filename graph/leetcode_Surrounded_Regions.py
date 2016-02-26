"""Surrounded regions
leetcode

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
"""


from collections import deque


class Solution(object):

    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board:
            return
        n = len(board)
        m = len(board[0])
        queue = self.o_on_borders(board, n, m)

        deltas = ((-1, 0), (1, 0), (0, -1), (0, 1))
        # BFS to convert regions connected to borders to a intermediate state.
        while queue:
            x, y = queue.popleft()
            board[x][y] = 'M'

            for dx, dy in deltas:
                xx = x + dx
                yy = y + dy

                if xx >= 0 and xx < n and \
                   yy >= 0 and yy < m and \
                   board[xx][yy] == 'O':
                    queue.append((xx, yy))

        # For all O cells not converted into 'M', they are surrounded thus
        # converted into X and convert 'M' back to 'O'.
        for i in xrange(n):
            for j in xrange(m):
                if board[i][j] == 'M':
                    board[i][j] = 'O'
                elif board[i][j] == 'O':
                    board[i][j] = 'X'
                else:
                    pass

    def o_on_borders(self, board, n, m):
        """Find all O's on border."""
        queue = deque()
        for i in xrange(m):
            if board[0][i] == 'O':
                queue.append((0, i))
            if board[n - 1][i] == 'O':
                queue.append((n - 1, i))
        for i in xrange(1, n - 1):
            if board[i][0] == 'O':
                queue.append((i, 0))
            if board[i][m - 1] == 'O':
                queue.append((i, m - 1))
        return queue


def main():
    sol = Solution()
    board = [
        ['X', 'X', 'X', 'X'],
        ['X', 'O', 'O', 'X'],
        ['X', 'X', 'O', 'X'],
        ['X', 'O', 'X', 'X'],
    ]
    sol.solve(board)

    from pprint import pprint as p
    p(board)


if __name__ == '__main__':
    main()
