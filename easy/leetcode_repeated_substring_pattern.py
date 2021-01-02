# https://leetcode.com/problems/repeated-substring-pattern

class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        # Assume pattern p' exists then s is consisted of at least two p's
        # for s consistant of n p's, where n >= 2
        # - remove the first char of n p's leaves (n - 1) p's
        # - remove the last char ofn n p's leaves (n - 1) p's
        # - concatenated two into <? (2n - 2) p's ?>
        # string s, as n p's must be in this concatenated string since
        # 2n - 2 > n
        # On the other hand, for an non-pattern string, as itself is a pattern
        # that repeats only once, s won't appear in <??>
        if not s:
            return False

        return s in (s + s)[1:-1]

