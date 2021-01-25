# https://leetcode.com/problems/calculate-money-in-leetcode-bank/

class Solution:
    def totalMoney(self, n: int) -> int:
        div, mod = divmod(n, 7)
        return (56 + 7 * (div - 1)) * div // 2 + (div + 1 + div + mod) * mod // 2


def main():
    sol = Solution()
    print(sol.totalMoney(4))
    print(sol.totalMoney(10))
    print(sol.totalMoney(20))


if __name__ == '__main__':
    main()
