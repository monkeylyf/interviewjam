"""leetcode_Largest_Number.
leetcode

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
"""


class Solution(object):

    """Variation of merge sort."""

    def merge(self, left, right):
        """Merge two sorted arr."""
        merged = []

        i = j = 0

        while i < len(left) and j < len(right):
            # Where the magic hides.
            # Comparing concaternated str with different order  instead of
            # comparing two str.
            if left[i] + right[j] > right[j] + left[i]:
                merged.append(left[i])
                i += 1
            else:
                merged.append(right[j])
                j += 1

        while i < len(left):
            merged.append(left[i])
            i += 1

        while j < len(right):
            merged.append(right[j])
            j += 1

        return merged

    def merge_sort(self, arr):
        """"""
        if len(arr) <= 1:
            return arr

        half = len(arr) / 2

        left  = self.merge_sort(arr[:half])
        right = self.merge_sort(arr[half:])

        return self.merge(left, right)

    def largestNumber(self, num):
        """"""
        arr = self.merge_sort(map(str, num))
        return int(''.join(arr))

    def largestNumber(self, nums):
        nums = [str(i) for i in nums]
        nums = sorted(nums, cmp=lambda x,y : -1 if x + y > y + x else 1)
        return str(int(''.join(nums)))


def main():
    arr = [3, 30, 34, 5, 9]
    sol = Solution()
    assert sol.largestNumber(arr) == '9534330'


if __name__ == '__main__':
    main()
