# https://leetcode.com/problems/find-the-highest-altitude/

from typing import List

class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        max_height = 0
        acc = 0
        for g in gain:
            acc += g
            if acc > max_height:
                max_height = acc

        return max_height
