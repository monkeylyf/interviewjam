# https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times

class Solution:
    def containsPattern(self, arr: List[int], m: int, k: int) -> bool:
        n = len(arr)
        for i in range(n - m * k + 1):
            p = arr[i: i + m]
            if p * (k - 1) == arr[i + m : i + m * k]:
                return True
        return False
