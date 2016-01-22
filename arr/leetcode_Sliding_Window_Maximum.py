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
        """Return sequence of max value of all slicding windows from left to right.

        1. Use deque for window so popleft is really O(1). For list it's O(n)
        2. Keep tracking max window value. If the element is about to enqueue is
           larger or equal than max value, update max value. If the element is about
           to be dequed is equal to max value, do the max for new window

        The worst case is O(kn), e.g., [5, 4, 3, 2, 1] because every time you move the
        window, the popped one is max value of current window then max will be called
        If Queue.PriofityQueue is used to keep track of window, you can have max with
        O(n), but it's hard to remove element by it's index.

        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        if not nums:
            return []

        if len(nums) < k:
            raise ValueError('Invalid window size: {}'.format(k))

        window = deque(nums[:k])
        current_max = max(window)
        max_windows = [current_max]

        for i, val in enumerate(nums, start=k):
            popped = window.popleft()
            window.append(val)
            if val >= current_max:
                current_max = val
            elif popped == current_max:
                current_max = max(window)
            else:
                pass

            max_windows.append(current_max)

        return max_windows[k:]


def main():
    sol = Solution()
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    assert sol.maxSlidingWindow(nums, k) == [3, 3, 5, 5, 6, 7]


if __name__ == '__main__':
    main()
