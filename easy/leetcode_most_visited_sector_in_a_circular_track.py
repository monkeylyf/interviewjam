# https://leetcode.com/problems/most-visited-sector-in-a-circular-track/

from typing import List

class Solution:
    def mostVisited(self, n: int, rounds: List[int]) -> List[int]:
        if not rounds and len(rounds) == 1:
            return []

        # Forget about how many rounds but focus on the head/tail sectors.
        start = rounds[0]
        end = rounds[-1]

        if end >= start:
            return list(range(start, end + 1))
        else:
            return list(range(1, end + 1)) + list(range(start, n + 1))


def main():
    sol = Solution()
    print(sol.mostVisited(4, [1, 3, 1, 2]))
    print(sol.mostVisited(3, [3, 3, 1, 1]))


if __name__ == '__main__':
    main()
