"""leetcode_Maximum_Gap.py

Given an unsorted array, find the maximum difference between the successive
elements in its sorted form.
Try to solve it in linear time/space.
Return 0 if the array contains less than 2 elements.
You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
"""

import random
import unittest


def solve(arr):
    """O(n) sorting with not-fine-granularity."""
    n = len(arr)

    min_val = min(arr)
    # Now the min value of the array is guaranteed to be 0.
    arr = map(lambda x : x - min_val, arr)

    max_val = max(arr)

    # Init and fill buckets.
    buckets = [None] * n

    for i in arr:
        index = float(i) * (n - 1) / max_val
        index = int(index)
        try:
            buckets[index].append(i)
        except AttributeError:
            buckets[index] = [i]

    # Find max gap.
    retval = (n - 1) / max_val
    prev_max = None
    for bucket in buckets:
        if bucket is None:
            continue
        if prev_max is None:
            bucket_max = max(bucket)
            retval = max(retval, bucket_max)
            prev_max = bucket_max
        else:
            local_min = min(bucket)
            local_max = max(bucket)

            bucket_max = max(local_max - local_min, local_min - prev_max)
            retval = max(retval, bucket_max)

            prev_max = local_max

    return retval


class TestSuite(unittest.TestCase):

    """"""

    def test_solve(self):
        for _ in xrange(500):
            arr = self._create_random_arr()
            max_diff = solve(arr)
            expected_diff = self._get_max_diff(arr)
            self.assertEqual(max_diff, expected_diff)

    def _get_max_diff(self, arr):
        arr.sort()

        ret = 0
        for i, val in enumerate(arr):
            if i != 0:
                ret = max(ret, val - prev)
            prev = val

        return ret

    def _create_random_arr(self):
        n = 1000
        max_val = 1000
        return [int(max_val * random.random()) for _ in xrange(n)]


def main():
    arr = [3, 1, 2, 7, 4]
    solve(arr)


if __name__ == '__main__':
    main()
