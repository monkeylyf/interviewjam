# https://leetcode.com/problems/arranging-coins/

class Solution:
    def arrangeCoins(self, n: int) -> int:
        # (1 + n) * n / 2 <= total
        # n^2 + n - 2 * total <= 0
        # n = (-1 + (1 + 8 * total)^0.5) / 2
        return int((pow(1 + 8 * n, 0.5) - 1) // 2)


def main():
    sol = Solution()
    print(sol.arrangeCoins(15))


if __name__ == '__main__':
    main()
