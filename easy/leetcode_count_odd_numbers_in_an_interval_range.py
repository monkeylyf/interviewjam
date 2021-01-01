# https://leetcode.com/problems/count-odd-numbers-in-an-interval-range

class Solution:
    def countOdds(self, low: int, high: int) -> int:
        if low % 2 == 1:
            return 1 + (high - low) // 2
        else:
            return (high - low + 1) // 2
