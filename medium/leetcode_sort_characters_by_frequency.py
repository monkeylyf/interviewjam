# https://leetcode.com/problems/sort-characters-by-frequency/submissions/
from collections import Counter

class Solution:
    def frequencySort(self, s: str) -> str:
        if not s:
            return ''

        c = Counter(s)

        by_freq = [(freq, i) for i, freq in c.items()]
        by_freq.sort(reverse=True)
        return ''.join(i * freq for freq, i in by_freq)
