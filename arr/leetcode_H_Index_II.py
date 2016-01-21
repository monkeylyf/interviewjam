"""H indxe II
leetcode


What if the citations array is sorted in ascending order? Could you optimize your algorithm?
"""


class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if len(citations) == 0:
            return 0

        h_idx = 0
        i = len(citations) - 1
        while i >= 0 and h_idx + 1 <= citations[i]:
            i -= 1
            h_idx += 1
        return h_idx


def main():
    sol = Solution()


if __name__ == '__main__':
    main()
