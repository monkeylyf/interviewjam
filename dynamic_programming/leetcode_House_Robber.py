"""leetcode_House_Robber.py

https://leetcode.com/problems/house-robber/
"""


class Solution:

    """DP.

    dp[i] = max(dp[i - 2] + arr[i], dp[i - 1])
    Yes you can use an array to represent dp states but in this case use two
    variables are good enought, just like fibonacci.
    """

    def rob(self, nums):
        """"""
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        prev, cur = nums[0], nums[0:2]

        for i in nums[2:]:
            prev, cur = cur, max((prev + i), cur)

        return max(cur, prev)


def main():
    nums = [1, 2, 3, 4, 5]
    sol = Solution()
    print sol.rob(nums)


if __name__ == '__main__':
    main()
