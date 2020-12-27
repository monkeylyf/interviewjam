# https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays

from collections import Counter

class Solution:
    def canBeEqual(self, target: List[int], arr: List[int]) -> bool:
        # As long as two list are content-wise equal, they can already be converted
        # to each other by reversing the subarray in infinite times.
        if len(target) != len(arr):
            return False
        else:
            return Counter(target) == Counter(arr)
