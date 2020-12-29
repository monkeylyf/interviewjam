# https://leetcode.com/problems/find-the-distance-value-between-two-arrays

class Solution:
    def findTheDistanceValue(self, arr1: List[int], arr2: List[int], d: int) -> int:
        total = 0

        for a in arr1:
            if all(abs(a - i) > d for i in arr2):
                total += 1

        return total
