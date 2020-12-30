# https://leetcode.com/problems/defuse-the-bomb/

from typing import List

class Solution:
    def decrypt(self, code: List[int], k: int) -> List[int]:
        if k == 0:
            return [0] * len(code)
        elif k > 0:
            res = []
            window = sum(code[:k])
            for (i, val) in enumerate(code):
                window = window - val + code[(i + k) % len(code)]
                res.append(window)
            return res
        else:
            res = []
            window = sum(code[k:])
            for (i, val) in enumerate(code):
                res.append(window)
                window = window + val - code[i + k]
            return res


def main():
    sol = Solution()
    print(sol.decrypt([2, 4, 9, 3], -2))
    print(sol.decrypt([5, 7, 1, 4], 3))


if __name__ == '__main__':
    main()
