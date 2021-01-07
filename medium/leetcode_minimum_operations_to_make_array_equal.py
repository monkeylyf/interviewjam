# https://leetcode.com/problems/minimum-operations-to-make-array-equal/

class Solution:
    def minOperations(self, n: int) -> int:
        i = n // 2
        if n % 2 == 1:
            # n = 5
            # 1 3 5 7 9
            # 4 + 2 + 0
            return i * (i + 1)
        # 1 3 5 7
        else:
            # n = 6
            # 1 3 5 7 9 11
            # 5 + 3 + 1
            return i * i


def main():
    sol = Solution()
    print(sol.minOperations(3))


if __name__ == '__main__':
    main()
