# https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

FIB = [
        1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377,
        610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657,
        46368, 75025, 121393, 196418, 317811, 514229, 832040,
        1346269, 2178309, 3524578, 5702887, 9227465, 14930352,
        24157817, 39088169, 63245986, 102334155, 165580141,
        267914296, 433494437, 701408733]

class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        count = 0
        fib = FIB
        for i in range(len(FIB) - 1, -1, -1):
            val = fib[i]
            if k >= val:
                k -= val
                count += 1
                if k == 0:
                    break
        return count
