"""suffix tree

http://en.wikipedia.org/wiki/Suffix_tree
"""


import unittest


class SuffixTree(object):

    """"""

    def __init__(self, string):
        """"""
        self.root = SuffixTreeNode()
        for i in xrange(len(string)):
            self.root.insert(string[i:], i)

    def get_indices(self, string):
        """"""
        return self.root.get(string)


class SuffixTreeNode(object):

    """Flyweight class."""

    __slots__ = ('indices', 'kids')

    def __init__(self):
        """"""
        self.indices = []
        self.kids = {}

    def insert(self, string, index):
        """"""
        self.indices.append(index)
        if not string:
            return

        first = string[0]
        if first in self.kids:
            kid = self.kids[first]
        else:
            kid = SuffixTreeNode()
            self.kids[first] = kid
        kid.insert(string[1:], index)

    def get(self, string):
        """"""
        if not string:
            return self.indices

        first = string[0]
        return self.kids[first].get(string[1:]) if first in self.kids else None

    def __repr__(self):
        """"""
        return str(self.indices) + ' ' + str(self.kids)


class TestSuffixTreeNode(unittest.TestCase):

    """"""

    def setUp(self):
        """"""
        self.node = SuffixTreeNode()
        print self.node

    def test_insert(self):
        """Testing insert"""
        self.assertEqual(1, 1)


class TestSuffixTree(unittest.TestCase):

    """"""

    def setUp(self):
        """"""
        self.suffix_tree = SuffixTree('banana')

    def test_get_indices(self):
        """Testing get_indices"""
        print self.suffix_tree.get_indices('a')
        print self.suffix_tree.get_indices('na')


def main():
    unittest.main()


if __name__ == '__main__':
    main()
