# https://leetcode.com/problems/maximal-network-rank/

class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        if not roads:
            return 0

        max_conn = 0
        mapping = [0] * n
        r = set((i, j) for i, j in roads)
        for a, b in roads:
            mapping[a] += 1
            mapping[b] += 1
        for i in range(n):
            for j in range(i + 1, n):
                c = mapping[i] + mapping[j]
                if (i, j) in r or (j, i) in r:
                    c -= 1
                if c > max_conn:
                    max_conn = c

        return max_conn
