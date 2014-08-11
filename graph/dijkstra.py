""" dijkstra.py


"""

import heapq
import sys


def dijkstra_priority_queue(graph, src):
    """Optimized version of dijkstra using priority queue.

    Time complexity: O( (E + V)logV), E stands for edge and V for vertices.
    """
    length = len(graph)

    visited = set()
    dist = [sys.maxint for _ in xrange(length)]
    previous = [sys.maxint for _ in xrange(length)]
    # The dist from src to src is 0 and the first time to call min_dist will
    # return src.
    dist[src] = 0

    heap = [(0, src)] # Weight, index

    while heap:
        (_, min_idx) = heapq.heappop(heap)
        if min_idx in visited:
            continue

        visited.add(min_idx)

        for i in xrange(length):
            if i not in visited and \
                graph[min_idx][i] != 0 and \
                dist[min_idx] != sys.maxint and \
                dist[min_idx] + graph[min_idx][i] < dist[i]:
                    dist[i] = dist[min_idx] + graph[min_idx][i]
                    heapq.heappush(heap, (dist[i], i))

    print 'Min vertes distance from src', src
    for i, val in enumerate(dist):
        print i, '\t', val


def dijkstra(graph, src):
    """Dijkstra algorithm for shortest path.

    Maintaining an array dist[i], representing known shortest path from src
    to i, with initial dist[src] = 0 (the shortest path to itself is zero).
    For each iteration, get the shortest path so far from src and try to update
    known path if taking shortest path is better:
        dist[min] + graph[min][i] < dist[i]

    Edge weights must be non-negative, so it can be assumed that taking less edges
    are always better.
    Time complexity O(V^2), V stands for vertices.

    :param graph: 2d list of int. Adjacency matrix of graph.
    :param src: int. source index.
    """
    length = len(graph)

    visited = set()
    dist = [sys.maxint for _ in xrange(length)]
    # The dist from src to src is 0 and the first time to call min_dist will
    # return src.
    dist[src] = 0

    for _ in xrange(length):
        min_idx = min_dist(dist, visited)
        visited.add(min_idx)
        for i in xrange(length):
            # Do not travel back to visited vertex.
            if i not in visited and \
                graph[min_idx][i] != 0 and \
                dist[min_idx] != sys.maxint and \
                dist[min_idx] + graph[min_idx][i] < dist[i]:
                # min_idx and i are connected.
                # shortest path from src to min_idx is found.
                # from src to min_idx and min_idx to i is shorter.
                dist[i] = dist[min_idx] + graph[min_idx][i]

    print 'Min vertes distance from src', src
    for i, val in enumerate(dist):
        print i, '\t', val


def min_dist(dist, visited):
    """"""
    local_min = sys.maxint
    min_idx = 0
    for i, val in enumerate(dist):
        if i not in visited and val < local_min:
            local_min = val
            min_idx = i

    return min_idx


def main():
    #graph = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]
    graph = [[0, 4, 0, 0, 0, 0, 0, 8, 0],
             [4, 0, 8, 0, 0, 0, 0, 11, 0],
             [0, 8, 0, 7, 0, 4, 0, 0, 2],
             [0, 0, 7, 0, 9, 14, 0, 0, 0],
             [0, 0, 0, 9, 0, 10, 0, 0, 0],
             [0, 0, 4, 0, 10, 0, 2, 0, 0],
             [0, 0, 0, 14, 0, 2, 0, 1, 6],
             [8, 11, 0, 0, 0, 0, 1, 0, 7],
             [0, 0, 2, 0, 0, 0, 6, 7, 0]]


    #for i in xrange(len(graph)):
    dijkstra_priority_queue(graph, 0)
    dijkstra(graph, 0)


if __name__ == '__main__':
    main()
