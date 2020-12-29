# https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix

class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        a = sorted((mat[i].count(1), i) for i in range(len(mat)))
        return [r[1] for r in a][:k]
