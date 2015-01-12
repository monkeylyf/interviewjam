"""Find point which sum of distances to set of other points is minimal
google

http://en.wikipedia.org/wiki/Geometric_median
"""

import unittest

from random import (shuffle, randrange)


class Point(object):

    """Flyweight."""

    __slots__ = ('x', 'y')

    def __init__(self, x, y):
        """"""
        self.x = x
        self.y = y

    def __repr__(self):
        """"""
        return '({0}, {1})'.format(self.x, self.y)


def quick_select(arr, n):
    """Find the nth (zero-based) element in given array."""
    def rand(left, right):
        """"""
        return randrange(right - left + 1) + left
        #return left

    def swap(arr, i, j):
        arr[i], arr[j] = arr[j], arr[i]

    def partition(arr, left, right):
        """Partition the array given pivot."""
        pivot_idx = rand(left, right)
        pivot_val = arr[pivot_idx]
        swap(arr, pivot_idx, right)
        store_idx = left
        # Swap the smaller element to left.
        for i in xrange(left, right):
            if arr[i] < pivot_val:
                swap(arr, store_idx, i)
                store_idx += 1

        swap(arr, right, store_idx)

        return store_idx

    # Sanity check.
    if not arr:
        raise ValueError("Empty input array")

    if n > len(arr):
        raise ValueError("n cannot be larger than the length of arr")

    left = 0
    right = len(arr) - 1

    while left <= right:
        pivot_idx = partition(arr, left, right)
        if n == pivot_idx:
            return arr[n]
        elif n < pivot_idx:
            right = pivot_idx - 1
        else:
            left = pivot_idx + 1

    return left


def solve(points):
    """"""
    if not points:
        return None

    length = len(points)

    xs = [point.x for point in points]
    ys = [point.y for point in points]

    xx = quick_select(xs, length / 2)
    yy = quick_select(ys, length / 2)
    if length % 2 == 0:
        x = quick_select(xs, length / 2 - 1)
        y = quick_select(ys, length / 2 - 1)
        return Point((xx + x) / 2.0, (yy + y) / 2.0)
    else:
        return Point(xx, yy)


class QuickSelectTestSuite(unittest.TestCase):

    """"""

    def setUp(self):
        """"""
        self.small = [5, 3, 2, 1, 4]
        self.large = range(1000)

    def test_empty_array(self):
        """Testing empty array"""
        self.assertRaises(ValueError, quick_select, [], 0)

    def test_small(self):
        """Testing small array"""
        for i in xrange(len(self.small)):
            self.assertEquals(i + 1, quick_select(self.small[::], i))

    def test_large(self):
        """Testing large array"""
        from random import shuffle
        shuffle(self.large)

        for i in xrange(len(self.large)):
            self.assertEquals(i, quick_select(self.large[::], i))


def main():
    """"""
    points = [Point(i, i ** 2) for i in xrange(10)]
    #print points
    print solve(points)
    unittest.main(verbosity=2)


if __name__ == '__main__':
    main()
