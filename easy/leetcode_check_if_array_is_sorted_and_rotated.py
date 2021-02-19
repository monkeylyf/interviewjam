# https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

class Solution:
    def check(self, nums: List[int]) -> bool:
        if not nums:
            return True

        i = 0
        n = len(nums)

        while i < n:
            if i == n - 1:
                # Sorted and rotated by position 0.
                return True
            elif nums[i] <= nums[i + 1]:
                i += 1
            else:
                break

        if nums[0] < nums[-1]:
            return False

        i += 1
        while i < n - 1 and nums[i] <= nums[i + 1]:
            i += 1

        return i == n - 1
