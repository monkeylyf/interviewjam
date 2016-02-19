"""Word Pattern II
leetcode

ven a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.
"""


class Solution(object):
    def wordPatternMatch(self, pattern, string):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        char_pattern = [None] * 26
        used_pattern = set()
        return self.match(0, pattern, 0, string, char_pattern, used_pattern)

    def match(self, i, pattern, j, string, char_pattern, used_pattern):
        if i == len(pattern):
            # When pattern is all checked, return whether string is fully matched.
            return j == len(string)
        else:
            char = pattern[i]
            idx = ord(char) - 97 # ord('a')
            mapped_pat = char_pattern[idx]
            if mapped_pat is None:
                # char has not been mapped to any string yet.
                # Be careful about the range.
                for k in xrange(j + 1, len(string) - (len(pattern) - i) + 2):
                    pat = string[j:k]
                    if pat in used_pattern:
                        # A pattern cannot be used for two different char.
                        continue
                    char_pattern[idx] = pat
                    used_pattern.add(pat)
                    if self.match(i + 1, pattern, k, string, char_pattern, used_pattern):
                        return True
                    char_pattern[idx] = None
                    used_pattern.remove(pat)
                return False
            else:
                pat_len = len(mapped_pat)
                if string[j:j + pat_len] != mapped_pat:
                    return False
                else:
                    return self.match(i + 1, pattern, j + pat_len, string, char_pattern, used_pattern)


def main():
    sol = Solution()
    assert sol.wordPatternMatch('abab', 'redblueredblue')
    assert sol.wordPatternMatch('abab', 'abab')
    assert sol.wordPatternMatch('aaaa', 'asdasdasdasd')
    assert not sol.wordPatternMatch('aabb', 'xyzabcxzyabc')
    assert not sol.wordPatternMatch('ab', 'aa')


if __name__ == '__main__':
    main()
