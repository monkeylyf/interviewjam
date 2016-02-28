"""Kth largest element in an array.
leetcode

Find the kth largest element in an unsorted array. Note that it is the kth
largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.
"""


class Solution(object):

    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        def partition(nums, start, end):
            """Partition the array with pivot.

            :param nums: list
            :param start: int, start idx
            :param end: int, end idx
            """
            # You can use a fancy algorithm to pick the right pivot or you can
            # do just like me to pick the first one.
            pivot = nums[start]
            # I cannot remember this two pointer swapping code most of the time
            # Swap first and last.
            nums[start], nums[end] = nums[end], nums[start]
            for i in xrange(start, end):
                if nums[i] <= pivot:
                    nums[start], nums[i] = nums[i], nums[start]
                    start += 1
            nums[start], nums[end] = nums[end], nums[start]
            return start

        def quick_sort(nums, start, end):
            """Quick sort.

            Irrelevant to this question but it's a quick practice and also show
            that the quick find is a variation of quick sort using quick
            partition.
            """
            if start >= end:
                return
            else:
                pivot = partition(nums, start, end)
                quick_sort(nums, start, pivot - 1)
                quick_sort(nums, pivot + 1, end)

        def find_kth_largest(nums, start, end, k):
            """"""
            pivot = partition(nums, start, end)
            if pivot == k:
                return nums[pivot]
            elif pivot < k:
                # Go right
                return find_kth_largest(nums, pivot + 1, end, k)
            else:
                # Go left.
                return find_kth_largest(nums, start, pivot - 1, k)

        if k < 0 or len(nums) < k:
            raise ValueError('Invalid k: {}'.format(k))
        else:
            return find_kth_largest(nums, 0, len(nums) - 1, len(nums) - k)


def main():
    sol = Solution()
    nums = [3, 2, 1, 5, 6, 4]

    assert sol.findKthLargest(nums[:], 1) == 6
    assert sol.findKthLargest(nums[:], 2) == 5
    assert sol.findKthLargest(nums[:], 3) == 4
    assert sol.findKthLargest(nums[:], 4) == 3
    assert sol.findKthLargest(nums[:], 5) == 2
    assert sol.findKthLargest(nums[:], 6) == 1


if __name__ == '__main__':
    main()
