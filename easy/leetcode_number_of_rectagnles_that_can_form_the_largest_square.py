# https://leetcode.com/problems/number-of-rectangles-that-can-form-the-largest-square/

from typing import List

class Solution:
    def countGoodRectangles(self, rectangles: List[List[int]]) -> int:
        max_val = -float('inf')
        count = 0

        for i in (min(r) for r in rectangles):
            if i > max_val:
                max_val = i
                count = 1
            elif i == max_val:
                count += 1
            else:
                pass

        return count


def main():
    sol = Solution()
    print(sol.countGoodRectangles([[5,8],[3,9],[5,12],[16,5]]))


if __name__ == '__main__':
    main()
