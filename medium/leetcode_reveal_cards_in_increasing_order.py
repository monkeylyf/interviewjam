# https://leetcode.com/problems/reveal-cards-in-increasing-order/

from typing import List
from collections import deque


class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        d = deque()
        deck.sort(reverse=True)
        for x in deck:
            d.rotate()
            d.appendleft(x)
        return list(d)


def main():
    sol = Solution()
    print(sol.deckRevealedIncreasing([17, 13, 11, 2, 3, 5, 7]))


if __name__ == '__main__':
    main()
