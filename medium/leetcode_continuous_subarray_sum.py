# https://leetcode.com/problems/continuous-subarray-sum/

from typing import List

class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        if n < 2:
            return False
        if abs(k) == 1:
            return True

        i = 0
        while i < len(nums) - 1:
            if nums[i] == 0 and nums[i + 1] == 0:
                return True
            i += 1
        if k == 0:
            return False

        n = len(nums)
        prev = nums[0] % k
        remains = set([prev])
        i = 1
        while i < n:
            val = nums[i]
            if val % k != 0:
                remain = (prev + val) % k
                if remain == 0:
                    return True
                if remain in remains:
                    return True
                remains.add(remain)
                prev = remain
            i += 1
        return False


def main():
    sol = Solution()
    #print(sol.checkSubarraySum([23, 2, 4, 6, 7], 6))
    #print(sol.checkSubarraySum([23, 2, 6, 4, 7], 6))
    #print(sol.checkSubarraySum([1, 0], 2))
    # print(sol.checkSubarraySum([0, 0], -1))
    #print(sol.checkSubarraySum([1, 2, 12], 6))
    #print(sol.checkSubarraySum([0, 1, 0], 6))
    print(sol.checkSubarraySum([1, 2, 3], 5))


if __name__ == '__main__':
    main()
