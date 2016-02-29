"""Patching array
leetcode

Given a sorted positive integer array nums and an integer n, add/patch elements
to the array such that any number in range [1, n] inclusive can be formed by the
sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.
"""


class Solution(object):
    def minPatches(self, nums, n):
        """Return min patches required.

        Ideally, a sequence like 1, 2, 4, 8, 16... is the one that can form
        any numbers with [1, sum(seq)], but the fact is given array is not
        guaranteed to be ideal.
        However, when coming up with this sequence, it's intuitive that the
        next number in the sequence is sum(existing sequence) + 1. Why?
        sum(existing sequence), defined as reach the code, as with range
        [1, reach] can be formed by the sum of some elements in the sequence.
        In order to make reach + 1 available, reach + 1 *MUST* be the new patch
        in order to keep the patch number minimum(otherwise you can break it
        down to several small numbers to make it work).

        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0

        # Longest reach that numbers in [1, reach] can be formed.
        reach = 0
        # Number of patches needed.
        patch = 0
        for i, val in enumerate(nums):
            while val > reach + 1:
                # For the first loop, nums[0] must be 1 otherwise it will be
                # added as a patch.
                # Add reach + 1 as patch.
                reach += reach + 1
                patch += 1
                if reach >= n:
                    return patch

            reach += val
            if reach >= n:
                return patch

        # After taking care of all given numbers we can do 1, 2, 4, 8..tricks
        while reach < n:
            reach += reach + 1
            patch += 1
        return patch


def main():
    sol = Solution()
    assert sol.minPatches([1, 5, 10], 20) == 2
    assert sol.minPatches([1, 5, 10], 0) == 0
    assert sol.minPatches([1, 3], 6) == 1
    assert sol.minPatches([1, 2, 2], 5) == 0
    assert sol.minPatches([1, 7, 21, 31, 34, 37, 40, 43, 49, 87, 90, 92, 93, 98, 99], 12) == 2


if __name__ == '__main__':
    main()
