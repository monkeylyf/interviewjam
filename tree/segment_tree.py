"""Segment Tree

max/sum/min/product
"""

import random
import unittest


class TreeNode(object):

    def __init__(self):
        self.left = None
        self.right = None

        self.val = None
        self.left_bound = None
        self.right_bound = None

    def __repr__(self):
        return '{0} <{1}, {2}>'.format(self.val, self.left_bound, self.right_bound)


def build_tree(arr):
    def build_tree_util(arr, start, end):
        node = TreeNode()
        node.left_bound = start
        node.right_bound = end

        if start == end:
            node.val = arr[start]
        else:
            mid = start + (end - start) / 2

            node.left = build_tree_util(arr, start, mid)
            node.right = build_tree_util(arr, mid + 1, end)
            node.val = min(node.left.val, node.right.val)

        return node

    return build_tree_util(arr, 0, len(arr) - 1)


def query(root, s, e):
    def query_util(root, s, e):
        if s > root.right_bound or e < root.left_bound:
            return 1000000009
        elif s == root.left_bound and e == root.right_bound:
            return root.val
        else:
            mid = root.left_bound + (root.right_bound - root.left_bound) / 2
            #return min(query_util(root.left,  s, mid),
            #           query_util(root.right, mid + 1, e))
            if e <= mid:
                return query_util(root.left, s, e)
            elif s > mid:
                return query_util(root.right, s, e)
            else:
                return min(query_util(root.left, s, mid), query_util(root.right, mid + 1, e))
                

    if s > e or s < 0 or e > root.right_bound:
        raise ValueError("Invalid query range: <{0}, {1}>".format(s, e))

    return query_util(root, s, e)


def dfs(root):
    if root:
        print root
        dfs(root.left)
        dfs(root.right)


class TestSegmentTree(unittest.TestCase):

    def test_Postive_Small(self):
        arr = range(100)
        random.shuffle(arr)
        root = build_tree(arr)

        for s in xrange(len(arr)):
            for e in xrange(s, len(arr)):
                self.assertEqual(query(root, s, e), min(arr[s : e + 1]))

    def test_Postive_Large(self):
        arr = range(1000)
        random.shuffle(arr)
        root = build_tree(arr)

        for s in xrange(len(arr)):
            for e in xrange(s, len(arr)):
                self.assertEqual(query(root, s, e), min(arr[s : e + 1]))

    def test_Negtive_Small(self):
        arr = range(-100, 0)
        random.shuffle(arr)
        root = build_tree(arr)

        for s in xrange(len(arr)):
            for e in xrange(s, len(arr)):
                self.assertEqual(query(root, s, e), min(arr[s : e + 1]))

    def test_Negtive_Large(self):
        arr = range(-1000, 0)
        random.shuffle(arr)
        root = build_tree(arr)

        for s in xrange(len(arr)):
            for e in xrange(s, len(arr)):
                self.assertEqual(query(root, s, e), min(arr[s : e + 1]))

    def test_Mixed_Small(self):
        arr = range(-50, 50)
        random.shuffle(arr)
        root = build_tree(arr)

        for s in xrange(len(arr)):
            for e in xrange(s, len(arr)):
                self.assertEqual(query(root, s, e), min(arr[s : e + 1]))

    def test_Mixed_Large(self):
        arr = range(-500, 500)
        random.shuffle(arr)
        root = build_tree(arr)

        for s in xrange(len(arr)):
            for e in xrange(s, len(arr)):
                self.assertEqual(query(root, s, e), min(arr[s : e + 1]))

    def test_Raise_Exception(self):
        arr = range(100)
        root = build_tree(arr)
        self.assertRaises(ValueError, root, -1, -1)
        self.assertRaises(ValueError, root, 200, -1)


def main():
    suite = unittest.TestLoader().loadTestsFromTestCase(TestSegmentTree)
    unittest.TextTestRunner(verbosity=2).run(suite)


if __name__ == '__main__':
    main()
