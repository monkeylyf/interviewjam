# https://leetcode.com/problems/largest-substring-between-two-equal-characters/

class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
            mapping = {}
            max_length = -1
            for (i, c) in enumerate(s):
                start = mapping.get(c)
                if start is None:
                    mapping[c] = i
                else:
                    max_length = max(max_length, i - start - 1)
            return max_length
