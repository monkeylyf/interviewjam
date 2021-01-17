# https://leetcode.com/problems/decode-xored-array/

from typing import List

class Solution:
    def decode(self, encoded: List[int], first: int) -> List[int]:
        if not encoded:
            return []
        n = len(encoded)
        res = [first] * (n + 1)
        for i in range(n):
            res[i + 1] = res[i] ^ encoded[i]
        return res


def main():
    sol = Solution()
    print(sol.decode([1, 2, 3], 1))
    print(sol.decode([6, 2, 7, 3], 4))


if __name__ == '__main__':
    main()
