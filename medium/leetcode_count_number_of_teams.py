# https://leetcode.com/problems/count-number-of-teams/

from typing import List

from collections import Counter

class Solution:
    def numTeams(self, rating: List[int]) -> int:
        # N^2.
        n = len(rating)
        smaller_right = [0] * n
        for (i, val) in enumerate(rating):
            j = i
            while j < n:
                if rating[j] < val:
                    smaller_right[i] += 1
                j += 1

        bigger_right = [0] * n
        for (i, val) in enumerate(rating):
            j = i
            while j < n:
                if rating[j] > val:
                    bigger_right[i] += 1
                j += 1

        total = 0

        for i in range(n - 2):
            a = rating[i]
            for j in range(i + 1, n - 1):
                b = rating[j]
                if a > b:
                    total += smaller_right[j]
                if a < b:
                    total += bigger_right[j]

        return total


def main():
    sol = Solution()
    print(sol.numTeams([2, 5, 3, 4, 1]))


if __name__ == '__main__':
    main()
