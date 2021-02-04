# https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

from typing import List


class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        if not A or not B:
            return 0

        n = len(A)
        mapping_a = [set() for _ in range(6)]
        for i, val in enumerate(A):
            mapping_a[val - 1].add(i)
        mapping_b = [set() for _ in range(6)]
        for i, val in enumerate(B):
            mapping_b[val - 1].add(i)
        min_rotation = float('inf')
        for i in range(6):
            aa = mapping_a[i]
            bb = mapping_b[i]
            if len(aa) + len(bb) >= n and len(aa | bb) == n:
                aaa = len(aa - bb)
                bbb = len(bb - aa)
                min_rotation = min(aaa, bbb, min_rotation)
        return -1 if min_rotation == float('inf') else min_rotation


def main():
    sol = Solution()
    A = [2,1,2,4,2,2]
    B = [5,2,6,2,3,2]
    print(sol.minDominoRotations(A, B))
    A = [3,5,1,2,3]
    B = [3,6,3,3,4]
    #print(sol.minDominoRotations(A, B))
    A = [1,1,1,1,1,1,1,1]
    B = [1,1,1,1,1,1,1,1]
    #print(sol.minDominoRotations(A, B))


if __name__ == '__main__':
    main()
