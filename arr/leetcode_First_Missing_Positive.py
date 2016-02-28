"""First missing positive
leetcode

Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
"""


class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        i = 0
        while i < len(nums):
            idx = nums[i] - 1
            while 0 <= idx and idx < n and \
                  nums[i] != nums[idx]:
                nums[idx], nums[i] = nums[i], nums[idx]
                idx = nums[i] - 1
            i += 1
        i = 0
        while i < n and nums[i] - 1 == i:
            i += 1
        return i + 1


def main():
    sol = Solution()
    assert sol.firstMissingPositive([1, 1]) == 2


if __name__ == '__main__':
    main()
