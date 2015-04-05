"""Conways_Game_Of_Life.py

http://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
"""

import curses
import time


# Block.
GRID = [[0, 0, 0, 0],
        [0, 1, 1, 0],
        [0, 1, 1, 0],
        [0, 0, 0, 0]]

# Blinker.
GRID = [[0, 0, 0],
        [1, 1, 1],
        [0, 0, 0]]


# Beacon
GRID = [[0, 0, 0, 0, 0, 0],
        [0, 1, 1, 0, 0, 0],
        [0, 1, 1, 0, 0, 0],
        [0, 0, 0, 1, 1, 0],
        [0, 0, 0, 1, 1, 0],
        [0, 0, 0, 0, 0, 0]]


def draw_grid(window):
    """"""
    grid = GRID
    count = 0
    while 1:
        s = []
        for i in xrange(len(grid)):
            for j in xrange(len(grid[i])):
                if grid[i][j] == 1:
                    s.append('X ')
                else:
                    s.append('_ ')
            if i != len(grid) - 1:
                s.append('\n')
        window.addstr(0, 0, ''.join(s))
        count += 1
        window.refresh()
        time.sleep(.5)

        grid = next_gen(grid)


def next_gen(grid, shifts=((-1, -1), (-1, 0), (-1, 1),
                           (0, -1),  (0, 1),
                           (1, -1),  (1, 0),  (1, 1))):
    """"""
    n = len(grid)
    m = len(grid[0])

    next_generation = [[0 for _ in xrange(m)] for _ in xrange(n)]

    for x in xrange(n):
        for y in xrange(m):
            alive_neighbors = 0
            for dx, dy in shifts:
                xx = x + dx
                yy = y + dy
                if 0 <= xx <= n - 1 and 0 <= yy <= m - 1 and grid[xx][yy] == 1:
                    alive_neighbors += 1
            if grid[x][y] == 1:
                # Any live cell with fewer than two live neighbours dies, as
                # if caused by under-population.
                if alive_neighbors < 2:
                    next_generation[x][y] = 0
                # Any live cell with two or three live neighbours lives on to
                # the next generation.
                elif alive_neighbors < 4:
                    next_generation[x][y] = 1
                # Any live cell with more than three live neighbours dies, as
                # if by overcrowding.
                else:
                    next_generation[x][y] = 0
            else:
                if alive_neighbors == 3:
                    next_generation[x][y] = 1

    return next_generation


def main():
    curses.wrapper(draw_grid)


if __name__ == '__main__':
    main()
