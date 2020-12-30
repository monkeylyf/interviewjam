# https://leetcode.com/problems/consecutive-characters/submissions/

class Solution:
    def maxPower(self, s: str) -> int:
        prev = None
        count = 0
        longest = -float('inf')
        for c in s:
            if prev is None or prev == c:
                count += 1
            else:
                count = 1
            longest = max(longest, count)
            prev = c
        return longest
