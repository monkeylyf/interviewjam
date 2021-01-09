# https://leetcode.com/problems/find-and-replace-pattern/

from typing import List


def unifiy(s):
    seen = {}
    i = 0
    value = 0
    for c in s:
        code = seen.get(c)
        if code is None:
            seen[c] = i
            code = i
            i += 1
        value += value * 10 + code
    return value


class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        res = []
        p = unifiy(pattern)
        for word in words:
            u = unifiy(word)
            if u == p:
                res.append(word)
        return res



def main():
    sol = Solution()
    print(sol.findAndReplacePattern(["abc","deq","mee","aqq","dkd","ccc"], 'abb'))


if __name__ == '__main__':
    main()
