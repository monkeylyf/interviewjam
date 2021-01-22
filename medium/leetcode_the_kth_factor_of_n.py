# https://leetcode.com/problems/the-kth-factor-of-n/

class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        if n == 1 or k == 1:
            return 1

        factors = [1]
        i = 2
        found_or_finished = False

        while not found_or_finished:
            if n % i == 0:
                factors.append(i)
            found_or_finished = len(factors) == k or n // 2 < i
            i += 1
        if k == len(factors):
            return factors[-1]
        elif k == len(factors) + 1:
            factors.append(n)
            return factors[(k - 1) % len(factors)]
        else:
            return -1


def main():
    sol = Solution()
    print(sol.kthFactor(12, 3) == 3)
    print(sol.kthFactor(7, 2) == 7)
    print(sol.kthFactor(4, 4) == -1)
    print(sol.kthFactor(1000, 3) == 4)
    print(sol.kthFactor(1000, 3) == 4)
    print(sol.kthFactor(4, 1) == 1)


if __name__ == '__main__':
    main()
