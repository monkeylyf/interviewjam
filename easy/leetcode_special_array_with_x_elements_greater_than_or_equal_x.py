# https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

from typing import List

class Solution:
    def specialArray(self, nums: List[int]) -> int:
        if not nums:
            return -1

        nums.sort()
        n = len(nums)

        for i in range(1, n + 1):
            # Iterate from [1, n] and check boundary. 
            # For i = n only check the right boundary.
            if i <= nums[n - i] and (i == n or nums[n - i - 1] < i):
                return i
        return -1


def main():
    sol = Solution()
    print(sol.specialArray([3, 5]))
    print(sol.specialArray([0, 4, 3, 0, 4]))
    print(sol.specialArray([0, 0]))
    print(sol.specialArray([3, 6, 7, 7, 0]))


if __name__ == '__main__':
    main()
