# https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence

class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        n = len(arr)
        if n <= 2:
            return True
        arr.sort()

        step = None
        for i in range(n - 1):
            cur_step = arr[i + 1] - arr[i]
            if step is None:
                step = cur_step
            elif step != cur_step:
                return False
            else:
                pass
        return True
