"""Word search II
leetcode

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
"""

from collections import Counter


class Solution(object):

    VISITED = '#'

    class TrieNode(object):

        """Trie node."""

        def __init__(self):
            """Initialize."""
            self.children = [None] * 26
            self.word = None

    def findWords(self, board, words):
        """Prefix tree.

        Using given words to create prefix tree. In dfs, check whether current
        char exists in the trie node of current level. If it does, find the child
        node matched to current char and check for neighbor cell.

        Note that a word might have multiple path in a matrix so need to dedup.

        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        def build_trie(words):
            """Build prefix tree.

            :param words: list,
            :param return: TrieNode obj
            """
            root = Solution.TrieNode()
            for word in words:
                node = root
                for char in word:
                    idx = ord(char) - ord('a')
                    if node.children[idx] is None:
                        node.children[idx] = Solution.TrieNode()
                    node = node.children[idx]
                node.word = word
            return root

        def char_to_idx(char):
            """"""
            return ord(char) - 97  # ord('a')

        def dfs(board, i, j, root, container):
            """"""
            if i < 0 or i >= len(board) or \
               j < 0 or j >= len(board[0]) or \
               board[i][j] == Solution.VISITED or \
               root.children[char_to_idx(board[i][j])] is None:
                # Out of boundary or visitd or current char doesn't match.
                return
            char = board[i][j]
            node = root.children[char_to_idx(char)]
            if node.word is not None:
                container.append(node.word)
                # Dedup. A word(char sequence) may appear mutiple times in matrix.
                node.word = None

            board[i][j] = Solution.VISITED # Same as visit[i][j] = True
            dfs(board, i - 1, j, node, container)
            dfs(board, i + 1, j, node, container)
            dfs(board, i, j - 1, node, container)
            dfs(board, i, j + 1, node, container)
            board[i][j] = char

        # Convert str into list of char so it can be modified in place.
        board = [list(row) for row in board]
        container = []
        root = build_trie(words)
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                dfs(board, i, j, root, container)
        return container


def main():
    sol = Solution()
    board = [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]
    words = ['oath', 'pea', 'eat', 'rain']
    assert sol.findWords(board, words) ==  ['oath', 'eat']


if __name__ == '__main__':
    main()
