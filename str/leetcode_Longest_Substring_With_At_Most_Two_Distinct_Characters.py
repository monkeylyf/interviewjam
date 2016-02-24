"""Longest substring with at most two distinct characters
leetcode

Given a string, find the length of the longest substring T that contains at
most 2 distinct characters.

For example, Given s = "eceba",

T is "ece" which its length is 3.
"""


class Solution(object):
    def lengthOfLongestSubstringTwoDistinct(self, s):
        """Two pointer + index mapping.

        The index mapping keeps track the largest index seen for spefici char.
        When adding a new index and there are three, a local max substring is
        found and update the global one.
        The question is how to reset the starting index, that including the new
        char, there are only two distinct char between start and ending index.
        The question asks for two distinct char so it's easy to use if else.
        What if the question asks for k distinct char? What would you do?

        :type s: str
        :rtype: int
        """
        max_len = float('-inf')
        seen = {}
        i = 0
        j = 0
        get_keys = seen.keys
        pop = seen.pop
        while i < len(s) and j < len(s):
            char = s[j]
            if len(seen) == 2 and char not in seen:
                max_len = max(max_len, j - i)
                a, b = get_keys()
                removed_char = a if s[j - 1] == b else b
                i = seen[removed_char] + 1
                pop(removed_char)
            seen[char] = j
            j += 1

        return max(max_len, j - i)


def main():
    sol = Solution()
    assert sol.lengthOfLongestSubstringTwoDistinct('eceba') == 3
    assert sol.lengthOfLongestSubstringTwoDistinct('aaaaaaaab') == 9
    assert sol.lengthOfLongestSubstringTwoDistinct('cdaba') == 3


if __name__ == '__main__':
    main()
