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

        c_to_str = {}
        str_to_c = {}
        for i in xrange(len(pattern)):
            c = pattern[i]
            string = strings[i]

            mapped_str = c_to_str.get(c)
            mapped_c = str_to_c.get(string)

            if mapped_c is None and mapped_str is None:
                # Create bijection.
                c_to_str[c] = string
                str_to_c[string] = c
            elif mapped_c is not None and mapped_str is not None:
                if mapped_c != c or mapped_str != string:
                    return False
            else:
                return False
        return True


def main():
    sol = Solution()
    assert sol.wordPattern('abba', 'dog cat cat dog')


if __name__ == '__main__':
    main()
