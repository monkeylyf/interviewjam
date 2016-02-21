"""Strobogrammatic number II
leetcode

A strobogrammatic number is a number that looks the same when rotated 180
degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
"""


class Solution(object):

    def findStrobogrammatic(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        container = []
        half = n / 2
        self.solve([None] * half, [None] * half, 0, n, container)
        return container

    def solve(self, head, tail, i, n, container):
        if 2 * i == n:
            container.append(''.join(head) + ''.join(tail))
        elif 2 * i + 1 == n:
            for mid in ('0', '1', '8'):
                container.append(''.join(head) + mid + ''.join(tail))
        else:
            if i == 0:
                pairs = (('1', '1'), ('8', '8'), ('6', '9'), ('9', '6'))
            else:
                pairs = (('0', '0'), ('1', '1'), ('8', '8'), ('6', '9'), ('9', '6'))

            for a, b in pairs:
                head[i] = a
                tail[-i - 1] = b  # Assignment in reversed order.
                self.solve(head, tail, i + 1, n, container)


def main():
    sol = Solution()
    assert sol.findStrobogrammatic(1) == ['0', '1', '8']
    assert sol.findStrobogrammatic(2) == ['11', '88', '69', '96']


if __name__ == '__main__':
    main()
