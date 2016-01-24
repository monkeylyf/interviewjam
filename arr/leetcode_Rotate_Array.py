"""Rotate array
leetcode

Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
[5,6,7,1,2,3,4].
"""


class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        def reverse(arr, i, j):
            while i < j:
                arr[i], arr[j] = arr[j], arr[i]
                i += 1
                j -= 1

        n = len(nums)
        k = k % n
        reverse(nums, 0, n - k - 1)
        reverse(nums, n - k, n - 1)
        reverse(nums, 0, n - 1)


def main():
    sol = Solution()
    nums = [1, 2, 3, 4, 5, 6, 7]
    sol.rotate(nums, 3)
    assert nums == [5, 6, 7, 1, 2, 3, 4]

    nums = [1, 2, 3, 4, 5, 6]
    sol.rotate(nums, 11)
    assert nums == [2, 3, 4, 5, 6, 1]


if __name__ == '__main__':
    main()
