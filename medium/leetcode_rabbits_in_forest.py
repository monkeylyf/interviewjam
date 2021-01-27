# https://leetcode.com/problems/rabbits-in-forest/

from typing import List

from collections import Counter

class Solution:
    def numRabbits(self, answers: List[int]) -> int:
        if not answers:
            return 0

        c = Counter(answers)
        total = 0
        for same, freq in c.items():
            div, mod = divmod(freq, same + 1)
            if mod  == 0:
                total += div * (same + 1)
            else:
                total += (div + 1) * (same + 1)

        return total


def main():
    sol = Solution()
    print(sol.numRabbits([0, 0, 1, 1, 1]) == 6)
    print(sol.numRabbits([0, 0, 0, 1, 1]) == 5)
    print(sol.numRabbits([1, 1, 2]) == 5)
    print(sol.numRabbits([10, 10, 10]) == 11)
    print(sol.numRabbits([]) == 0)


if __name__ == '__main__':
    main()
