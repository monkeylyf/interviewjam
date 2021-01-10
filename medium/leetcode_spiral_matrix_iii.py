# https://leetcode.com/problems/spiral-matrix-iii/

from typing import List

class Solution:
    def spiralMatrixIII(self, R: int, C: int, r0: int, c0: int) -> List[List[int]]:
        res = [[r0, c0]]
        total = R * C

        directions = ((0, 1), (1, 0), (0, -1), (-1, 0))
        d = 0
        step = 1
        i = 0
        j = 2


        while total > len(res):
            dx, dy = directions[d]
            r0 += dx
            c0 += dy

            if 0 <= r0 and r0 < R and 0 <= c0 and c0 < C:
                res.append([r0, c0])

            i += 1
            if i == step:
                j -= 1
                if j == 0:
                    j = 2
                    step += 1

                d += 1
                d = d % 4
                i = 0

        return res


def main():
    sol = Solution()
    #print(sol.spiralMatrixIII(1, 4, 0, 0))
    print(sol.spiralMatrixIII(5, 6, 1, 4))


if __name__ == '__main__':
    main()
