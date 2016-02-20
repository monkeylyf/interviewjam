"""Wiggle Sort
leetcode

Given an unsorted array nums, reorder it in-place such that
nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is
[1, 6, 2, 5, 3, 4].
"""


class Solution(object):
    def wiggleSort(self, nums):
        """This is loose wiggle sort than wiggle sort II.

        if i is odd, nums[i] >= nums[i - 1], else swap
        if i is even, nums[i] <= nums[i - 1], else swap

        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        for i in xrange(1, len(nums)):
            if (i % 2 == 1) is not (nums[i] > nums[i - 1]):
                nums[i], nums[i - 1] = nums[i - 1], nums[i]


def main():
    sol = Solution()
    nums = [3, 6, 2, 1, 6, 4]
    sol.wiggleSort(nums)
    print nums


if __name__ == '__main__':
    main()
