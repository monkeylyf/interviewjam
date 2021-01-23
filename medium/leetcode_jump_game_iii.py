# https://leetcode.com/problems/jump-game-iii/

from typing import List

class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        if not arr:
            return False

        n = len(arr)
        visited = [False] * n
        queue = [start]
        while queue:
            i = queue.pop()
            val = arr[i]
            if val == 0:
                return True
            visited[i] = True
            if i - val >= 0 and not visited[i - val]:
                queue.append(i - val)
            if i + val < n and not visited[i + val]:
                queue.append(i + val)

        return False


def main():
    sol = Solution()
    print(sol.canReach([4, 2, 3, 0, 3, 1, 2], 5))
    print(sol.canReach([4,2,3,0,3,1,2], 0))
    print(sol.canReach([3,0,2,1,2], 2))


if __name__ == '__main__':
    main()
