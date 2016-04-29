"""Count of range sum
leetcode

Given an integer array nums, return the number of range sums that lie in
[lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between
indices i and j (i <= j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are:
-2, -1, 2.
"""

import math


class SegmentTree(object):

    """"""

    def __init__(self, lower, upper):
        """"""
        self._heap = None
        self._size = None
        self._lower = lower
        self._upper = upper
        self._count = 0

    @property
    def count(self):
        """"""
        return self._count

    def build(self, nums):
        """"""
        n = len(nums)
        size = self._heap_size(n)
        self._heap = [None] * size
        self._build(nums, 0, n - 1, 0)

    def _build(self, nums, start, end, idx):
        """"""
        if start == end:
            num = nums[start]
        else:
            mid = (end - start) / 2 + start
            left = self._build(nums, start, mid, 2 * idx + 1)
            right = self._build(nums, mid + 1, end, 2 * idx + 2)
            num = left + right

        self._heap[idx] = num
        if self._lower <= num and num <= self._upper:
            self._count += 1

        return num

    def _heap_size(self, n):
        """Return minimum heap size required.

        :param n: int
        :param return: int
        """
        power = int(math.log(n) / math.log(2)) + 1
        return 2 * (2 ** power) - 1


class Solution(object):
    def countRangeSum(self, nums, lower, upper):
        """
        :type nums: List[int]
        :type lower: int
        :type upper: int
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        else:
            seg_tree = SegmentTree(lower, upper)
            seg_tree.build(nums)
            print seg_tree._heap
            return seg_tree.count



def main():
    sol = Solution()
    #assert sol.countRangeSum([], -2, 2) == 0
    #assert sol.countRangeSum([-2, 5, -1], -2, 2) == 3
    assert sol.countRangeSum([0, -3, -3, 1, 1, 2], 3, 5) == 1


if __name__ == '__main__':
    main()
