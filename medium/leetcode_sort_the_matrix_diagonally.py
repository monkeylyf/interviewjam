# https://leetcode.com/problems/sort-the-matrix-diagonally/

from typing import List

class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat:
            return []

        n = len(mat)
        m = len(mat[0])


        # Sort upper half with i = 0.
        i = 0
        for j in range(m):
            ii = i
            jj = j
            arr = []
            while ii < n and jj < m:
                arr.append(mat[ii][jj])
                ii += 1
                jj += 1
            arr.sort()
            index = 0
            ii = i
            jj = j
            while ii < n and jj < m:
                mat[ii][jj] = arr[index]
                ii += 1
                jj += 1
                index += 1

        # Sort the lower harf with j = 0.
        j = 0
        for i in range(1, n):
            ii = i
            jj = j
            arr = []
            while ii < n and jj < m:
                arr.append(mat[ii][jj])
                ii += 1
                jj += 1
            arr.sort()
            index = 0
            ii = i
            jj = j
            while ii < n and jj < m:
                mat[ii][jj] = arr[index]
                ii += 1
                jj += 1
                index += 1
        return mat
