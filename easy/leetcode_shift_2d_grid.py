# https://leetcode.com/problems/shift-2d-grid/

from typing import List

class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        if not grid:
            return grid

        n = len(grid)
        m = len(grid[0])
        k = k % (n * m)
        flattened = []
        for row in grid:
            flattened.extend(row)
        flattened = flattened[-k:] + flattened[:-k]
        rotated = [None] * n
        for i in range(n):
            rotated[i] = flattened[i * m: i * m + m]
        return rotated



def main():
    sol = Solution()
    print(sol.shiftGrid([[1,2,3],[4,5,6],[7,8,9]], 1))
    print(sol.shiftGrid([[1],[2],[3],[4],[7],[6],[5]], 23))


if __name__ == '__main__':
    main()
