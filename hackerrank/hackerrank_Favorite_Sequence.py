"""hackerrank_Favorite_Sequence.py

https://www.hackerrank.com/contests/w12/challenges/favourite-sequence
"""

from collections import Counter
from heapq import heappop, heappush


class Graph(object):

    """"""

    def __init__(self):
        """"""
        self.adj_list = {}
        self.indegree = Counter()

    def add_edge(self, start, end):
        """"""
        #self.indegree[end] += 1
        #try:
        #    self.adj_list[start].append(end)
        #except KeyError:
        #    self.adj_list[start] = [end]

        try:
            neighbors = self.adj_list[start]
        except KeyError:
            neighbors = set()

        if end not in neighbors:
            self.indegree[end] += 1

        neighbors.add(end)
        self.adj_list[start] = neighbors


    def build_with_seq(self, seq):
        """"""
        for i, cur in enumerate(seq):
            if i == 0:
                continue
            prev = seq[i - 1]
            self.add_edge(prev, cur)


    def toposort(self):
        """Iterative topo sort.

        Using indegree and seen indegree count to decide when is
        the right time to push the node to order list.
        This toposort can handle multiple disconnected subgraph
        in one graph.
        """
        seen_indegree = Counter()
        topo_order = []

        q = []
        for seed in self.adj_list:
            if self.indegree[seed] == 0:
                heappush(q, seed)

        while q:
            v = heappop(q)
            topo_order.append(v)
            try:
                neighbors = self.adj_list[v]
            except KeyError:
                neighbors = []

            for neighbor in neighbors:
                seen_indegree[neighbor] += 1
                if seen_indegree[neighbor] == self.indegree[neighbor]:
                    heappush(q, neighbor)

        return topo_order


def main():
    """Created graph and then find topo sord order."""
    n = int(raw_input())
    graph = Graph()
    for _ in xrange(n):
        k = int(raw_input())
        seq = map(int, raw_input().split())
        graph.build_with_seq(seq)

    print ' '.join(map(str, graph.toposort()))


if __name__ == '__main__':
    main()
