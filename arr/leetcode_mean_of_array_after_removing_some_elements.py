# https://leetcode.com/problems/mean-of-array-after-removing-some-elements

class Solution:
    def trimMean(self, arr: List[int]) -> float:
        arr.sort()
        n = len(arr)
        start = n // 20
        end = n - start

        return sum(arr[start: end]) / (n- start * 2)
