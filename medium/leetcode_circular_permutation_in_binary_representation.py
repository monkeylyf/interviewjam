# https://leetcode.com/problems/circular-permutation-in-binary-representation/

from typing import List


class Solution:
    def circularPermutation(self, n: int, start: int) -> List[int]:
        return [start ^ i ^ (i >> 1) for i in range(1 << n)]


def main():
    sol = Solution()
    print(sol.circularPermutation(2, 3))
    #print(sol.circularPermutation(3, 2))


if __name__ == '__main__':
    main()
