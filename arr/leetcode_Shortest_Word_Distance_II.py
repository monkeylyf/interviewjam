"""Shortest word distance II
leetcode

This is a follow up of Shortest Word Distance. The only difference is now you
are given the list of words and your method will be called repeatedly many times
with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements
a method that takes two words word1 and word2 and return the shortest distance
between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both
in the list.
"""


from collections import defaultdict


class WordDistance(object):

    def __init__(self, words):
        """
        initialize your data structure here.
        :type words: List[str]
        """
        self.indexes = defaultdict(list)

        for i, word in enumerate(words):
            self.indexes[word].append(i)

    def shortest(self, word1, word2):
        """
        Adds a word into the data structure.
        :type word1: str
        :type word2: str
        :rtype: int
        """
        idx1 = self.indexes[word1]
        idx2 = self.indexes[word2]

        min_dis = float('+inf')
        i = len(idx1) - 1
        j = len(idx2) - 1

        while i >= 0 and j >= 0:
            min_dis = min(min_dis, abs(idx1[i] - idx2[j]))
            if idx1[i] > idx2[j]:
                i -= 1
            elif idx1[i] < idx2[j]:
                j -= 1
            else:
                raise ValueError

        return min_dis


def main():
    # Your WordDistance object will be instantiated and called as such:
    words = ["practice", "makes", "perfect", "coding", "makes"]
    wordDistance = WordDistance(words)
    assert wordDistance.shortest("coding", "practice") == 3
    assert wordDistance.shortest("makes", "coding") == 1


if __name__ == '__main__':
    main()
