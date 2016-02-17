"""Sparse matrix multiplication
leetcode

Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
"""


class Solution(object):

    def multiply(self, A, B):
        """
        :type A: List[List[int]]
        :type B: List[List[int]]
        :rtype: List[List[int]]
        """
        if A is None or B is None:
            return None
        m = len(A)
        n = len(A[0])
        l = len(B[0])

        if len(B) != n:
            raise Exception('wtf')

        ret = [[0 for _ in xrange(l)] for _ in xrange(m)]
        # Cache all non-zero value by row
        cache = [None for _ in xrange(len(B))]
        for k, row in enumerate(B):
            row_cache = {}
            for j, element in enumerate(row):
                if element:
                    row_cache[j] = element
            if row_cache:
                cache[k] = row_cache

        for i, row in enumerate(A):
            for k, element in enumerate(row):
                if element:
                    cache_row = cache[k]
                    if cache_row:
                        for j, cache_val in cache_row.iteritems():
                            ret[i][j] += element * cache_val
        return ret


def main():
    sol = Solution()
    assert sol.multiply(
        [
            [1,0,0],
            [-1,0,3]
        ],
        [
            [7,0,0],
            [0,0,0],
            [0,0,1]
        ]
    ) == [
            [7, 0, 0],
            [-7, 0, 3]
    ]

    assert sol.multiply(
        [
            [1,-5]
        ],
        [
            [12],
            [-1]
        ]
    ) == [
            [17]
        ]


if __name__ == '__main__':
    main()
