# https://leetcode.com/problems/coordinate-with-maximum-network-quality/

from typing import List

from math import dist


class Solution:
    def bestCoordinate(self, towers: List[List[int]], radius: int) -> List[int]:
        if not towers:
            return []
        if len(towers) == 1:
            return [towers[0][0], towers[0][1]]
        min_x = float('inf')
        min_y = float('inf')
        max_x = -float('inf')
        max_y = -float('inf')
        for x, y, _ in towers:
            min_x = min(min_x, x)
            max_x = max(max_x, x)
            min_y = min(min_y, y)
            max_y = max(max_y, y)


        res = None
        max_quality = -float('inf')
        for x in range(min_x, max_x + 1):
            for y in range(min_y, max_y + 1):
                acc = 0
                for xi, yi, q in towers:
                    d = dist([x, y], [xi, yi])
                    if d <= radius:
                        acc += int(q / (1 + d))
                if acc > max_quality:
                    max_quality = acc
                    res = [x, y]
        return res


def main():
    sol = Solution()
    print(sol.bestCoordinate([[1,2,5],[2,1,7],[3,1,9]], 2))


if __name__ == '__main__':
    main()
