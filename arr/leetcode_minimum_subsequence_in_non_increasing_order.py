# https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order

class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        total = sum(nums)
        min_sum = total // 2
        nums.sort(reverse=True)
        i = 0
        acc = 0
        for (i, value) in enumerate(nums):
            acc += value
            if acc > min_sum:
                break
        return nums[:i + 1]
