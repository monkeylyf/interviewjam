# https://leetcode.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

from typing import List


class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        # The key word is 'disjoint subsequences'
        # Then '(' at odd index must be nested and ')' at even index must be nested as well,
        # in even depth, say level 2, 4 etc.
        # If not it's not sufficient to be not nested. say '((()))'
        # By marking nested parentheses nested in even depth, we are extracting a disjoint
        # subsequence so that depth difference is at most one.
        res = []
        for i, c in enumerate(seq):
            if c == '(':
                res.append(1 if i % 2 == 1 else 0)
            else:
                res.append(1 if i % 2 == 0 else 0)
        return res


def main():
    sol = Solution()
    print(sol.maxDepthAfterSPlit('(()())'))
    print(sol.maxDepthAfterSPlit('()(())()'))


if __name__ == '__main__':
    main()
