# https://leetcode.com/problems/sum-of-unique-elements/

from collections import Counter

class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        return sum(i for i, val in Counter(nums).items() if val == 1)
