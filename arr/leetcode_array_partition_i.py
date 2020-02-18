"""https://leetcode.com/problems/array-partition-i/submissions/"""

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        return sum(nums[0:len(nums):2])
