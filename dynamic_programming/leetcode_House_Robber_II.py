"""House Robber II
leetcode

After robbing those houses on that street, the thief has found himself a new
place for his thievery so that he will not get too much attention. This time,
all houses at this place are arranged in a circle. That means the first house
is the neighbor of the last one. Meanwhile, the security system for these
houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each
house, determine the maximum amount of money you can rob tonight without
alerting the police.
"""


class Solution:

    """The idea is break this puzzle down to something we've solved.

    The tricky part of circle is its head is connected with tail. That
    being said, the head is taken, then tail can not be.
    Simply we break this down to two cases.
    I. Take the head, circle becomes an array[2:-1]
    II. Do not take the head, circle becomes an array[1:]
    """

    def rob(self, nums):
        if not nums:
            return 0
        if len(nums) <= 3:
            return max(nums)

        return max(self.rob_arr(nums[2:-1]) + nums[0], self.rob_arr(nums[1:]))

    def rob_arr(self, nums):
        """Code from leetcode_House_Robber.py"""
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        prev, cur = nums[0], max(nums[0:2])

        for i in nums[2:]:
            prev, cur = cur, max((prev + i), cur)

        return max(cur, prev)


def main():
    sol = Solution()
    arr = [1, 1, 1, 1]
    assert sol.rob(arr) == 2
    arr = [1, 2, 1, 0]
    assert sol.rob(arr) == 2


if __name__ == '__main__':
    main()
