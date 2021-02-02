# https://leetcode.com/problems/ways-to-make-a-fair-array/

from typing import List

class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        if not nums:
            return 0

        n = len(nums)
        if n == 1:
            return 1
        if n == 2:
            return 0

        is_even = n % 2 == 0
        acc = [0] * n
        for i in range(n):
            if i == 0 or i == 1:
                acc[i] = nums[i]
            else:
                acc[i] = nums[i] + acc[i - 2]

        count = 0
        even_last = acc[-2] if is_even else acc[-1]
        odds_last = acc[-1] if is_even else acc[-2]
        for i in range(n):
            if i % 2 == 0:
                left_odds = acc[i - 1] if i > 0 else 0
                left_even = acc[i - 2] if i > 0 else 0
                right_odds = even_last - acc[i]
                right_even = odds_last - left_odds
            else:
                left_odds = acc[i - 2] if i > 1 else 0
                left_even = acc[i - 1]
                right_odds = even_last - left_even
                right_even = odds_last - acc[i]
            if left_even + right_even == left_odds + right_odds:
                count += 1
        return count


def main():
    sol = Solution()
    print(sol.waysToMakeFair([2, 1, 6, 4]) == 1)
    print(sol.waysToMakeFair([1, 1, 1]) == 3)
    print(sol.waysToMakeFair([1, 2, 3]) == 0)


if __name__ == '__main__':
    main()
