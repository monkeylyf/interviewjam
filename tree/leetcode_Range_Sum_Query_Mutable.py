"""Range sum query mutable
leetcode

Given an integer array nums, find the sum of the elements between indices i and
j (i <= j), inclusive.
The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
"""

import math


class NumArray(object):

    """"""

    def __init__(self, nums):
        """"""
        self._tree = None
        self._size = None
        self.build(nums)

    def update(self, idx, value):
        """"""
        if idx < 0 or idx >= self._size:
            raise ValueError('Invalid index: {}'.format(idx))

        return self._update(0, self._size - 1, idx, value, 0)

    def _update(self, start, end, idx, value, i):
        """"""
        if start == end:
            diff = value - self._tree[i]
            self._tree[i] = value
        else:
            mid = (end - start) / 2 + start
            if idx <= mid:
                diff = self._update(start, mid, idx, value, 2 * i + 1)
            else:
                diff = self._update(mid + 1, end, idx, value, 2 * i + 2)
            self._tree[i] += diff
        return diff

    def query(self, start, end):
        """"""
        if start > end or start < 0 or end >= self._size:
            raise ValueError('Invalid range [{}, {}]'.format(start, end))
        return self._query(0, self._size - 1, start, end, 0)

    def sumRange(self, start, end):
        return self.query(start, end)

    def _query(self, start, end, query_start, query_end, i):
        """"""
        if query_start <= start and query_end >= end:
            return self._tree[i]
        elif query_start > end or query_end < start:
            return 0
        else:
            # [start, end] is partially overlapped with query range.
            # Split [start, end] to next level of tree.
            mid = (end - start) / 2 + start
            left_sum =  self._query(start, mid, query_start, query_end, 2 * i + 1)
            right_sum = self._query(mid + 1, end, query_start, query_end, 2 * i + 2)
            return left_sum + right_sum

    def build(self, arr):
        """Build segment tree.

        :param arr: list
        """
        self._size = len(arr)
        heap_size = self._heap_size(len(arr))
        self._tree = [0] * heap_size
        if heap_size > 0:
            self._build(arr, 0, len(arr) - 1, 0)

    def _build(self, arr, start, end, i):
        """Build segment tree.

        :param arr: list
        :param start: int, start idx of the array
        :param end: int, end idx of the array
        """
        if start == end:
            self._tree[i] = arr[start]
        else:
            mid = (end - start) / 2 + start
            left_sum = self._build(arr, start, mid, 2 * i + 1)
            right_sum = self._build(arr, mid + 1, end, 2 * i + 2)
            self._tree[i] = left_sum + right_sum

        return self._tree[i]

    def _heap_size(self, n):
        """Return the size of arr to store the tree."""
        if n == 0:
            return 0
        else:
            power = int(math.log(n) / math.log(2)) + 1
            return 2 ** (power + 1) - 1


def main():
    tree = NumArray([1, 3, 5])
    assert tree.sumRange(0, 2) == 9
    tree.update(1, 2)
    assert tree.sumRange(0, 2) == 8

    tree = NumArray([])

if __name__ == '__main__':
    main()
