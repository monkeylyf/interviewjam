# https://leetcode.com/problems/special-positions-in-a-binary-matrix/

from typing import List

class Solution:
    def numSpecial(self, mat: List[List[int]]) -> int:
        n = len(mat)
        row_count = [0] * n
        m = len(mat[0])
        col_count = [0] * m
        
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 1:
                    row_count[i] += 1
                    col_count[j] += 1

        total = 0 
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 1 and row_count[i] == 1 and col_count[j] == 1:
                        total += 1
        return total            


def main():
    sol = Solution()
    print(sol.numSpecial([[1,0,0], [0,0,1], [1,0,0]]))
    print(sol.numSpecial([[1,0,0], [0,1,0], [0,0,1]]))


if __name__ == '__main__':
    main()
