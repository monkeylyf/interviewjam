"""Increasing Triplet Subsequence
leetcode

Given an unsorted array return whether an increasing subsequence of length 3
exists or not in the array.

Formally the function should:
Return true if there exists i, j, k
such that arr[i] < arr[j] < arr[k] given 0 <= i < j < k <= n-1 else return
false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
"""


class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        first_min = float('+inf')
        second_min = float('+inf')
        for num in nums:
            if num > second_min:
                return True
            elif num <= first_min:
                # Update smallest. Note that this will break the relation
                # between first smallest and second smallest because they are
                # no longer in order. For example, [3, 2, 1, 4, 0, 5], before
                # visiting 0, the first smallest is 1 and second is 4, when
                # visiting 0, the first smallest will be updated to 0 but 0 is
                # actually on the right side of 4. But that does not hurt to
                # tell *whether* there is a triplets other than what this
                # triplet is.
                first_min = num
            elif num < second_min:
                second_min = num
            else:
                pass
        return False


def main():
    sol = Solution()
    assert sol.increasingTriplet([1, 2, 3, 4, 5])
    assert not sol.increasingTriplet([5, 4, 3, 2, 1])
    assert sol.increasingTriplet([3, 2, 1, 4, 0, 5])


if __name__ == '__main__':
    main()
