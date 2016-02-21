"""Group shifted strings
leetcode

Given a string, we can "shift" each of its letter to its successive letter,
for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all
strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
"""


class Solution(object):

    def groupStrings(self, strings):
        """
        :type strings: List[str]
        :rtype: List[List[str]]
        """
        mapping = {}
        for string in strings:
            sig = self.normalize(string)
            mapping.setdefault(sig, []).append(string)
        values = mapping.values()
        for value in values:
            value.sort()
        return values

    def normalize(self, string):
        if not string:
            raise ValueError

        a_asci = ord('a')
        base = ord(string[0]) - a_asci
        seq = []
        for char in string:
            asci = ord(char) - base
            if asci < a_asci:
                asci += 26
            seq.append(chr(asci))
        return ''.join(seq)


def main():
    sol = Solution()
    assert sol.groupStrings(['a']) == [['a']]
    assert sol.groupStrings(["az", "yx"]) == [['az', 'yx']]


if __name__ == '__main__':
    main()
