# https://leetcode.com/problems/image-overlap/

from typing import List


class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        # TODO: room for better time complexity.
        if not img1 or not img2:
            return 0

        n = len(img1)
        max_overlap = 0
        for dx in range(-n + 1, n):
            for dy in range(-n + 1, n):
                local = 0
                for i in range(n):
                    for j in range(n):
                        val = img1[i][j]
                        if val == 0:
                            continue
                        ii = i + dx
                        jj = j + dy
                        if 0 <= ii and ii < n and 0 <= jj and jj < n and val == img2[ii][jj]:
                            local += 1
                if local > max_overlap:
                    max_overlap = local

        return max_overlap


def main():
    sol = Solution()
    img1 = [[1,1,0],[0,1,0],[0,1,0]]
    img2 = [[0,0,0],[0,1,1],[0,0,1]]
    print(sol.largestOverlap(img1, img2))


if __name__ == '__main__':
    main()
