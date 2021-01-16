# https://leetcode.com/problems/reduce-array-size-to-the-half/

from collections import Counter
from typing import List

class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        c = Counter(arr)
        a = [i for i in c.values()]
        a.sort(reverse=True)
        half = (len(arr) + 1) // 2
        acc = 0
        count = 0
        i = 0
        while acc < half and i < len(a):
            acc += a[i]
            count += 1
            i += 1
        return count


def main():
    sol = Solution()
    #print(sol.minSetSize([3, 3, 3, 3, 5, 5, 5, 2, 2, 7]))
    print(sol.minSetSize([9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19]))


if __name__ == '__main__':
    main()
