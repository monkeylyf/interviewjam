"""Product of array except self
leetcode

Given an array of n integers where n > 1, nums, return an array output such that
output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].
"""


class Solution(object):
    def productExceptSelf(self, nums):
        """Three cases.

        I. More than one '0' in nums. must be at least on 0 for others except
           self. The results must be all zeros
        II. One '0' in nums. The '0' should be mapped to product of all others
            and others should be mapped to 0
        III. No zeros. Get the product of all first, and results[i] = product / nums[i]

        :type nums: List[int]
        :rtype: List[int]
        """
        zero_counts = nums.count(0)
        if zero_counts > 1:
            return [0] * len(nums)
        elif zero_counts == 1:
            product = reduce(lambda x, y: x * y if y != 0 else x, nums)
            return [product if val == 0 else 0 for val in nums]
        else:
            product = reduce(lambda x, y: x * y, nums)
            return [product / val for val in nums]


def main():
    sol = Solution()
    assert sol.productExceptSelf([0, 0]) == [0, 0]
    assert sol.productExceptSelf([1, 2, 3, 0]) == [0, 0, 0, 6]
    assert sol.productExceptSelf([1, 2, 3, 4]) == [24, 12, 8, 6]


if __name__ == '__main__':
    main()
