"""Contains duplicate II
leetcode

Given an array of integers and an integer k, find out whether there are two
distinct indices i and j in the array such that nums[i] = nums[j] and the
difference between i and j is at most k.
"""


class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        mapping = {}
        for i, val in enumerate(nums):
            indexes = mapping.get(val, [])
            if indexes and i - indexes[-1] <= k:
                return True
            else:
                indexes.append(i)
                mapping[val] = indexes

        return False


def main():
    sol = Solution()
    assert sol.containsNearbyDuplicate([-1, -1], 1)


if __name__ == '__main__':
    main()
