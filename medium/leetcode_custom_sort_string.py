# https://leetcode.com/problems/custom-sort-string/

from collections import Counter


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        n = len(T)
        mapping = {c: i for i, c in enumerate(S)}
        res = [None if c in mapping else c for i, c in enumerate(T)]
        c = Counter(T)
        i = 0
        for char in S:
            freq = c.get(char)
            if freq is None:
                continue
            else:
                while i < n and freq > 0:
                    if res[i] is None:
                        res[i] = char
                        freq -= 1
                    i += 1

        return ''.join(res)



def main():
    sol = Solution()
    print(sol.customSortString('cba', 'abcd'))
    print(sol.customSortString('kqep', 'pekeq'))


if __name__ == '__main__':
    main()
