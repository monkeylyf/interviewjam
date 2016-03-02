"""Minimum Window Substring
leetcode

Given a string S and a string T, find the minimum window in S which will
contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the
empty string "".

If there are multiple such windows, you are guaranteed that there will always
be only one unique minimum window in S.
"""


from collections import Counter


class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        char_freq = Counter(t)
        counter = len(t)
        i = 0
        j = 0
        substr = None
        while j < len(s):
            # Moving window right boundary
            char = s[j]
            if char_freq[char] > 0:
                counter -= 1
            char_freq[char] -= 1
            j += 1
            while counter == 0:
                # Update window min.
                if substr is None or j - i < len(substr):
                    substr = s[i:j]
                char = s[i]
                # Moving window left boundary
                if char_freq[char] == 0:
                    counter += 1
                char_freq[char] += 1
                i += 1

        return substr if substr is not None else ''


def main():
    sol = Solution()
    assert sol.minWindow('ADOBECODEBANC', 'ABC') == 'BANC'


if __name__ == '__main__':
    main()
