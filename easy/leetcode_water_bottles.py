# https://leetcode.com/problems/water-bottles/submissions/

class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        total = numBottles
        while numBottles >= numExchange:
            (drunk, empty) = divmod(numBottles, numExchange)
            total += drunk
            numBottles = drunk + empty
        return total

def main():
    sol = Solution()
    print(sol.numWaterBottles(15, 4))


if __name__ == '__main__':
    main()
