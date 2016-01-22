"""Single number III
leetcode

Given an array of numbers nums, in which exactly two elements appear only once
and all the other elements appear exactly twice. Find the two elements that
appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
Note:
The order of the result is not important. So in the above example, [5, 3] is
also correct.
Your algorithm should run in linear runtime complexity. Could you implement it
using only constant space complexity?
"""


class Solution(object):
    def singleNumber(self, nums):
        """
        001
        010
        001
        011
        010
        101

        110 -> second bit from right to left is the distinguisher, which is 10
        By compairing num & mask(10), two groups will be formed:
        1. distinct number a and other numbers that appear twice
        2. distinct number b and other numbers that appear twice

        Do xor all for each of the group will render you those two distinct
        numbers, repectively

        :type nums: List[int]
        :rtype: List[int]
        """
        xor = reduce(lambda x, y : x ^ y, nums)
        mask = 1
        while xor & mask == 0:
            mask = mask << 1

        a = 0
        b = 0
        for num in nums:
            if num & mask:
                a ^= num
            else:
                b ^= num
        return [a, b]


def main():
    sol = Solution()
    assert sol.singleNumber([1, 2, 1, 3, 2, 5]) == [3, 5]


if __name__ == '__main__':
    main()
