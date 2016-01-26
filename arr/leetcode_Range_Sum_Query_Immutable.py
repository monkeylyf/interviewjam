"""Range sum query immutable
leetcode

Given an integer array nums, find the sum of the elements between indices i
and j (i <= j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
"""


class NumArray(object):

    def __init__(self, nums):
        """"""
        self.nums = nums
        for i in xrange(len(nums) - 1):
            self.nums[i + 1] += self.nums[i]

    def sumRange(self, start, end):
        if start == 0:
            return self.nums[end]
        else:
            return self.nums[end] - self.nums[start - 1]


def main():
    tree = NumArray([1, 3, 5])
    assert tree.sumRange(0, 2) == 9

    tree = NumArray([])


if __name__ == '__main__':
    main()
