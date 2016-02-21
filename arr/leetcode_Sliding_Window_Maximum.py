"""Sliding window maximum
leetcode

Given an array nums, there is a sliding window of size k which is moving from
the very left of the array to the very right. You can only see the k numbers in
the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].
"""


from collections import deque


class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """Keep queue monotone decreasing with val that idx pointing to"""
        max_mindow = []
        if k <= 0:
            return max_mindow
        queue = deque()
        for i, val in enumerate(nums):
            while queue and val > nums[queue[-1]]:
                # Remove all vals idx pointting that are less than val.
                queue.pop()

            queue.append(i)

            if i - queue[0] + 1 > k:
                # Pop current max if it's no longer in the window.
                queue.popleft()
            if i >= k - 1:
                max_mindow.append(nums[queue[0]])
        return max_mindow


def main():
    sol = Solution()
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    assert sol.maxSlidingWindow(nums, k) == [3, 3, 5, 5, 6, 7]


if __name__ == '__main__':
    main()
