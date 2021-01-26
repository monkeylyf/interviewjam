# https://leetcode.com/problems/beautiful-arrangement/


class Solution:
    def countArrangement(self, n: int) -> int:
        arr = list(range(1, n + 1))
        return self.rec(arr, [])

    def rec(self, arr, acc):
        if len(acc) == len(arr):
            return 1

        index = len(acc) + 1
        total = 0
        for i, val in enumerate(arr):
            if val > 0 and (val % index == 0 or index % val == 0):
                arr[i] = -val
                acc.append(val)
                total += self.rec(arr, acc)
                acc.pop()
                arr[i] = val
        return total
