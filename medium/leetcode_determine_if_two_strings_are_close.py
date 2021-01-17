# https://leetcode.com/problems/determine-if-two-strings-are-close/

from collections import Counter

class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        if len(word1) != len(word2):
            return False
        c1 = Counter(word1)
        c2 = Counter(word2)
        if len(c1) != len(c2):
            return False

        k1 = list(c1.keys())
        k2 = list(c2.keys())
        k1.sort()
        k2.sort()
        if k1 != k2:
            return False

        v1 = list(c1.values())
        v2 = list(c2.values())
        v1.sort()
        v2.sort()
        return v1 == v2
