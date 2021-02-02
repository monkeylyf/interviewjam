# https://leetcode.com/problems/max-number-of-k-sum-pairs/

from typing import List
from collections import Counter

class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        count = 0
        c = Counter(nums)
        for i, freq in c.items():
            counterpart = k - i
            c_freq = c[counterpart]
            count += min(freq, c_freq)
        return count // 2


def main():
    sol = Solution()
    nums = [2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2]
    k = 3
    print(sol.maxOperations(nums, k))


if __name__ == '__main__':
    main()
