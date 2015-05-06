"""leetcode_Isomorphic_Strings

https://leetcode.com/problems/isomorphic-strings/
"""


class Solution:

    """The idea is to Use two dict for mapping/inverted mapping.

    Check the one-to-one relationship and if one-to-many or many-to-many
    relationship exits, then return False. After checking all char pairs,
    return True.
    """

    def isIsomorphic(self, s, t):
        mapping = {}
        inverted_mapping = {}
        for c1, c2 in zip(s, t):
            if c1 not in mapping:
                if c2 not in inverted_mapping:
                    mapping[c1] = c2
                    inverted_mapping[c2] = c1
                elif inverted_mapping[c2] != c1:
                    return False
                else:
                    pass
            elif mapping[c1] != c2:
                return False
            else:
                pass
        return True


def main():
    s = Solution()
    print s.isIsomorphic('egg', 'add')
    print s.isIsomorphic('foo', 'bar')
    print s.isIsomorphic('paper', 'title')
    print s.isIsomorphic('ab', 'aa')


if __name__ == '__main__':
    main()
