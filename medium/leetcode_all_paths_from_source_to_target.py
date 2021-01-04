# https://leetcode.com/problems/all-paths-from-source-to-target/

from typing import List


class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        paths = []
        self.rec(0, graph, [0], paths)
        return paths

    def rec(self, start: int, graph: List[List[int]], path: List[int], paths: List[List[int]]):
        if start == len(graph) - 1:
            paths.append(path[:])
            return

        for i in graph[start]:
            path.append(i)
            self.rec(i, graph, path, paths)
            path.pop()


def main():
    sol = Solution()
    print(sol.allPathsSourceTarget([[1, 2], [3], [3], []]))


if __name__ == '__main__':
    main()
