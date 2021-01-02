# https://leetcode.com/problems/guess-number-higher-or-lower/

# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        start = 1
        end = n
        while start + 1 < end:
            mid = (end - start) // 2 + start
            res = guess(mid)
            if res == 0:
                return mid
            elif res == 1:
                start = mid
            else:
                end = mid
        if guess(start) == 0:
            return start
        else:
            return start + 1
