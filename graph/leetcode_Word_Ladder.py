"""Word Ladder
leetcode

Given two words (beginWord and endWord), and a dictionary's word list, find the
length of shortest transformation sequence from beginWord to endWord, such
that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is
"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
"""


from collections import deque
from string import ascii_lowercase


class Solution(object):

    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: Set[str]
        :rtype: int
        """
        queue = deque([beginWord])
        visited = set([beginWord])
        wordList.add(endWord)
        steps = 2
        count = 1

        while queue:
            cur = queue.popleft()
            for ns in self.word_gen(cur, wordList):
                if ns == endWord:
                    return steps
                if ns not in visited:
                    visited.add(ns)
                    queue.append(ns)

            count -= 1
            if count == 0:
                steps += 1
                count = len(queue)

        return 0

    def word_gen(self, word, wordList):
        chars = list(word)
        for i, c in enumerate(word):
            for char in ascii_lowercase:
                if char != c:
                    chars[i] = char
                    ns = ''.join(chars)
                    if ns in wordList:
                        yield ns
            chars[i] = c


def main():
    sol = Solution()
    beginWord = "hit"
    endWord = "cog"
    wordList = set(["hot", "dot", "dog", "lot", "log"])
    assert sol.ladderLength(beginWord, endWord, wordList) == 5


if __name__ == '__main__':
    main()
