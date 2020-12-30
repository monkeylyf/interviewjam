# https://leetcode.com/problems/remove-palindromic-subsequences/

class Solution:
    def removePalindromeSub(self, s: str) -> int:
        if not s:
            return 0
        elif self.isPalindrom(s):
            return 1
        else:
            # Do not overthink cuz this is an easy.
            # One step to remove a palindromic subsequence meaning it is 
            # guaranteed to remove all a's and then remove all b's to
            # become an empty string.
            return 2
    
    def isPalindrom(self, s: str) -> bool:
        start = 0
        end = len(s) - 1
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1
        return True
