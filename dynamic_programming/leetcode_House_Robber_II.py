"""leetcode_House_Robber_II

https://leetcode.com/problems/house-robber-ii/
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
    #print sol.rob(arr)
    arr = [1, 2, 1, 0]
    print sol.rob(arr)


if __name__ == '__main__':
    main()
