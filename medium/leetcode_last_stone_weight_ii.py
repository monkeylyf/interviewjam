# https://leetcode.com/problems/last-stone-weight-ii/

from typing import List

class Solution:
    def lastStoneWeightII(self, stones: List[int]) -> int:
        if not stones:
            return 0
        prev = [stones[0]]
        i = 1
        n = len(stones)
        while i < n:
            stone = stones[i]
            cur = set()
            for j in prev:
                cur.add(abs(j - stone))
                cur.add(stone + j)
            prev = cur
            i += 1
        return min(prev)


def main():
    sol = Solution()
    stones = [2,7,4,1,8,1]
    print(sol.lastStoneWeightII(stones))


if __name__ == '__main__':
    main()
