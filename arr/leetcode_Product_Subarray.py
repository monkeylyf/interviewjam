"""leetcode_Product_Subarray.py

Find the contiguous subarray within an array (containing at least one number)
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
"""


import unittest


class Solution:

    def maxProduct(self, A):
        if not A:
            raise ValueError("Empty array!")

        if len(A) == 1:
            return A[0]

        local_max = 0
        (pos_acc, neg_acc) = (1, 1)

        for i in A:
            if i >= 0:
                # Non-negative.
                (pos_acc, neg_acc) = (pos_acc * i, neg_acc * i)
            else:
                (pos_acc, neg_acc) = (neg_acc * i, pos_acc * i)

            # Update local_max.
            local_max = max(local_max, pos_acc)
            # reset accumulators.
            if pos_acc < 1:
                pos_acc = 1
            if neg_acc > -1:
                neg_acc = 1

        return local_max


class TestSuite(unittest.TestCase):

    def setUp(self):
        self.solution = Solution()

    def test_1(self):
        arr = [.2, 3, -2, .4, -1]
        self.assertEquals(3, self.solution.maxProduct(arr))

    def test_2(self):
        arr = [2, 3, -2, 4, -1]
        self.assertEquals(48, self.solution.maxProduct(arr))

    def test_3(self):
        arr = [1, 2, 3, 4, 5, 6]
        self.assertEquals(720, self.solution.maxProduct(arr))

    def test_4(self):
        arr = [-1, -2, -3, -4, -5, -6]
        self.assertEquals(720, self.solution.maxProduct(arr))

    def test_5(self):
        arr = [-1, -2, -3, -4, -5]
        self.assertEquals(120, self.solution.maxProduct(arr))

    def test_6(self):
        arr = [2, 3, -2, 4]
        self.assertEquals(6, self.solution.maxProduct(arr))

    def test_7(self):
        arr = [-2, 3, 0, -2, 4,]
        self.assertEquals(4, self.solution.maxProduct(arr))

    def test_8(self):
        arr = [-2]
        self.assertEquals(-2, self.solution.maxProduct(arr))

    def test_9(self):
        arr = [-2, 0, -1]
        self.assertEquals(0, self.solution.maxProduct(arr))


def main():
    unittest.main()


if __name__ == '__main__':
    main()
