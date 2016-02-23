"""Excel sheet column title
leetcode

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB
"""

class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        title = []
        n -= 1
        while n >= 0:
            digit = n % 26
            title.append(chr(ord('A') + digit))
            n = n / 26 - 1
        return ''.join(reversed(title))


def main():
    sol = Solution()
    assert sol.convertToTitle(26) == 'Z'


if __name__ == '__main__':
    main()
