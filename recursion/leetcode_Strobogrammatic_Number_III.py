"""Strobogrammatic number III
leetcode

A strobogrammatic number is a number that looks the same when rotated 180
degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the
range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three
strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are
represented as string.
"""


class Solution(object):

    PAIRS = (('0', '0'), ('1', '1'), ('8', '8'), ('6', '9'), ('9', '6'))
    PAIRS_WO_ZEROS = (('1', '1'), ('8', '8'), ('6', '9'), ('9', '6'))
    SYMETRIC = ('1', '8', '0')

    def strobogrammaticInRange(self, low, high):
        """
        :type low: str
        :type high: str
        :rtype: int
        """
        count = 0
        for length in xrange(len(low), len(high) + 1):
            count += self.dfs(low, high, [None] * length, 0, length - 1)
        return count

    def dfs(self, low, high, acc, head, tail):
        if head > tail:
            val = int(''.join(acc))
            if (len(acc) == len(low) and val < int(low)) or \
               (len(acc) == len(high) and val > int(high)):
                return 0
            else:
                return 1
        elif head == tail:
            count = 0
            for c in Solution.SYMETRIC:
                acc[head] = c
                count += self.dfs(low, high, acc, head + 1, tail - 1)
            return count
        else:
            count = 0
            pairs = Solution.PAIRS_WO_ZEROS if head == 0 else Solution.PAIRS

            for s, e in pairs:
                acc[head] = s
                acc[tail] = e
                count += self.dfs(low, high, acc, head + 1, tail - 1)
            return count


def main():
    sol = Solution()
    assert sol.strobogrammaticInRange('0', '0') == 1


if __name__ == '__main__':
    main()
