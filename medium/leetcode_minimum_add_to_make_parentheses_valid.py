# https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

class Solution:
    def minAddToMakeValid(self, S: str) -> int:
        left = 0
        for c in S:
            if c == '(':
                left += 1
            elif left > 0:
                left -= 1
        right = 0
        for c in reversed(list(S)):
            if c == ')':
                right += 1
            elif right > 0:
                right -= 1

        return left + right
