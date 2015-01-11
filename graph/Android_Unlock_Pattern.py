"""Android_Unlock_Pattern

1. Each pattern must connect at least four dots.
2. The dots in the pattern must all be distinct.
3. If the line segment connecting any two consecutive dots in the pattern passes
   through any other dots, the other dots must have previously been in the pattern.


Thoughs: need to clarify that the way to draw a pattern and a pattern is different.
For example, 1 -> 2 -> 3 and 3 -> 2 -> 1 are two different ways to draw a pattern
and both of them are the same pattern, which is a undirected line across 1 to 3.

It's easy to start with how many ways to draw.

Follow-up: how many patterns?
"""


class Solution(object):

    """Yo young money."""

    def __init__(self):
        """"""
        # Given i in [0, 8],
        # x, y = divmod(i, 3)
        # ((x1 == x2) and (y1 == y2)) and
        # ((x1 == x2) and abs(y1 - y2) > 1) and
        # (abs(x1 - x2) > 1 and (y1 == y2))
        # (abs(x1 - x2) == abs(y1 - y2) and abs(y1 - y2) > 1)
        self.graph = [
            [0, 1, 0, 1, 1, 1, 0, 1, 0],
            [1, 0, 1, 1, 1, 1, 1, 0, 1],
            [0, 1, 0, 1, 1, 1, 0, 1, 0],
            [1, 1, 1, 0, 1, 0, 1, 1, 1],
            [1, 1, 1, 1, 0, 1, 1, 1, 1],
            [1, 1, 1, 0, 1, 0, 1, 1, 1],
            [0, 1, 0, 1, 1, 1, 0, 1, 0],
            [1, 0, 1, 1, 1, 1, 1, 0, 1],
            [0, 1, 0, 1, 1, 1, 0, 1, 0],
        ]

        self.n = len(self.graph)
        self.visited = [False] * self.n

    def _connectivity(self, vertex, add=True):
        """Update graph connectivity on-the-fly.

        1 is not connected to 3 unless 2 is visited.
        """
        mark = 1 if add else 0
        if vertex==1:
            self.graph[0][2] = mark
            self.graph[2][0] = mark
        elif vertex==3:
            self.graph[0][6] = mark
            self.graph[6][0] = mark
        elif vertex==4:
            self.graph[0][8] = mark
            self.graph[8][0] = mark
            self.graph[6][2] = mark
            self.graph[2][6] = mark
            self.graph[1][7] = mark
            self.graph[7][1] = mark
            self.graph[3][5] = mark
            self.graph[5][3] = mark
        elif vertex==5:
            self.graph[2][8] = mark
            self.graph[8][2] = mark
        elif vertex==7:
            self.graph[6][8] = mark
            self.graph[8][6] = mark
        else:
            pass

    def dfs(self, pat_length=9):
        """Brutal force path finding."""
        def rec(cur, acc, container):
            acc = acc + [cur]
            self.visited[cur] = True
            self._connectivity(cur) # Update connectivity.
            if len(acc) == pat_length:
                #container.append(' -> '.join(map(lambda x: str(x + 1), acc)))
                container.append(acc[::])
            else:
                for i in xrange(self.n):
                    if self.graph[cur][i] == 1 and not self.visited[i]:
                        rec(i, acc, container)

            self.visited[cur] = False # Unset visited before exit stack frame.
            self._connectivity(cur, add=False) # Reset connectivity.

        container = []

        for start in xrange(self.n):
            rec(start, [], container)
            self.visited = [False] * self.n

        return container

    def pattern(self, container):
        """Deduplicate with hashset.

        1 -> 2 -> 3 is equal to 3 -> 2 -> 1 because they both represent
        the same pattern: edge(1, 2) and edge(2, 3)
        Create the edge first edge(min, max) and create edge sequence.
        Sort before throwing it to hashset.
        Note that all of the node indexes are single digit so no need for
        delimiters. Using string representation for hash.
        """
        s = set()
        for comb in container:
            pat = []
            for i in xrange(len(comb) - 1):
                cur, nex = comb[i], comb[i + 1]
                a, b = min(cur, nex), max(cur, nex)
                pat.append('{0}{1}'.format(a, b))
            pat.sort()
            s.add(''.join(pat))

        return s


def main():
    solution = Solution()
    acc = 0
    total_way_to_create_patterns = []
    for i in xrange(4, 10):
        container = solution.dfs(pat_length=i)
        total_way_to_create_patterns += container
        print 'lenght', i, len(container)

    print 'Total number of different way to draw patterns', len(total_way_to_create_patterns)
    print 'Total number of patterns', len(solution.pattern(total_way_to_create_patterns))


if __name__ == '__main__':
    main()
