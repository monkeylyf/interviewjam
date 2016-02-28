"""Sort colors
leetcode

Given an array with n objects colored red, white or blue, sort them so that
objects of the same color are adjacent, with the colors in the order red, white
and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white,
and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.
"""


class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        head = mid = 0
        tail = len(nums) - 1
        i = 0
        while i <= tail:
            num = nums[i]
            if num == 0:
                nums[i], nums[head] = nums[head], nums[i]
                head += 1
                i += 1
            elif num == 1:
                i += 1
            else:
                nums[i], nums[tail] = nums[tail], nums[i]
                tail -= 1


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
