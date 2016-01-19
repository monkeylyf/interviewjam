"""Longest increasing subsequence
leetcode

Given an unsorted array of integers, find the length of longest increasing
subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length
is 4. Note that there may be more than one LIS combination, it is only necessary
for you to return the length.

Your algorithm should run in O(n2) complexity.
"""


class Solution(object):
    def lengthOfLIS(self, nums):
        """Paradigm dp problem.

        dp[j] = max(dp[i] for i in xrange(j) if nums[i] < nums[j]) + 1
        The crux of it is you cannot simply return dp[-1] because the qualified
        sequence might not end with last digit so return max(dp).

        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        if n <= 1:
            return n

        max_len = 0

        dp = [0] * n
        for i, num in enumerate(nums):
            if i == 0:
                dp[0] = 1
                max_len = 1
            else:
                prev_max = 0
                for j in xrange(i):
                    if nums[j] < num:
                        prev_max = max(prev_max, dp[j])
                dp[i] = prev_max + 1
            max_len = max(max_len, dp[i])

        return max_len


def main():
    sol = Solution()
    assert sol.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]) == 4


if __name__ == '__main__':
    main()
