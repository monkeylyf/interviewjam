# https://leetcode.com/problems/max-area-of-island/

from typing import List

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        n = len(grid)
        m = len(grid[0])
        directions = ((1, 0), (-1, 0), (0, -1), (0, 1))
        max_island = 0

        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    local_count = 0
                    queue = [(i, j)]
                    grid[i][j] = -1
                    while queue:
                        x, y = queue.pop()
                        local_count += 1
                        for dx, dy in directions:
                            aa = x + dx
                            bb = y + dy
                            if 0 <= aa and aa < n and 0 <= bb and bb < m and grid[aa][bb] == 1:
                                queue.append((aa, bb))
                                grid[aa][bb] = -1
                        max_island = max(max_island, local_count)

        return max_island


    def maxAreaOfIslandUnionAndFind(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0

        n = len(grid)
        m = len(grid[0])
        parents = list(range(n * m))
        sizes = [1] * (n * m)
        no_island = True
        directions = ((1, 0), (-1, 0), (0, -1), (0, 1))

        for i in range(n):
            for j in range(m):
                if grid[i][j] != 1:
                    continue
                if no_island:
                    no_island = False
                a = i * m + j
                for dx, dy in directions:
                    xx = i + dx
                    yy = j + dy
                    if 0 <= xx and xx < n and 0 <= yy and yy < m and grid[xx][yy] == 1:
                        b = xx * m + yy
                        self.union(parents, sizes, a, b)
        return 0 if no_island else max(sizes)

    def union(self, parents, sizes, i, j):
        ii = self.find(parents, i)
        jj = self.find(parents, j)
        if ii == jj:
            return

        if sizes[ii] < sizes[jj]:
            parents[i] = jj
            sizes[jj] += sizes[ii]
            sizes[ii] = 0
        else:
            parents[j] = ii
            sizes[ii] += sizes[jj]
            sizes[jj] = 0

    def find(self, parents, i):
        if i != parents[i]:
            parents[i] = parents[parents[i]]
            i = parents[i]
        return i


def main():
    island = [
            [0,0,1,0,0,0,0,1,0,0,0,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,1,1,0,1,0,0,0,0,0,0,0,0],
            [0,1,0,0,1,1,0,0,1,0,1,0,0],
            [0,1,0,0,1,1,0,0,1,1,1,0,0],
            [0,0,0,0,0,0,0,0,0,0,1,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    sol = Solution()
    #print(sol.maxAreaOfIsland(island))
    #print(sol.maxAreaOfIsland([[0]]))
    #print(sol.maxAreaOfIsland([[1, 1, 1]]))

    island = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
    print(sol.maxAreaOfIsland(island))


if __name__ == '__main__':
    main()
