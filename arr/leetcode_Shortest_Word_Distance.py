"""Shortest word distance
leetcode

Given a list of words and two words word1 and word2, return the shortest
distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = "coding", word2 = "practice", return 3.
Given word1 = "makes", word2 = "coding, return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both
in the list.
"""


class Solution(object):
    def shortestDistance(self, words, word1, word2):
        """
        :type words: List[str]
        :type word1: str
        :type word2: str
        :rtype: int
        """
        idx1 = []
        idx2 = []
        for i, word in enumerate(words):
            if word == word1:
                idx1.append(i)
            if word == word2:
                idx2.append(i)

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
    sol = Solution()
    words = ["practice", "makes", "perfect", "coding", "makes"]
    assert sol.shortestDistance(words, 'coding', 'practice') == 3


if __name__ == '__main__':
    main()
