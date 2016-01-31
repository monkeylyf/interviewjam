"""Burst balloons
leetcode

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
on it represented by array nums. You are asked to burst all the balloons. If the
you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here
left and right are adjacent indices of i. After the burst, the left and right
then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can
    not burst them.
(2) 0 <= n <= 500, 0 <= nums[i] <= 100

Example:

Given [3, 1, 5, 8]

Return 167

nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
"""


class Solution(object):
    def maxCoins(self, nums):
        """http://algobox.org/burst-balloons/

        The idea is DP. However dp states won't connect when building dp matrix
        if somehow dp[i] is the next balloons to burst, because after bursting
        nums[i], nums[i - 1] and nums[i + 1] will be adjancent.
        Thinking the opposite, if dp[i] means nums[i] is the last to burst, dp
        relation stands.

        :type nums: List[int]
        :rtype: int
        """
        # Filter out 0. 0s won't be picked til the end.
        nums = [1] + [i for i in nums if i > 0] + [1]
        n = len(nums)
        # dp[i][j] represents the max coins for nums[i:j]
        dp = [[0 for _ in xrange(n)] for _ in xrange(n)]

        for span in xrange(2, n):
            for left in xrange(0, n - span):
                right = left + span
                for i in xrange(left + 1, right):
                    dp[left][right] = max(
                        dp[left][right],
                        nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right])

        return dp[0][-1]


def main():
    sol = Solution()
    assert sol.maxCoins([3, 1, 5, 8]) == 167
    assert sol.maxCoins([9, 76, 64, 21]) == 116718


if __name__ == '__main__':
    main()
