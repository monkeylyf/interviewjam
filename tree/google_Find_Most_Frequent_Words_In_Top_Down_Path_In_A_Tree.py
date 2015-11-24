"""google

find most frequent elemnt in a binary tree path
"""

import unittest

from collections import Counter


class TreeNode(object):

    __slots__ = ('left', 'right', 'val')

    def __init__(self, val=None):
        """"""
        self.left = None
        self.right = None
        self.val = val

    def __repr__(self):
        """"""
        return "<{}>".format(self.val)


def solve(root):
    def find(root, counter):
        """

        """
        if root is None:
            most_frequent = counter.most_common(1)
            if len(most_frequent) == 0:
                return None, None
            else:
                return most_frequent[0]
        else:
            # Update counter with local val.
            counter[root.val] += 1

            left_number, left_frequency = find(root.left, counter)
            right_number, right_frequency = find(root.right, counter)

            # Handel leaf nodes.
            if left_number is None:
                return right_number, right_frequency

            if right_number is None:
                return left_number, left_frequency

            if left_frequency > right_frequency:
                return left_number, left_frequency
            else:
                # Also handel equal case.
                return right_number, right_frequency

            counter[root.val] += 1

    number, frequency = find(root, Counter())
    return number


class TestSuite(unittest.TestCase):

    def test_find_case_one(self):
        """"""
        root = TreeNode(1)
        root.left = TreeNode(1)
        root.right = TreeNode(2)
        root.left.left = TreeNode(1)
        self.assertEqual(solve(root), 1)

    def test_find_case_two(self):
        """"""
        root = TreeNode(2)
        root.right = TreeNode(2)
        root.right.right = TreeNode(2)
        root.right.right.right = TreeNode(2)
        self.assertEqual(solve(root), 2)

    def test_find_case_three(self):
        """"""
        root = None
        self.assertIsNone(solve(root))

    def test_find_case_four(self):
        """"""
        root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(2)
        root.left.left = TreeNode(2)
        root.left.right = TreeNode(2)
        root.right.right = TreeNode(1)
        root.right.right.right = TreeNode(1)
        root.right.right.right.right = TreeNode(1)
        root.right.right.right.right.right = TreeNode(1)
        self.assertEqual(solve(root), 1)


def main():
    unittest.main()


if __name__ == '__main__':
    main()
