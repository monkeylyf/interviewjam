# https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

from typing import List

class Solution:
    def mctFromLeafValues(self, arr: List[int]) -> int:
        stack = [float('inf')]
        acc = 0
        for i in arr:
            while stack[-1] <= i:
                val = stack.pop()
                acc += val * min(stack[-1], i)
            stack.append(i)

        while len(stack) > 2:
            val = stack.pop()
            acc += val * stack[-1]
        return acc



def main():
    sol = Solution()
    print(sol.mctFromLeafValues([6, 2, 4]))
    print(sol.mctFromLeafValues([7, 12, 8, 10]))


if __name__ == '__main__':
    main()
