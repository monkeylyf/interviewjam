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
    def lengthOfLIS(self, arr):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not arr:
            return 0
        max_seq_len = 1
        n = len(arr)
        dp = [1] * n # A number itself is a sequence, with length 1.
        for i in xrange(1, n):
            for j in xrange(i):
                if arr[i] > arr[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
            max_seq_len = max(max_seq_len, dp[i])
        return max_seq_len


def main():
    sol = Solution()
    assert sol.lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]) == 4


if __name__ == '__main__':
    main()
