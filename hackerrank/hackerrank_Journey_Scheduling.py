"""hackerrank_Journey_Scheduling.py

https://www.hackerrank.com/contests/101hack19/challenges/journey-scheduling
"""


class Graph(object):

    def __init__(self, n):
        """"""
        self.adj_list = {}
        self.dim = n

    def add_edge(self, x, y):
        """"""
        def add_one_direction(x, y):
            try:
                self.adj_list[x].append(y)
            except KeyError:
                self.adj_list[x] = [y]

        add_one_direction(x, y)
        add_one_direction(y, x)

    def bfs(self, start):
        """"""
        cur_lvl = [start]
        dist = [None] * self.dim
        dist[start] = 0

        local_max_val = None
        local_max_idx = None

        while cur_lvl:
            vertex = cur_lvl.pop()
            for neighbor in self.adj_list[vertex]:
                if dist[neighbor] is not None:
                    # visited.
                    continue

                dist[neighbor] = dist[vertex] + 1
                cur_lvl.append(neighbor)
                if local_max_val is None or local_max_val < dist[neighbor]:
                    local_max_val = dist[neighbor]
                    local_max_idx = neighbor

        return dist, local_max_idx


def main():
    """It will reach the state of oscillation after visiting either the first
    or the second city.

    a - b - c - b - c - b - c...
    a - b - a - b - a...
    That means, no matter which city you starts at, the next city you visit is
    the one you will oscillate within.

    Breath first search will find all distances from one city to all the others
    and the furthest one. It doesn't matter the furthest city is visied already
    or not since it doesn't change the total distance.
    """
    n , m = map(int, raw_input().split())

    graph = Graph(n)
    for _ in xrange(n - 1):
        x, y = map(lambda x: int(x) - 1, raw_input().split()) # 0-base
        graph.add_edge(x, y)

    _,     oscillation_point1 = graph.bfs(0)
    dist1, oscillation_point2 = graph.bfs(oscillation_point1)
    dist2, _                  = graph.bfs(oscillation_point2)

    for _ in xrange(m):
        v, k = map(int, raw_input().split())
        v -= 1 # 0-base
        # Since the starting city is random, the next city will be one
        # that has further travelling distance of two oscillation point2.
        first_travel = max(dist1[v], dist2[v])
        # Oscillation starts!
        rest_travel  =(k - 1) * dist1[oscillation_point2]

        print first_travel + rest_travel


if __name__ == '__main__':
    main()
