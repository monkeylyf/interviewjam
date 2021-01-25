# https://leetcode.com/problems/maximum-units-on-a-truck/

from typing import List

class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda x: x[1], reverse=True)
        total = 0
        for num, unit in boxTypes:
            taken = min(truckSize, num)
            total += taken * unit
            truckSize -= taken
            if truckSize <= 0:
                break
        return total


def main():
    sol = Solution()
    print(sol.maximumUnits([[1,3],[2,2],[3,1]], 4))
    print(sol.maximumUnits([[5,10],[2,5],[4,7],[3,9]], 10))


if __name__ == '__main__':
    main()
