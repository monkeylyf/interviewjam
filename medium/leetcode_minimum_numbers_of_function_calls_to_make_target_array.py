# https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/

from typing import List


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        if not nums:
            return 0

        n = len(nums)
        count = 0

        while any(nums):
            all_zero = True
            for i, val in enumerate(nums):
                if val % 2 == 1:
                    nums[i] = val - 1
                    count += 1
                if all_zero and nums[i] > 0:
                    all_zero = False

            if not all_zero:
                count += 1
                for i, val in enumerate(nums):
                    nums[i] = val // 2

        return count


def main():
    sol = Solution()
    print(sol.minOperations([3, 2, 2, 4]))
    print(sol.minOperations([2, 4, 6, 8]))
    print(sol.minOperations([7,4,3,2,0,2]))



if __name__ == '__main__':
    main()
