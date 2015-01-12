"""google_Maximum_Submatrix_Product
google

Given a matrix which contains both positive and non-positve numbers.
Find the maximum submatrix product.
"""


import unittest


class Solution(object):

    """Yo young money."""

    def __init__(self, matrix):
        """"""
        self.matrix = matrix
        self.n = len(matrix)
        self.m = len(matrix[0])

    def max_submatrix_product(self):
        """"""
        global_max = None

        for upper in xrange(self.n):
            acc = [1] * self.m

            for lower in xrange(upper, self.n):
                for i in xrange(self.m):
                    acc[i] *= self.matrix[lower][i]

                local_max = self.max_arr_product(acc)

                # Update local max.
                if global_max is None:
                    global_max = local_max
                else:
                    global_max = max(global_max, local_max)

        return global_max

    def max_arr_product(self, arr):
        """"""
        if not arr:
            raise ValueError("Empty arr")

        if len(arr) == 1:
            return arr[0]

        pos_acc = 1
        neg_acc = 1

        local_max = None

        for i in arr:
            if i >= 0:
                pos_acc, neg_acc = pos_acc * i, neg_acc * i
            else:
                pos_acc, neg_acc = neg_acc * i, pos_acc * i

            if local_max is None:
                local_max = pos_acc
            else:
                local_max = max(local_max, pos_acc)

            # Reset accumulators.
            if pos_acc < 1:
                pos_acc = 1
            if neg_acc > -1:
                neg_acc = 1

        return local_max


class TestSuite(unittest.TestCase):

    """"""

    def test_small_1(self):
        matrix = [[1, -1, 2, -1]]

        self.assertEqual(Solution(matrix).max_submatrix_product(), 2)

    def test_small_2(self):
        matrix = [[1, -1, 2, -1],
                  [2, 3, -6, -2]]

        self.assertEqual(Solution(matrix).max_submatrix_product(), 144)


def main():
    unittest.main()


if __name__ == '__main__':
    main()
