# https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/

from heapq import heappushpop, heappush
from typing import List


class Solution:
    def kthLargestValue(self, matrix: List[List[int]], k: int) -> int:
        if not matrix:
            return 0

        n = len(matrix)
        m = len(matrix[0])
        prev = [0] * m
        heap = []
        for i in range(m):
            if i == 0:
                prev[i] = matrix[0][i]
            else:
                prev[i] = matrix[0][i] ^ prev[i - 1]
            if len(heap) < k:
                heappush(heap, prev[i])
            else:
                heappushpop(heap, prev[i])

        dp = [0] * m
        i = 1
        while i < n:
            row = matrix[i]
            for j in range(m):
                if j == 0:
                    dp[j] = row[j] ^ prev[j]
                else:
                    dp[j] = row[j] ^ prev[j] ^ prev[j - 1] ^ dp[j - 1]
                if len(heap) < k:
                    heappush(heap, dp[j])
                else:
                    heappushpop(heap, dp[j])
            prev = dp
            dp = [0] * m
            i += 1
        return heap[0]
