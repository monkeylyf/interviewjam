# https://leetcode.com/problems/sort-array-by-increasing-frequency

from collections import Counter

class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        c = Counter(nums)
        # Reversed the value to leverage the tuptle sort by desc when frequencies are same.
        a = sorted(((freq, -i) for (i, freq) in c.items()))
        res = []

        for freq, val in a:
            # Reverse the value back.
            res.extend([-val] * freq)
        return res
