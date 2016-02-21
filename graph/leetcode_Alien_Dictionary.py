"""Alien Dictionary
leetcode

There is a new alien language which uses the latin alphabet. However, the order
among letters are unknown to you. You receive a list of words from the
dictionary, where words are sorted lexicographically by the rules of this new
language. Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".
"""


from collections import deque


class Solution(object):

    def alienOrder(self, words):
        """
        :type words: List[str]
        :rtype: str
        """
        chars = set(c for word in words for c in word)
        out_degree = {c: set() for c in chars}
        in_degree = {c: set() for c in chars}

        i = 0
        while i < len(words) - 1:
            cur_word = words[i]
            next_word = words[i + 1]
            min_length = min(len(cur_word), len(next_word))
            j = 0
            while j < min_length:
                if cur_word[j] != next_word[j]:
                    out_degree[next_word[j]].add(cur_word[j])
                    in_degree[cur_word[j]].add(next_word[j])
                    break
                j += 1
            i += 1

        queue = deque()
        for node, indgr in in_degree.iteritems():
            if len(indgr) == 0:
                queue.append(node)

        order = []
        # Toposort sort without recursion.
        while queue:
            node = queue.popleft()
            order.append(node)
            for neighbor in out_degree[node]:
                in_degree[neighbor].remove(node)
                if len(in_degree[neighbor]) == 0:
                    queue.append(neighbor)

        if any(in_degree.values()):
            return ''
        else:
            return ''.join(reversed(order))


def main():
    sol = Solution()
    words = [
        "ndwkkqrba",
        "qmewabzvqa",
        "boau",
        "ixxzpijax",
        "sdsszrbi",
        "hvqdad",
        "opbippqgz",
        "ft",
        "w"
    ]
    assert sol.alienOrder(words) == 'nqbishofzxvwturpmjkgdea'


if __name__ == '__main__':
    main()
