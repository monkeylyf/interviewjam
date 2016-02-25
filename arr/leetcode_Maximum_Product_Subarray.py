"""Maximum Product Subarray
leetcode

Find the contiguous subarray within an array (containing at least one number)
which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
"""


import unittest


class Solution(object):

    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        local_max = 0
        pos_acc = 1
        neg_acc = 1

        for num in nums:
            if num >= 0:
                # Non-negative.
                pos_acc, neg_acc = pos_acc * num, neg_acc * num
            else:
                # acc flipped since num is negative.
                pos_acc, neg_acc = neg_acc * num, pos_acc * num
            # Update local_max.
            local_max = max(local_max, pos_acc)
            # Reset accumulators.
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
        arr = [-2, 3, 0, -2, 4]
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
