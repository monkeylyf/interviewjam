# https://leetcode.com/problems/partition-array-into-disjoint-intervals/

from typing import List

class Solution:
    def partitionDisjoint(self, A: List[int]) -> int:
        n = len(A)
        right_min = [0] * n
        i = n - 1
        while i >= 0:
            if i == n - 1:
                right_min[i] = A[i]
            else:
                right_min[i] = min(right_min[i + 1], A[i])
            i -= 1

        i = 0
        cur_max = -float('inf')
        while i < n - 1:
            cur_max = max(cur_max, A[i])
            if cur_max <= right_min[i + 1]:
                return i + 1
            i += 1
        return i + 1


def main():
    sol = Solution()
    print(sol.partitionDisjoint([5, 0, 3, 8, 6]))
    print(sol.partitionDisjoint([1, 1, 1, 0, 6, 12]))


if __name__ == '__main__':
    main()
