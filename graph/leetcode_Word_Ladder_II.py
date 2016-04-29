"""Word Ladder II
leetcode

Given two words (beginWord and endWord), and a dictionary's word list, find all
shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
"""

from collections import deque, defaultdict
from string import ascii_lowercase


class Solution(object):

    def findLadders(self, beginWord, endWord, wordlist):
        """
        :type beginWord: str
        :type endWord: str
        :type wordlist: Set[str]
        :rtype: List[List[int]]
        """
        trace = {}
        local_path = defaultdict(list)
        wordlist.add(endWord)
        queue = deque([beginWord])
        count = 1
        reach_end = False

        while queue:
            word = queue.popleft()
            count -= 1
            for nw in self.word_gen(word, wordlist):
                local_path[nw].append(word)
                if nw == endWord:
                    reach_end = True
                else:
                    queue.append(nw)
            if count == 0:
                count = len(queue)
                trace.update(local_path)
                local_path = defaultdict(list)
                if reach_end:
                    from pprint import pprint as p
                    p(trace)
                    #return self.build_trace(trace, beginWord, endWord)
                    break
        return []

    def build_trace(self, trace, beginWord, endWord):
        paths = []
        self.dfs(endWord, [endWord], paths, beginWord, trace)
        return path

    def dfs(self, word, acc, paths, beginWord, trace):
        if word == beginWord:
            paths.append(acc[::-1])
        else:
            for prev in trace[word]:
                acc.append(prev)
                self.dfs(prev, acc, paths, beginWord, trace)
                acc.pop()

    def word_gen(self, word, wordList):
        chars = list(word)
        for i, c in enumerate(word):
            for char in ascii_lowercase:
                if char != c:
                    chars[i] = char
                    nw = ''.join(chars)
                    if nw in wordList:
                        yield nw
            chars[i] = c

def main():
    sol = Solution()
    beginWord = "hit"
    endWord = "cog"
    wordList = set(["hot", "dot", "dog", "lot", "log"])
    print sol.findLadders(beginWord, endWord, wordList)


if __name__ == '__main__':
    main()
