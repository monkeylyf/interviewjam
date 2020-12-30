# https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum

class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        acc = 0
        min_val = -float('inf')
        for i in nums:
            acc += i
            min_val = max(min_val, 1 - acc)
        return max(min_val, 1)  # Start value must be positive as well.
