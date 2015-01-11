"""google_Encoded_Dict.py
google

All words in a dictionary are decoded by mapping one character to another.
It's strictly one-to-one mapping, which means no multiple characters are mapped
to the same char.
For example:

cat
coffee
common

After the encoding:

dkc
dbhhzz
dbllbq

And of course this dictionary is in lexicographical order.
Try to decode the dictionary.

This is the Python version. Java version is: graph/google_Encoded_Dict.java
"""


class Solution(object):

    """"""

    def __init__(self, words):
        """"""
        self._words = words

    def solve(self):
        """"""
        graph = self.create_graph(self._words)

        mapping = graph.toposort()

        encode = lambda x: mapping[x]
        for word in self._words:
            print map(encode, word)

    def create_graph(self, words):
        """"""
        graph = Graph()

        # Vertical order. Think about alphabetical order. That's where we find
        # directed node connectivity.
        for i in xrange(len(words) - 1):
            cur_word = words[i]
            nex_word = words[i + 1]

            for j in xrange(max(len(cur_word), len(nex_word))):
                if cur_word[j] == nex_word[j]:
                    continue
                else:
                    print nex_word[j], cur_word[j]
                    graph.add_edge(nex_word[j], cur_word[j])
                    break

        return graph


class Graph(object):

    LENGTH=26

    """Graph class for lowercase alphabeta.

    Dimension is fixed at 26. Using adjacent matrix to represent the grapy.
    """

    def __init__(self):
        """"""
        self._matrix = [[0 for i in xrange(Graph.LENGTH)] for _ in xrange(Graph.LENGTH)]
        self._mapping = {chr(i + 97) : i for i in xrange(Graph.LENGTH)}
        self._indegree = [0] * Graph.LENGTH

    def add_edge(self, a, b):
        """"""
        if a == b:
            return

        i = self._mapping[a]
        j = self._mapping[b]

        print a, i, b, j
        if self._matrix[i][j] == 0:
            self._matrix[i][j] = 1
            self._indegree[j] += 1

    def toposort(self):
        """Iterative way to find the topo sort of a graph."""
        topo_order = []

        visited = [0] * Graph.LENGTH

        for i in xrange(Graph.LENGTH):
            v = -1
            # Find the current node with zero indegree.
            for j in xrange(Graph.LENGTH):
                if v >= 0:
                    break
                if self._indegree[j] == 0 and not visited[j]:
                    v = j
            if v < 0:
                break

            visited[v] = 1
            topo_order.append(v)

            for j in xrange(Graph.LENGTH):
                if self._matrix[v][j]:
                    self._indegree[j] -= 1

        return self.invert_mapping(topo_order)

    def invert_mapping(self, order):
        """"""
        assert len(set(order)) == len(order), 'Duplicates in topo order: {0}'.format(order)
        mapping = {}

        print order
        for i, val in enumerate(order):
            #print 'topo order'
            #print i, val
            #print chr(i + 97), chr(val + 97)
            mapping[chr(i + 97)] = chr(val + 97)

        return mapping

    def __repr__(self):
        """"""
        return 'Graph object at {0}'.format(hex(id(self)))


def main():
    words = ['dkc',
             'dbhhz',
             'dbllbq']

    Solution(words).solve()



if __name__ == '__main__':
    main()
