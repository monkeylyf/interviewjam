"""A* search.

http://en.wikipedia.org/wiki/A*_search_algorithm
"""


from Queue import PriorityQueue


class Matrix(object):

    """Matrix calss that represents a graph."""

    Obstacle = 0

    def __init__(self, mtx):
        """"""
        self._mtx = mtx

        self.n = len(mtx)
        self.m = len(mtx[0])

    def neighbors(self, p):
        """Generator."""
        shifts = ((-1, 0), (1, 0), (0, -1), (0, 1)) # up/down/left/right

        for dx, dy in shifts:
            if p.x + dx >= 0 and p.x + dx < self.n and \
               p.y + dy >= 0 and p.y + dy < self.m and \
               self._mtx[p.x + dx][p.y + dy] != Matrix.Obstacle:
                   yield Point(p.x + dx, p.y + dy)

    def heuristic(self, start, goal):
        return abs(start.x - goal.x) + abs(start.y - goal.y)

    def reconstruct_path(self, came_from, current):
        """"""
        from pprint import pprint
        #p(came_from)
        #p(came_from[current])

        total_path = [current]

        while current in came_from:
            current = came_from[current]
            if current is not None:
                total_path.append(current)

        #p(total_path)

        for p in total_path:
            self._mtx[p.x][p.y] = 8

        pprint(self._mtx)


    def a_star(self, start, goal):
        """"""
        # Init priority queue.
        q = PriorityQueue()
        q.put(start, 0)

        came_from = {start: None}
        # The known cost needed to travel from start to a point.
        visited = {start: 0}

        while not q.empty():
            # pop the point with lowest priority(cost).
            # The idea is always that points tends to be closer to goal first.
            p = q.get()

            if p == goal:
                # Reach the goal.
                self.reconstruct_path(came_from, goal)
                return

            for neighbor in self.neighbors(p):
                tentative = visited[p] + self.heuristic(p, neighbor)

                if neighbor not in visited or tentative < visited[neighbor]:
                    came_from[neighbor] = p
                    visited[neighbor] = tentative

                    # Priority is the estimated cost that it took to travel from
                    # neighbor to goal. In this case, it's just the Manhattan
                    # distance assuming that there are no obstacles between them.
                    priority = tentative + self.heuristic(neighbor, goal)
                    q.put(neighbor, priority)


class Point(object):

    """"""

    __slots__ = ('x', 'y')

    def __init__(self, x, y):
        """"""
        self.x = x
        self.y = y

    def __eq__(self, that):
        """"""
        return self.x == that.x and self.y == that.y

    def __hash__(self):
        """I need to think about this."""
        # TODO
        return hash('{0}:{1}'.format(self.x, self.y))

    def __repr__(self):
        """"""
        return "<{0}, {1}>".format(self.x, self.y)


def main():
    O = Matrix.Obstacle
    mtx = [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, O, O, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, O, O, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, O, O, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, O, O, O, O, O, O, O, O, O, O, O, 1, 1, 1],
           [1, 1, 1, 1, O, O, O, O, O, O, O, O, O, O, O, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
           [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
          ]

    graph = Matrix(mtx)
    start = Point(13, 1)
    goal = Point(1, 13)

    graph.a_star(start, goal)


if __name__ == '__main__':
    main()
