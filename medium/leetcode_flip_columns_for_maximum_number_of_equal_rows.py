# https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/

from typing import List

from collections import Counter


class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        if not matrix:
            return 0
        c = Counter(int(''.join(map(str, a)), 2) for a in matrix)
        n = len(matrix[0])
        mask = (1 << n) - 1
        max_equal = 0
        for i, freq in c.items():
            counterpart_freq = c.get(mask ^ i, 0)
            local_max = counterpart_freq + freq
            if local_max > max_equal:
                max_equal = local_max
        return max_equal


def main():
    sol = Solution()
    matrix = [[0,0,0],[0,0,1],[1,1,0]]
    print(sol.maxEqualRowsAfterFlips(matrix) == 2)
    matrix = [[0,1],[1,0]]
    print(sol.maxEqualRowsAfterFlips(matrix) == 2)
    matrix = [[0,1],[1,1]]
    print(sol.maxEqualRowsAfterFlips(matrix) == 1)


if __name__ == '__main__':
    main()
