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

    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """Bucket sort approach. O(n) time complexity.

        The maximal diff will be t, so a range size can be set to t + 1 so
        [0, t] will fall into the same bucket at idx 0 bucause 0 / t + 1 ==
        t / t + 1 = 0. Given a number, the candiate will be either in the same
        bucket or in the neighbor buckets. So check three buckets.
        Since the max index diff is k so it's a sliding window and an index
        fall out of the window, delete it from the buckets.

        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if t < 0:
            return False
        buckets = {}
        b_size = t + 1  # Bucket size.
        for i, val in enumerate(nums):
            if i > k:
                passed_idx = nums[i - k - 1] / b_size
                del buckets[passed_idx]
            b_idx = val / b_size
            if b_idx in buckets or \
               b_idx - 1 in buckets and abs(val - buckets[b_idx - 1]) <= t or \
               b_idx + 1 in buckets and abs(val - buckets[b_idx + 1]) <= t:
                return True
            buckets[b_idx] = val
        return False


def main():
    sol = Solution()
    nums = [2, 7, 3]
    assert sol.containsNearbyAlmostDuplicate(nums, 1, 4)


if __name__ == '__main__':
    main()
