# https://leetcode.com/problems/xor-queries-of-a-subarray/

from typing import List

class Solution:
    def xorQueries(self, arr: List[int], queries: List[List[int]]) -> List[int]:
        n = len(arr)
        acc = [arr[0]] * n
        for i in range(1, n):
            acc[i] = acc[i - 1] ^ arr[i]

        # acc[e] ^ acc[s - 1] = Is ^ Is+1 .. Ie
        return [acc[e] if s == 0 else acc[e] ^ acc[s - 1] for s, e in queries]


def main():
    sol = Solution()
    print(sol.xorQueries([1, 3, 4, 8], [[0,1],[1,2],[0,3],[3,3]]))


if __name__ == '__main__':
    main()
