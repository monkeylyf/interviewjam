"""Implement trie prefix tree
leetcode

Implement a trie with insert, search, and startsWith methods.
"""

class TrieNode(object):

    __slots__ = ('val', 'end', 'children')

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.val = None
        self.end = False
        self.children = {}


class Trie(object):

    def __init__(self):
        """"""
        self.root = TrieNode()
        self.root.val = ''

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        node = self.root
        for char in word:
            try:
                child = node.children[char]
            except KeyError:
                child = TrieNode()
                child.val = char
                node.children[char] = child
            node = child
        node.end = True

    def _end_node(self, string):
        """Return the last node given string path.

        :param string: str
        """
        node = self.root
        for char in string:
            node = node.children[char]
        return node

    def search(self, word):
        """Returns if the word is in the trie.

        :type word: str
        :rtype: bool
        """
        try:
            return self._end_node(word).end
        except KeyError:
            return False

    def startsWith(self, prefix):
        """Returns if there is any word starts with the given prefix.

        :type prefix: str
        :rtype: bool
        """
        try:
            self._end_node(prefix)
            return True
        except KeyError:
            return False


def main():
    trie = Trie()
    trie.insert("somestring")
    assert trie.search("somestring")
    assert not trie.search("some")
    assert trie.startsWith("some")

    trie.insert('app')
    assert trie.search("app")

    trie.insert('apps')
    assert trie.search("app")

    trie.insert('apple')
    assert trie.search("app")

if __name__ == '__main__':
    main()
