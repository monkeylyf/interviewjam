# https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

from typing import List

class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        graph = [[] for _ in range(n)]
        for f, t in edges:
            graph[t].append(f)

        nodes = []
        for i, to in enumerate(graph):
            if not to:
                nodes.append(i)
        return nodes


def main():
    sol = Solution()
    print(sol.findSmallestSetOfVertices(6, [[0,1],[0,2],[2,5],[3,4],[4,2]]))


if __name__ == '__main__':
    main()
