# https://leetcode.com/problems/find-lucky-integer-in-an-array

from collections import Counter

class Solution:
    def findLucky(self, arr: List[int]) -> int:
        c = Counter(arr)
        luck = -1
        for val, freq in c.items():
            if val == freq:
                if luck == -1 or val > luck:
                    luck = val
        
        return luck
