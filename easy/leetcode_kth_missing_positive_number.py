# https://leetcode.com/problems/kth-missing-positive-number/

from typing import List

class Solution:
    def findKthPositive(self, arr: List[int], k: int) -> int:
        prev = 0
        for i in arr:
            missed = i - prev - 1
            if missed > 0 :
                if missed >= k:
                    return prev + k
                else:
                    k -= missed
            prev = i
        return arr[-1] + k

def main():
    sol = Solution()
    #print(sol.findKthPositive([2, 3, 4, 7, 11], 5))
    #print(sol.findKthPositive([2, 3, 4, 7, 11], 7))
    print(sol.findKthPositive([2], 1))


if __name__ == '__main__':
    main()
