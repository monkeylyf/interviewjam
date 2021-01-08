# https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

from collections import Counter


class Solution:
    def minSteps(self, s: str, t: str) -> int:
        a = Counter(s)
        b = Counter(t)
        common = 0
        for i, val in a.items():
            if i in b:
                common += min(val, b[i])
        return len(s) - common
