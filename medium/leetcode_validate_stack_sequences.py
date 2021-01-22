# https://leetcode.com/problems/validate-stack-sequences/

from typing import List

class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        i = 0
        stack = []
        for j, val in enumerate(pushed):
            stack.append(val)
            while stack and stack[-1] == popped[i]:
                i += 1
                stack.pop()

        return len(stack) == 0


def main():
    sol = Solution()
    print(sol.validateStackSequences([1, 2, 3, 4, 5], [4, 5, 3, 2, 1]) == True)
    print(sol.validateStackSequences([1, 2, 3, 4, 5], [4, 3, 5, 1, 2]))


if __name__ == '__main__':
    main()
