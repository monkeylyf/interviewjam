# https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/

import string

def getFiller(left, right):
    for c in string.ascii_lowercase:
        if left is not None and c == left:
            continue
        if right is not None and c == right:
            continue
        return c
    raise ValueError()


class Solution:
    def modifyString(self, s: str) -> str:
        n = len(s)
        res = [None] * n
        for (i, val) in enumerate(s):
            if val != '?':
                res[i] = val
            else:
                left = res[i - 1] if i > 0 else None
                right = s[i + 1] if i + 1 < n and s[i + 1] != '?' else None
                filler = getFiller(left, right)
                res[i] = filler
        return ''.join(res)

def main():
    sol = Solution()
    print(sol.modifyString("??yw?ipkj?"))


if __name__ == '__main__':
    main()
