"""Word pattern
leetcode


Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter
in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
"""


class Solution(object):
    def wordPattern(self, pattern, string):
        """
        :type pattern: str
        :type string: str
        :rtype: bool
        """
        strings = string.split()
        if len(pattern) != len(strings):
            return False
        # A string cannot be mapped to more than one different char.
        used = set()
        char_pat = [None] * 26

        for i, char in enumerate(pattern):
            idx = ord(char) - 97
            pat = char_pat[idx]
            word = strings[i]
            if pat is None:
                if word in used:
                    return False
                else:
                    char_pat[idx] = word
                    used.add(word)
            elif char_pat[idx] != strings[i]:
                return False
            else:
                pass
        return True


def main():
    sol = Solution()
    assert sol.wordPattern('abba', 'dog cat cat dog')


if __name__ == '__main__':
    main()
