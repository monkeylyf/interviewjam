"""Longest increasing path in a matrix
leetcode

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down.
You may NOT move diagonally or move outside of the boundary (i.e. wrap-around
is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
"""


class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        def toposort(stack, visited, i, graph):
            """Toposort a DAG."""
            visited[i] = True
            for j in graph.get(i, []):
                if not visited[j]:
                    toposort(stack, visited, j, graph)
            stack.append(i)

        if not matrix:
            return 0
        n = len(matrix)
        m = len(matrix[0])
        total = n * m
        deltas = ((-1, 0), (1, 0), (0, -1), (0, 1))
        graph = {i: [] for i in range(total)}
        in_degree = {i: 0 for i in xrange(total)}

        # Build graph.
        for x in xrange(n):
            for y in xrange(m):
                for dx, dy in deltas:
                    xx = x + dx
                    yy = y + dy

                    if xx < 0 or xx >= n or yy < 0 or yy >= m:
                        # Out of boundary
                        continue

                    if matrix[x][y] < matrix[xx][yy]:
                        graph.setdefault(m * x + y, []).append(m * xx + yy)
                        # Count in-degree to find the sources for this graph.
                        in_degree[m * xx + yy] += 1

        # Now convert the problem into:
        # https://en.wikipedia.org/wiki/Longest_path_problem#Acyclic_graphs_and_critical_paths
        stack = []
        visited = [False] * total

        # Toposort graph.
        for i in xrange(total):
            if not visited[i]:
                toposort(stack, visited, i, graph)

        # Initialize paths. Set to 1 for entrances of the graph. Others set to +inf
        paths = [float('-inf')] * total
        for node, indgr in in_degree.iteritems():
            if indgr == 0:
                paths[node] = 1

        while stack:
            node = stack.pop()
            for neighbor in graph[node]:
                paths[neighbor] = max(paths[neighbor], paths[node] + 1)

        return max(paths)


def main():
    sol = Solution()

    matrix = [
        [9, 9, 4],
        [6, 6, 8],
        [2, 1, 1]
    ]
    assert sol.longestIncreasingPath(matrix) == 4

    matrix = [
        [3, 4, 5],
        [3, 2, 6],
        [2, 2, 1]
    ]
    assert sol.longestIncreasingPath(matrix) == 4

    assert sol.longestIncreasingPath([]) == 0
    assert sol.longestIncreasingPath([[1]]) == 1

    matrix = [
        [0,1,2,3,4,5,6,7,8,9],
        [19,18,17,16,15,14,13,12,11,10],
        [20,21,22,23,24,25,26,27,28,29],
        [39,38,37,36,35,34,33,32,31,30],
        [40,41,42,43,44,45,46,47,48,49],
        [59,58,57,56,55,54,53,52,51,50],
        [60,61,62,63,64,65,66,67,68,69],
        [79,78,77,76,75,74,73,72,71,70],
        [80,81,82,83,84,85,86,87,88,89],
        [99,98,97,96,95,94,93,92,91,90],
        [100,101,102,103,104,105,106,107,108,109],
        [119,118,117,116,115,114,113,112,111,110],
        [120,121,122,123,124,125,126,127,128,129],
        [139,138,137,136,135,134,133,132,131,130],
        [0,0,0,0,0,0,0,0,0,0]
    ]

    assert sol.longestIncreasingPath(matrix) == 140


if __name__ == '__main__':
    main()
