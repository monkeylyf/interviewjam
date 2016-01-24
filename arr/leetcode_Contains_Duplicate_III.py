"""Contains duplicate III
leetcode

Given an array of integers, find out whether there are two distinct indices i
and j in the array such that the difference between nums[i] and nums[j] is at
most t and the difference between i and j is at most k.
"""

class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """Bacially the solution is brutal force.

        The array can be sorted by the value, using tuple to bind the value
        and index together to preserve information. Then the loop will stop
        when value diff is larger than t.

        Sorting will help in terms of reducing time complexity but the big O
        is same as without sorting. When t is large enough, larger than
        max(nums) - min(nums) then sorting is of no help.

        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        bundle = sorted((val, i) for i, val in enumerate(nums))

        for i in xrange(len(bundle)):
            j = i + 1
            while j < len(bundle) and bundle[j][0] - bundle[i][0] <= t:
                if abs(bundle[i][1] - bundle[j][1]) <= k:
                    return True
                j += 1
        return False


def main():
    sol = Solution()



if __name__ == '__main__':
    main()
