# https://leetcode.com/problems/find-the-most-competitive-subsequence/

from typing import List

class Solution:
    def mostCompetitive(self, nums: List[int], k: int) -> List[int]:
        stack = []
        n = len(nums)
        length = 0
        for i, num in enumerate(nums):
            while stack and stack[-1] > num and length + n - i - 1 >= k:
                stack.pop()
                length -= 1

            if len(stack) < k:
                stack.append(num)
                length += 1

        return stack


def main():
    sol = Solution()
    nums = [2,4,3,3,5,4,9,6]
    k = 4
    #print(sol.mostCompetitive(nums, k))
    nums = [3, 5, 2, 6]
    k = 2
    print(sol.mostCompetitive(nums, k))


if __name__ == '__main__':
    main()
