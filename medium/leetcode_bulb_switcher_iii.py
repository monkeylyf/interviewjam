# https://leetcode.com/problems/bulb-switcher-iii/

from typing import List

class Solution:
    def numTimesAllBlue(self, light: List[int]) -> int:
        res = 0
        right_most = 0

        for i, val in enumerate(light, 1):
            right_most = max(right_most, val)
            if right_most == i:
                res += 1

        return res

    def numTimesAllBlueNotWorking(self, light: List[int]) -> int:
        # Union-find.
        if not light:
            return 0

        n = len(light)
        parents = list(range(n + 1))
        sizes = [0] * (n + 1)
        i = 0
        res = 0
        while i < n:
            val = light[i]
            sizes[val] = 1
            if i == 0:
                print('init', parents)
                print('init', sizes)
                if val == 1:
                    res += 1
            else:
                prev = light[i - 1]
                print(f'unioning {prev} {val}')
                print('before', parents)
                print('before', sizes)
                self.union(parents, sizes, prev, val)
                if val <= i + 1:
                    size = sizes[parents[i + 1]]
                    print('check size', size)
                    if size == i + 1:
                        res += 1

            i += 1
        return res

    def union(self, parents, sizes, i, j):
        ii = self.find(parents, i)
        print(f'{i} parent is {ii}')
        jj = self.find(parents, j)
        print(f'{j} parent is {jj}')
        if ii == jj:
            # Already a union.
            return

        if sizes[ii] < sizes[jj]:
            sizes[jj] += sizes[ii]
            parents[i] = jj
            return sizes[jj]
        else:
            sizes[ii] += sizes[jj]
            parents[j] = ii
            return sizes[ii]

    def find(self, parents, i):
        while i != parents[i]:
            parents[i] = parents[parents[i]]
            i = parents[i]
        return i


def main():
    sol = Solution()
    print(sol.numTimesAllBlue([2, 1, 4, 3, 6, 5]))
    print(sol.numTimesAllBlue([4, 1, 2, 3]))
    print(sol.numTimesAllBlue([3, 2, 4, 1, 5]))


if __name__ == '__main__':
    main()
