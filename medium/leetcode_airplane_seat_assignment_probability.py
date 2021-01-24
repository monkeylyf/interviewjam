# https://leetcode.com/problems/airplane-seat-assignment-probability/

class Solution:
    def nthPersonGetsNthSeat(self, n: int) -> float:
        if n == 1:
            return 1
        else:
            # Math problem requires proves that when n >= 2, the probability is always 0.5.
            return 0.5


def main():
    sol = Solution()
    print(sol.nthPersonGetsNthSeat(1))


if __name__ == '__main__':
    main()
