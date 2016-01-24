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
            try:
                indexes = mapping[val]
                for index in indexes:
                    if i - index <= k:
                        return True
                indexes.append(i)
            except KeyError:
                mapping[val] = [i]

        return False


def main():
    sol = Solution()
    assert sol.containsNearbyDuplicate([-1, -1], 1)


if __name__ == '__main__':
    main()
