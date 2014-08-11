"""Segment Tree

max/sum/min/product

http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static
http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
"""

import random
import unittest

from math import (log, ceil)


def height_of_balanced_binary_tree(n):
    """return height of balanced binary tree.

    1, 2, 4 total 7 nodes should return 3.
    1, 2, total 3 nodes should return 2.
    1, 2, 2 total 5 nodes should return 3.
    """
    return int(ceil(log(n + 1) / log(2))) + 1


def build_tree_with_array(arr):
    """"""
    # Start of the nested function
    def init(cur, start, end, seg_arr):
        """"""
        if start == end:
            # You can also store the real value in seg_arr instead of index.
            seg_arr[cur] = start
        else:
            left_idx = 2 * cur
            right_idx = 2 * cur + 1
            init(left_idx, start, (end - start) / 2 + start, seg_arr)
            init(right_idx, (end - start) / 2 + start + 1, end, seg_arr)
            # This part of the code can be customized due to max/min/sum/product
            # segment tree.
            if arr[seg_arr[left_idx]] <= arr[seg_arr[right_idx]]:
                seg_arr[cur] = seg_arr[left_idx]
            else:
                seg_arr[cur] = seg_arr[right_idx]

    # End of the nested function
    n = len(arr)
    height = height_of_balanced_binary_tree(n)
    seg_arr = [-1] * (2 ** height)

    init(1, 0, n - 1, seg_arr)

    return seg_arr


def query_with_array(arr, seg_arr, start, end):
    def query(cur, left_bound, right_bound):
        # Range covered by current node does not intersect with query start/end.
        if start > right_bound or end < left_bound:
            return -1

        # Range
        if left_bound >= start and right_bound <= end:
            return seg_arr[cur]

        left_query = query(2 * cur, left_bound, (right_bound - left_bound) / 2 + left_bound)
        right_query = query(2 * cur + 1, (right_bound - left_bound) / 2 + left_bound + 1, right_bound)


        if left_query == -1:
            return right_query
        elif right_query == -1:
            return left_query
        elif arr[left_query] <= arr[right_query]:
            return left_query
        else:
            return right_query

    # End of the nested function.
    if start < 0 or end > len(arr) - 1:
        raise ValueError("Query left boundary should be non-negative and right boundary should be less than length")
    return query(1, 0, len(arr) - 1)


class TreeNode(object):

    __slots__ = ('left', 'right', 'val', 'left_bound', 'right_bound')

    def __init__(self, left, right, val, left_bound, right_bound):
        self.left = left
        self.right = right

        self.val = val
        self.left_bound = left_bound
        self.right_bound = right_bound

    def __repr__(self):
        return '{0} <{1}, {2}>'.format(self.val, self.left_bound, self.right_bound)


def build_tree(arr):
    def build_tree_util(arr, start, end):
        if start == end:
            return TreeNode(None, None, arr[start], start, end)
        else:
            mid = start + (end - start) / 2

            left = build_tree_util(arr, start, mid)
            right = build_tree_util(arr, mid + 1, end)

            return TreeNode(left, right, min(left.val, right.val), start, end)

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
        self.assertRaises(ValueError, query, root, -1, -1)
        self.assertRaises(ValueError, query, root, 200, -1)

    def test_segment_tree_used_on_array_small(self):
        arr = range(100)
        random.shuffle(arr)
        seg_arr = build_tree_with_array(arr)
        for _ in xrange(10):
            (a, b) = random.choice(arr), random.choice(arr)
            (a, b) = min(a, b), max(a, b)
            min_idx = query_with_array(arr, seg_arr, a, b)
            self.assertEqual(min(arr[a : b + 1]), arr[min_idx])

    def test_segment_tree_used_on_array_large(self):
        arr = range(10000)
        random.shuffle(arr)
        seg_arr = build_tree_with_array(arr)
        for _ in xrange(10000):
            (a, b) = random.choice(arr), random.choice(arr)
            (a, b) = min(a, b), max(a, b)
            min_idx = query_with_array(arr, seg_arr, a, b)
            self.assertEqual(min(arr[a : b + 1]), arr[min_idx])


def main():
    suite = unittest.TestLoader().loadTestsFromTestCase(TestSegmentTree)
    unittest.TextTestRunner(verbosity=2).run(suite)


if __name__ == '__main__':
    main()
