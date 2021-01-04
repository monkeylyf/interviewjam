# https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points


class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        x = [i[0] for i in points]
        x.sort()
        max_val = x[1] - x[0]
        for i in range(2, len(points)):
            max_val = max(max_val, x[i] - x[i - 1])
        return max_val
