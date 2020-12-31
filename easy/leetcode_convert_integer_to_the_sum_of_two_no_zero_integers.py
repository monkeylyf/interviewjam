# https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/

from typing import List

def isNoZeroInt(n) -> bool:
    if n == 0:
        return False
    if n < 10:
        return True

    while n > 0:
        if n % 10 == 0:
            return False
        n = n // 10
    return True


class Solution:
    def getNoZeroIntegers(self, n: int) -> List[int]:
        for i in range(1, n + 1):
            if isNoZeroInt(i) and isNoZeroInt(n - i):
                return [i, n - i]
        return []


def main():
    sol = Solution()
    print(sol.getNoZeroIntegers(11))


if __name__ == '__main__':
    main()
