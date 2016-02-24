"""Find the duplicate number
leetcode

Given an array nums containing n + 1 integers where each integer is between 1
and n (inclusive), prove that at least one duplicate number must exist. Assume
that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
"""


class Solution(object):
    def findDuplicate(self, nums):
        """Since the element range will fit in the arr index range, and all
        value are positive, we can use the convert the value from positive to
        negative and negative value indicates that this index as a elemeng is
        seen already.

        Usually then asked for space complexity O(1), you need to modify the arr
        or matrix and at the same time loose no entropy of it.

        :type nums: List[int]
        :rtype: int
        """
        for val in nums:
            val = abs(val)
            if nums[val - 1] < 0:
                return val
            else:
                nums[val - 1] = -nums[val - 1]

        raise ValueError


def main():
    sol = Solution()
    assert sol.findDuplicate([2, 1, 1]) == 1
    assert sol.findDuplicate([2, 1, 2]) == 2
    assert sol.findDuplicate([1, 1]) == 1


if __name__ == '__main__':
    main()
