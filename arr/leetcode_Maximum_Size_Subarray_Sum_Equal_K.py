"""Maximum size subarray sum equal k
leetcode

Given an array nums and a target value k, find the maximum length of a subarray
that sums to k. If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?
"""


class Solution(object):
    def maxSubArrayLen(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        n = len(nums)
        max_length = 0
        acc = 0
        mapping = {}
        # Create acc mapping.
        for i, val in enumerate(nums):
            acc += val
            mapping.setdefault(acc, []).append(i)
            if acc == k:
                max_length = i + 1

        for val, left_idx in mapping.iteritems():
            try:
                right_idx = mapping[k + val]
            except KeyError:
                pass
            else:
                # Assuming val is on the left and target - k is on the right.
                # The smallest index of left must be less than the largest of
                # right.
                if right_idx[-1] - left_idx[0] > max_length:
                    max_length = right_idx[-1] - left_idx[0]
        return max_length


def main():
    sol = Solution()
    assert sol.maxSubArrayLen([1, -1, 5, -2, 3], 3) == 4
    assert sol.maxSubArrayLen([-2, -1, 2, 1], 1) == 2
    assert sol.maxSubArrayLen([-5,8,2,-1,6,-3,7,1,8,-2,7], -4) == 0


if __name__ == '__main__':
    main()
