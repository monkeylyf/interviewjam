"""pinabll_maze

Find the exit of the maze for Mr.Pinball.

Assuming: Maze is represented as a matrix, 0: path, 1: wall.
          Entrance is at ?? and exit is at ??.
          There will be at least one path leads to the exit of the maze.
"""

class GraphSolution(object):

    """"""

    def __init__(self, maze):
        """"""
        self.maze = maze
        self.graph = []

    def build_graph(self):
        """"""
        pass

    def solve(self, ):
        """"""
        pass



class DFSSolution(object):

    """Not runnable. Have to define entrance and exit."""

    def __init__(self, maze):
        """"""
        self.maze = maze
        self.n = len(maze)
        self.m = len(maze[0])

        self.entrance = (0, 1)
        self.exit = (self.n - 1, self.m - 2)

        self.direction_map = {'left':  (0, -1),
                              'right': (0,  1),
                              'up':    (-1,  0),
                              'down':  (1, 0)}

    def solve(self):
        """"""
        all_paths = []
        x, y = 0, 1
        visited = set([(x, y)])

        self.dfs(x - 1, y, 'up',    [(x, y)], all_paths, visited)
        self.dfs(x + 1, y, 'down',  [(x, y)], all_paths, visited)
        self.dfs(x, y + 1, 'right', [(x, y)], all_paths, visited)
        self.dfs(x, y - 1, 'left',  [(x, y)], all_paths, visited)

        for path in all_paths:
            self.visualize(path)

    def visualize(self, path):
        """"""
        maze = [['1' for _ in xrange(self.m)] for _ in xrange(self.n)]

        prev_x, prev_y = None, None
        for x, y in path:
            maze[x][y] = '0'
            if prev_x is not None and prev_y is not None:
                if prev_y == y:
                    # x changes.
                    for i in xrange(min(x, prev_x), max(x, prev_x) + 1):
                        maze[i][y] = '0'
                if prev_x == x:
                    # y changes.
                    for i in xrange(min(y, prev_y), max(y, prev_y) + 1):
                        maze[x][i] = '0'
            prev_x, prev_y = x, y

        print ''.join(('v' if i == 1 else ' ' for i in xrange(self.m)))
        for row in maze:
            print ''.join(row)

        print ''.join(('^' if i == self.m - 2 else ' ' for i in xrange(self.m)))

    def dfs(self, x, y, direction, path, all_paths, visited):
        """"""
        if x < 0 or x >= self.n or y < 0 or y >= self.m or \
          self.maze[x][y] == '1':
            # Out of maze or in wall or cicle.
            return

        if self.is_exit(x, y):
            all_paths.append(path[::] + [(self.n - 1, self.m - 2)])
            return

        dx, dy = self.direction_map[direction]

        # Move with the same direction until hit a wall.
        while x + dx >= 0 and x + dx < self.n and \
              y + dy >= 0 and y + dy < self.m and \
              self.maze[x + dx][y + dy] != '1':
            x += dx
            y += dy

        if dx in (-1, 1):
            # Means pinball moves vertically. Check if there is horizontal turn.
            if y + 1 < self.m and self.maze[x][y + 1] == '0' and  (x, y + 1) not in visited:
                self.dfs(x,  y + 1, 'right', path + [(x, y)], all_paths, set.union(visited, set([(x, y + 1)])))
            if y - 1 >= 0 and self.maze[x][y - 1] == '0' and (x, y - 1) not in visited:
                self.dfs(x,  y - 1, 'left', path + [(x, y)], all_paths, set.union(visited, set([(x, y - 1)])))
        if dy in (-1, 1):
            # Means pinball moves horizontally. Check if there is vertical turn.
            if x + 1 < self.n and self.maze[x + 1][y] == '0' and (x + 1, y) not in visited:
                self.dfs(x + 1, y, 'down', path + [(x, y)], all_paths, set.union(visited, set([(x + 1, y)])))
            if x - 1 < self.n and self.maze[x - 1][y] == '0' and (x - 1, y) not in visited:
                self.dfs(x - 1, y, 'up', path + [(x, y)], all_paths, set.union(visited, set([(x - 1, y)])))

    def is_exit(self, x, y):
        """"""
        return x == self.n - 1 and y == self.m - 2


def main():
    #DFSSolution = DFSSolution()


    # Test.
    # Entrance point (0, 1)
    # Exit point (n - 1, m - 2)
    maze = ['10111111111111111',
            '10100010000000001',
            '10001010101111101',
            '11111010101110001',
            '11101010000000111',
            '10000010111110111',
            '10111110100000001',
            '10100000101110111',
            '10001110000010001',
            '11111111111111101',
            ]

    #GraphSolution(maze).solve()
    DFSSolution(maze).solve()


if __name__ == '__main__':
    main()
