# https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

class Solution:
    def getSmallestString(self, n: int, k: int) -> str:
        res = []
        while n > 0:
            if (n - 1) * 26  + 1 >= k:
                res.append('a')
                k -= 1
            elif n * 26 == k:
                k -= 26
                res.append('z')
            else:
                i = k - (n - 1) * 26
                res.append(chr(i + 96))
                k -= i
            n -= 1
        return ''.join(res)
