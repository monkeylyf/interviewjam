# https://leetcode.com/problems/check-if-a-string-can-break-another-string/

class Solution:
    def checkIfCanBreak(self, s1: str, s2: str) -> bool:
        ss1 = sorted(s1)
        ss2 = sorted(s2)
        n = len(s1)
        i = 0
        no_less_than = True
        no_more_than = True
        while i < n:
            if no_less_than and ss1[i] < ss2[i]:
                no_less_than = False
            if no_more_than and ss1[i] > ss2[i]:
                no_more_than = False
            i += 1

        return no_less_than or no_more_than
