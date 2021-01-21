# https://leetcode.com/problems/daily-temperatures/

from typing import List

class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        if not T:
            return []

        n = len(T)
        res = [0] * n
        stack = []

        for i, t in enumerate(T):
            while stack and T[stack[-1]] < t:
                last_index = stack.pop()
                res[last_index] = i - last_index

            stack.append(i)

        return res


def main():
    sol = Solution()
    print(sol.dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))


if __name__ == '__main__':
    main()
