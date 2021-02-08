# https://leetcode.com/problems/number-of-provinces/

from typing import List

class Solution:
    def findCircleNumUnionFind(self, isConnected: List[List[int]]) -> int:
        def find(node):
            if circles[node] == node:
                return node
            root = find(circles[node])
            circles[node] = root
            return root

        n = len(isConnected)
        circles = list(range(n))
        num = n
        for i in range(n):
            for j in range(i, n):
                if i != j and M[i][j] == 1 and find(i) != find(j):
                    circles[find(i)] = find(j)

        return sum([1 for k, v in enumerate(circles) if k == v])

    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        if not isConnected:
            return 0

        n = len(isConnected)
        count = 0
        visited = [False] * n
        v = 0
        while v < n:
            for i, is_visited in enumerate(visited):
                if not is_visited:
                    count += 1
                    q = [i]
                    while q:
                        city = q.pop()
                        visited[city] = True
                        v += 1
                        for j, is_connected in enumerate(isConnected[city]):
                            if i != j and is_connected == 1 and not visited[j]:
                                q.append(j)
        return count


def main():
    sol = Solution()
    isConnected = [[1,1,0],[1,1,0],[0,0,1]]
    print(sol.findCircleNum(isConnected) == 2)
    isConnected = [[1,0,0],[0,1,0],[0,0,1]]
    print(sol.findCircleNum(isConnected) == 3)


if __name__ == '__main__':
    main()
