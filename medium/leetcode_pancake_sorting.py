# https://leetcode.com/problems/pancake-sorting/

from typing import List

class Solution:
    def pancakeSort(self, arr: List[int]) -> List[int]:
        res = []
        for i in reversed(range(2, len(arr) + 1)):
            # Find max and put it at where it should be. Takes two.
            index = arr.index(i)
            res.extend([index + 1, i])
            arr = arr[:index:-1] + arr[:index]
        return res


def main():
    sol = Solution()
    print(sol.pancakeSort([3, 2, 4, 1]))


if __name__ == '__main__':
    main()
