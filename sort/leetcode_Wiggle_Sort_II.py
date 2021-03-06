"""Wiggle sort II
leetcode

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
"""

class Solution(object):
    def wiggleSort(self, nums):
        """I don't know how to do in place.

        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        def idx(n):
            for i in xrange(1, len(nums), 2):
                yield i
            for i in xrange(0, len(nums), 2):
                yield i

        ns = sorted(nums)
        j = len(nums) - 1
        for i in idx(len(nums)):
            nums[i] = ns[j]
            j -= 1


def is_wiggle(nums):
    n = len(nums)
    if n < 2:
        return True

    i = 1

    while i < n:
        if nums[i - 1] >= nums[i] or (i + 1 < n and nums[i] <= nums[i + 1]):
            return False
        i += 2
    return True



def main():
    sol = Solution()

    nums = [1, 5, 1, 1, 6, 4]
    sol.wiggleSort(nums)
    assert is_wiggle(nums)

    nums = [1]
    sol.wiggleSort(nums)
    assert is_wiggle(nums)

    nums = [2, 1]
    sol.wiggleSort(nums)
    assert is_wiggle(nums)

    nums = [1, 5, 1, 1, 6]
    sol.wiggleSort(nums)
    assert is_wiggle(nums)

    nums = [1, 2, 2, 1, 2, 1, 1, 1, 1, 2, 2, 2]
    sol.wiggleSort(nums)
    assert is_wiggle(nums)

    nums = [1, 2, 2, 3, 1, 3]
    sol.wiggleSort(nums)
    assert is_wiggle(nums)

    nums = [4, 5, 5, 6]
    sol.wiggleSort(nums)
    assert is_wiggle(nums)


if __name__ == '__main__':
    main()
