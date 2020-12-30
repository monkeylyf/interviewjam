# https://leetcode.com/problems/three-consecutive-odds

from typing import List

class Solution:
    def threeConsecutiveOdds(self, arr: List[int]) -> bool:
        consecutive_odds = 0

        for i in arr:
            if i % 2 == 1:
                consecutive_odds += 1
                if consecutive_odds >= 3:
                    return True
            else:
                consecutive_odds = 0
        return False
