# https://leetcode.com/problems/kth-largest-element-in-a-stream/

import heapq
from typing import List


class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        heapq.heapify(nums)
        while len(nums) > k:
            heapq.heappop(nums)

        self._nums = nums
        self._k = k

    def add(self, val: int) -> int:
        if len(self._nums) < self._k:
            heapq.heappush(self._nums, val)
        elif val > self._nums[0]:
            heapq.heapreplace(self._nums, val)
        else:
            pass
        return self._nums[0]



# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)
