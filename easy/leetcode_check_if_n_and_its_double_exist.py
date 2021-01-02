# https://leetcode.com/problems/check-if-n-and-its-double-exist/

class Solution:
    def maxRepeating(self, sequence: str, word: str) -> int:
        n = len(sequence)
        m = len(word)
        max_repeat = 0
        for i in range(n - m + 1):
            local_max = 1
            while sequence[i:i + local_max * m] == word * local_max:
                local_max += 1
            max_repeat = max(max_repeat, local_max - 1)

        return max_repeat
