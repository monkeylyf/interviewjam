# https://leetcode.com/problems/maximum-erasure-value/

from typing import List

class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        if not nums:
            return 0
        n = len(nums)
        seen = set()
        biggest_sum = -float('inf')
        acc = 0
        window_left = 0
        for i in range(n):
            num = nums[i]
            while num in seen:
                boundary_val = nums[window_left]
                acc -= boundary_val
                seen.remove(boundary_val)
                window_left += 1
            seen.add(num)
            acc += num
            if acc > biggest_sum:
                biggest_sum = acc

        return biggest_sum


def main():
    sol = Solution()
    print(sol.maximumUniqueSubarray([4, 2, 4, 5, 6]))
    print(sol.maximumUniqueSubarray([5,2,1,2,5,2,1,2,5]))
    test = [187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,673,299,19,893,817,971,458,409,886,434]

    print(sol.maximumUniqueSubarray(test))

if __name__ == '__main__':
    main()
