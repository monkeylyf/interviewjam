"""H index
leetcode

Given an array of citations (each citation is a non-negative integer) of a
researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if
h of his/her N papers have at least h citations each, and the other N - h papers
have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5
papers in total and each of them had received 3, 0, 6, 1, 5 citations
respectively. Since the researcher has 3 papers with at least 3 citations each
and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as
the h-index.
"""

from collections import defaultdict


class Solution(object):
    def hIndexnlgn(self, citations):
        """O(nlgn) solution.

        :type citations: List[int]
        :rtype: int
        """
        citations.sort(reverse=True)
        i = 0
        while i < len(citations) and i + 1 <= citations[i]:
            i += 1
        return i

    def hIndex(self, citations):
        """O(n) solution.

        Most certainly you need to check the relationship:
        left: i
        right: num of var that is >= i.
        if left <= right, i is a potential candidate. And we want the max
        possible i.
        What's the range of i? [0, n]
        Lower bound is 0, natually, meaning no numbers satisfied, for example
        [-1, 0]. Upper bound is n, quite obviously. Given n numbers and there
        is no way to find more than n numbers in it is larger than any number.
        Given the range, we can make the solution O(n) by using a bucket sort
        approach.

        It doesn't matter whether numbers are positive or negative even the
        question states that all are positive.

        1. Get the count for each element.
        2. Get the count of all non-positive numbers.
        3. Iterate from 1 to n, if # of elements that are larger than i, keep
           moving. Else, stop, the previous number is what we need

        Thanks for Marcin interviewed me with this. I kinda knew sort is an
        overkill but never thought of bucket sort will make it O(n).
        """
        n = len(citations)
        counter = defaultdict(int)
        acc = 0
        for citation in citations:
            counter[citation] += 1
            if citation <= 0:
                acc += 1

        i = 1
        while i <= n:
            if n - acc < i:
                break
            acc += counter[i]
            i += 1

        return i - 1


def main():
    sol = Solution()
    assert sol.hIndex([100]) == 1
    assert sol.hIndex([0]) == 0
    assert sol.hIndex([]) == 0
    assert sol.hIndex([3, 0, 6, 1, 5]) == 3
    assert sol.hIndex([3, 3, 3]) == 3
    assert sol.hIndex([-3, -3, -3]) == 0


if __name__ == '__main__':
    main()
