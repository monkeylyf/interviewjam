"""Move zeros
leetcode

Given an array nums, write a function to move all 0's to the end of it while
maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
"""

class Solution(object):
    def moveZeroes(self, nums):
        """Two pointer. One is to store next non-zero value another is cursor.

        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        idx = 0
        for i, val in enumerate(nums):
            if val != 0:
                nums[i], nums[idx] = nums[idx], nums[i]
                idx += 1


def main():
    sol = Solution()
    nums = [0, 1, 0, 3, 12]
    sol.moveZeroes(nums)
    assert nums == [1, 3, 12, 0, 0]


if __name__ == '__main__':
    main()
