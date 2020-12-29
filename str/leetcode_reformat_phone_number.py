# https://leetcode.com/problems/reformat-phone-number

class Solution:
    def reformatNumber(self, number: str) -> str:
        a = [i for i in number if i.isnumeric()]
        formatted = []
        i = 0
        n = len(a)
        while i < n:
            remain = n - i
            if remain > 4:
                formatted.extend(a[i:i+3])
                formatted.append("-")
                i += 3
            elif remain == 4:
                formatted.extend(a[i:i+2])
                formatted.append("-")
                formatted.extend(a[i + 2:i+4])
                break
            else:
                formatted.extend(a[i:])
                break
        return ''.join(formatted)
