"""Median of two sorted arrays
leetcode

There are two sorted arrays nums1 and nums2 of size m and n respectively. Find
the median of the two sorted arrays. The overall run time complexity should be
O(log (m+n)).
"""


class Solution(object):

    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        m = len(nums1)
        n = len(nums2)
        mid = (m + n) / 2
        if (m + n) % 2 == 1:
            return self.find(nums1, m, nums2, n, mid)
        else:
            left = self.find(nums1, m, nums2, n, mid - 1)
            right = self.find(nums1, m, nums2, n, mid)
            return (left + right) / 2.0

    def find(self, nums1, m, nums2, n, th):
        if m == 0:
            return nums2[th]
        if n == 0:
            return nums1[th]

        mida = (m - 1) / 2
        midb = (n - 1) / 2
        if nums1[mida] < nums2[midb]:
            return self.find(nums2, n, nums1, m, th)
        # else nums1[mida] >= nums2[mida]
        if mida + 1 + midb + 1 <= th + 1:
            return self.find(nums1, m, nums2[midb + 1:], n - (midb + 1), (th + 1) - (midb + 1) - 1)
        else:
            return self.find(nums1, mida, nums2, n, th)


def main():
    sol = Solution()
    nums1 = [1]
    nums2 = [1]
    assert sol.findMedianSortedArrays(nums1, nums2) == 1.0

    nums1 = [1]
    nums2 = []
    assert sol.findMedianSortedArrays(nums1, nums2) == 1.0

    nums1 = []
    nums2 = [1]
    assert sol.findMedianSortedArrays(nums1, nums2) == 1.0

    nums1 = [2]
    nums2 = [1]
    assert sol.findMedianSortedArrays(nums1, nums2) == 1.5


if __name__ == '__main__':
    main()
