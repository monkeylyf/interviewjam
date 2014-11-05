"""pinabll_maze

Find the exit of the maze for Mr.Pinball.

Assuming: Maze is represented as a matrix, 0: path, 1: wall.
          Entrance is at ?? and exit is at ??.
          There will be at least one path leads to the exit of the maze.
"""

class Solution(object):

    """Not runnable. Have to define entrance and exit."""

    def __init__(self, maze):
        """"""
        self.maze = maze
        self.n = len(maze)
        self.m = len(maze[0])

        self.direction_map = {'left':  (0, -1},
                              'right': (0,  1),
                              'up':    (1,  0),
                              'down':  (-1, 0)}

    def solve(self):
        """"""
        all_paths = []
        x, y = 0, 0
        visited = set((x, y))

        self.dfs(x + 1, y, 'up',    [(x, y)], all_paths, visited)
        self.dfs(x - 1, y, 'down',  [(x, y)], all_paths, visited)
        self.dfs(x, y + 1, 'right', [(x, y)], all_paths, visited)
        self.dfs(x, y - 1, 'left',  [(x, y)], all_paths, visited)

        return all_pathsp

    def dfs(self, x, y, direction, path, all_paths, visited):
        """"""
        if x < 0 or x >= self.n or y < 0 or y >= self.m or \
          self.maze[x][y] == 1 or (x, y) in visited:
            # Out of maze or in wall or cicle.
            return

        if self.is_exit(x, y):
            print 'Find exit'
            all_paths.append(path[::])
            return

        dx, dy = self.direction_map[direction]

        # Move with the same direction until hit a wall.
        while x + dx >= 0 and x + dx < self.n and \
              y + dy >= 0 and y + dy < self.m and \
              self.maze[x + dx][y + dy] != 1:
            x += dx
            y += dy

        if dx in (-1, 1):
            # Means pinball moves vertically. Check if there is horizontal turn.
            if y + 1 < self.m and self.maze[x][y + 1] == 0:
                self.dfs(x,  y + 1, 'right', path + [(x, y)], all_paths, set.union(visited, set((x, y + 1))))
            if y - 1 >= 0 and self.maze[x][y - 1] == 0:
                self.dfs(x,  y - 1, 'left', path + [(x, y)], all_paths, set.union(visited, set((x, y - 1))))
        if dy in (-1, 1):
            # Means pinball moves horizontally. Check if there is vertical turn.
            if x + 1 < self.n and self.maze[x + 1][y] == 0:
                self.dfs(x + 1, y, 'up', path + [(x, y)], all_paths, set.union(visited, set((x + 1, y))))
            if x - 1 < self.n and self.maze[x - 1][y] == 0:
                self.dfs(x - 1, y, 'down', path + [(x, y)], all_paths, set.union(visited, set((x - 1, y))))

    def is_exit(self, x, y):
        """"""
        raise NotImplemented("Define exit and entrance first")


def main():
    solution = Solution()


if __name__ == '__main__':
    main()
