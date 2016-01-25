"""Add and search word data structure design
leetcode

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
"""


from collections import deque


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

    def search(self, pattern):
        """Return all end nodes whose paths fit given pattern.

        Level order traversal. If current char '.', meaning wild card and all
        nodes at this level match. Otherwise do exact match.

        :param pattern: str
        :param return: list, of nodes
        """
        queue = deque([self.root])
        for char in pattern:
            count = len(queue)
            while queue and count > 0:
                node = queue.popleft()
                count -= 1

                if char == '.':
                    queue.extend(node.children.values())
                else:
                    try:
                        queue.append(node.children[char])
                    except:
                        pass
        return queue


class WordDictionary(object):
    def __init__(self):
        """initialize your data structure here."""
        self._trie = Trie()

    def addWord(self, word):
        """Adds a word into the data structure.

        :type word: str
        :rtype: void
        """
        self._trie.insert(word)

    def search(self, word):
        """Returns if the word is in the data structure.

        A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        end_nodes = self._trie.search(word)
        # Check any of the end nodes has end node flag.
        return any(node.end for node in end_nodes)


def main():
    # Your WordDictionary object will be instantiated and called as such:
    wordDictionary = WordDictionary()
    wordDictionary.addWord("word")
    assert wordDictionary.search("..rd")
    assert wordDictionary.search("word")
    assert wordDictionary.search(".o.d")
    assert wordDictionary.search(".o..")


if __name__ == '__main__':
    main()
