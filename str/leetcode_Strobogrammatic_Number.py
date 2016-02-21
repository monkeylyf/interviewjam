"""Strobogrammatic
leetcode

A strobogrammatic number is a number that looks the same when rotated 180
degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is
represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
"""


class Solution(object):
    def isStrobogrammatic(self, num):
        """
        :type num: str
        :rtype: bool
        """
        head = 0
        tail = len(num) - 1
        while head <= tail:
            a = num[head]
            b = num[tail]

            head += 1
            tail -= 1
            if a != b:
                if (a == '6' and b == '9') or (a == '9' and b == '6'):
                    continue
                else:
                    return False
            else:
                if a not in ('0', '1', '8'):
                    return False

        return True


def main():
    sol = Solution()
    assert sol.isStrobogrammatic('69')


if __name__ == '__main__':
    main()
