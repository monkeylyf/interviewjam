"""Missing number
leetcode

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find
the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it
using only constant extra space complexity?
"""

class Solution(object):
    def missingNumber(self, nums):
        """Find and return the missing number.

        The idea is swapping the number to the index that nums[i] == i.
        1. It works for all numbers but one: n. Because given [0, n] there
        are n + 1 number and array will have length n so largest index is n -1.
        Set a special flag for number n.
        2. No need to worried about duplicate numbers because it's guaranteed
        all numbers are distinct. The problem of having dups are it will cause
        infinite loop, e.g., [0, 1, 1]

        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        return n * (n + 1) / 2 - sum(nums)

    def missingNumber(self, nums):
        n = len(nums)
        i = 0
        while i < len(nums):
            val = nums[i]
            if val == n or val == i:
                # n is a outlier or it's already in the right position.
                i += 1
            else:
                # Swap but idx remains the same.
                nums[i], nums[val] = nums[val], nums[i]

        i = 0
        while i < n and nums[i] == i:
            i += 1
        return i


def main():
    sol = Solution()
    assert sol.missingNumber([2, 0]) == 1
    assert sol.missingNumber([0, 1, 3]) == 2
    assert sol.missingNumber([1]) == 0
    assert sol.missingNumber([1, 2]) == 0
    assert sol.missingNumber([0, 2, 3, 4]) == 1


if __name__ == '__main__':
    main()
