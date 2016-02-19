"""Game of lie
leetcode

According to the Wikipedia's article: "The Game of Life, also known simply as
Life, is a cellular automaton devised by the British mathematician John Horton
Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or
dead(0). Each cell interacts with its eight neighbors (horizontal, vertical,
diagonal) using the following four rules (taken from the above Wikipedia
article):

Any live cell with fewer than two live neighbors dies, as if caused by
under-population.
Any live cell with two or three live neighbors lives on to the next
generation.
Any live cell with more than three live neighbors dies, as if by
over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by
reproduction.
Write a function to compute the next state (after one update) of the board given
its current state.
"""

class Solution(object):
    def gameOfLife(self, board):
        """Modified in-place.

        Live cell:
        # of neighbors < 2 -> 0
        # of neighbors == 2 or 3 -> 1
        # of neighbors > 3 -> 0

        Dead cell:
        # of neighbors == 3 -> 1

        0: it was dead and now is dead
        1: it was live and now is live
        2: it was dead and now is live
        3: it was live and now is dead

        The number represents both the current state and previous state.
        previous state = code % 2

        :type board: List[List[int]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        def neighbor(board, x, y, n, m):
            """Return number of neighbors."""
            deltas = (
                (-1, -1), (-1, 0), (-1, 1),
                (0, -1), (0, 1),
                (1, -1), (1, 0), (1, 1),
            )
            count = 0
            for dx, dy in deltas:
                xx = x + dx
                yy = y + dy
                if xx >= 0 and xx < n and yy >= 0 and yy < m and board[xx][yy] % 2 == 1:
                    count += 1

            return count

        n = len(board)
        m = len(board[0])

        for i in xrange(n):
            for j in xrange(m):
                if board[i][j] == 0:
                    if neighbor(board, i, j, n, m) == 3:
                        board[i][j] = 2
                elif board[i][j] == 1:
                    num = neighbor(board, i, j, n, m)
                    if num < 2 or num > 3:
                        board[i][j] = 3
                else:
                    pass

        for i in xrange(n):
            for j in xrange(m):
                if board[i][j] == 2:
                    board[i][j] = 1
                elif board[i][j] == 3:
                    board[i][j] = 0


def main():
    sol = Solution()
    board = [
        [1, 1],
        [1, 0]
    ]
    sol.gameOfLife(board)
    assert board == [[1, 1], [1, 1]]


if __name__ == '__main__':
    main()
