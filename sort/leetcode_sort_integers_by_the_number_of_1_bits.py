# https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

from typing import List
import functools

def comp(a, b):
    aa = count_one(a)
    bb = count_one(b)
    if aa != bb:
        return aa - bb
    else:
        return a- b


def count_one(a):
    ones = 0
    while a > 0:
        if a % 2 == 1:
            ones += 1
        a = a // 2

    return ones


class Solution:
    def sortByBits(self, arr: List[int]) -> List[int]:
        return sorted(arr, key=lambda x: (bin(x).count('1'), x))
        #arr.sort(key=functools.cmp_to_key(comp))
        #return arr



def main():
    sol = Solution()
    print(sol.sortByBits([0,1,2,3,4,5,6,7,8]))


if __name__ == '__main__':
    main()
