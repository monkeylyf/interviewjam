# https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

class Solution:
    def countBalls(self, lowLimit: int, highLimit: int) -> int:
        def get_sum(i):
            a = 0
            while i > 0:
                a += i % 10
                i = i // 10
            return a

        mapping = [0] * 46
        max_val = 0
        for num in range(lowLimit, highLimit + 1):
            s = get_sum(num)
            freq = mapping[s] + 1
            if freq > max_val:
                max_val = freq
            mapping[s] = freq
        return max_val


def main():
    sol = Solution()
    print(sol.countBalls(1, 10) == 2)
    print(sol.countBalls(5, 15) == 2)
    print(sol.countBalls(19, 28) == 2)


if __name__ == '__main__':
    main()
