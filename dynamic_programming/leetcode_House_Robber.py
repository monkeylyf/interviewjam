"""House Robber
leetcode

You are a professional robber planning to rob houses along a street. Each house
has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken into
on the same night.

Given a list of non-negative integers representing the amount of money of each
house, determine the maximum amount of money you can rob tonight without
alerting the police.
"""


class Solution:

    """DP.

    dp[i] = max(dp[i - 2] + arr[i], dp[i - 1])
    Yes you can use an array to represent dp states but in this case use two
    variables are good enough, just like fibonacci.
    """

    def rob(self, nums):
        """"""
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]

        prev, cur = nums[0], max(nums[0:2])

        for i in nums[2:]:
            prev, cur = cur, max((prev + i), cur)

        return max(cur, prev)


def main():
    nums = [1, 2, 3, 4, 5]
    sol = Solution()
    assert sol.rob(nums) == 9


if __name__ == '__main__':
    main()
