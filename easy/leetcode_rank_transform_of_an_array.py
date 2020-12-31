# https://leetcode.com/problems/rank-transform-of-an-array/

class Solution:

    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        a = sorted(arr)
        rank = 1
        seen = {}
        for i in a:
            r = seen.get(i)
            if r is None:
                seen[i] = rank
                rank += 1
        return [seen[i] for i in arr]



    def arrayRankTransformNotSoGood(self, arr: List[int]) -> List[int]:
        a = [[val, i, 1] for (i, val) in enumerate(arr)]
        a.sort()
        rank = 0
        n = len(a)
        i = 0
        ranks = [None] * n
        while i < n:
            if i == 0 or a[i][0] != a[i - 1][0]:
                rank += 1
            a[i][2] = rank
            ranks[a[i][1]] = rank
            i += 1
        return ranks
