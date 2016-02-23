"""Isomorphic Strings
leetcode

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while
preserving the order of characters. No two characters may map to the same
character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
"""


class Solution:

    """The idea is to Use two dict for mapping/inverted mapping.

    Check the one-to-one relationship and if one-to-many or many-to-many
    relationship exits, then return False. After checking all char pairs,
    return True.
    """

    def isIsomorphic(self, s, t):
        mapping = {}
        mapped = set()
        for c1, c2 in zip(s, t):
            if c1 in mapping:
                if mapping[c1] != c2:
                    return False
            else:
                if c2 in mapped:
                    return False
                else:
                    mapping[c1] = c2
                    mapped.add(c2)
        return True


def main():
    s = Solution()
    assert s.isIsomorphic('egg', 'add')
    assert not s.isIsomorphic('foo', 'bar')
    assert s.isIsomorphic('paper', 'title')
    assert not s.isIsomorphic('ab', 'aa')


if __name__ == '__main__':
    main()
