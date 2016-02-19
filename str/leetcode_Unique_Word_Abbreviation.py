"""Unique Word Abbreviation
leetcode

An abbreviation of a word follows the form <first letter><number><last letter>.
Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is
unique in the dictionary. A word's abbreviation is unique if no other word from
the dictionary has the same abbreviation.

Example:
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
"""


class ValidWordAbbr(object):

    def __init__(self, dictionary):
        """
        initialize your data structure here.
        :type dictionary: List[str]
        """
        self._abbr = {}
        for word in dictionary:
            self._abbr.setdefault(self.to_abbr(word), set()).add(word)

    def to_abbr(self, word):
        """"""
        if len(word) <= 2:
            return word
        else:
            return '{}{}{}'.format(word[0], word[-1], len(word) - 2)

    def isUnique(self, word):
        """
        check if a word is unique.
        :type word: str
        :rtype: bool
        """
        abbr = self.to_abbr(word)
        try:
            words = self._abbr[abbr]
        except KeyError:
            return True
        else:
            return len(words) == 1 and word in words


def main():
    # Your ValidWordAbbr object will be instantiated and called as such:
    dictionary = ["deer", "door", "cake", "card"]
    vwa = ValidWordAbbr(dictionary)
    assert vwa.isUnique("word")
    assert vwa.isUnique("anotherWord")

    dictionary = ["hello"]
    vwa = ValidWordAbbr(dictionary)
    assert vwa.isUnique('hello')


if __name__ == '__main__':
    main()
