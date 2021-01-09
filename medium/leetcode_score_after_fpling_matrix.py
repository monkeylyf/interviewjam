# https://leetcode.com/problems/score-after-flipping-matrix/

from typing import List

class Solution:
    def matrixScore(self, A: List[List[int]]) -> int:
        # Greedy approach.
        if not A:
            return 0
        n = len(A)
        m = len(A[0])

        # Greedy flip first col if all 0.
        if not any(A[i][0] for i in range(n)):
            for i in range(n):
                A[i][0] = 1

        # Greedy flip each row if row[0] is 0
        for row in A:
            if row[0] == 0:
                # Flip row.
                for (i, val) in enumerate(row):
                    if val == 0:
                        row[i] = 1
                    else:
                        row[i] = 0


        # Greedy flip rest of row if 0's are more than 1's
        for j in range(0, m):
            ones = 0
            for i in range(0, n):
                if A[i][j] == 1:
                    ones += 1
            if ones < n - ones:
                # Flip.
                for i in range(0, n):
                    val = A[i][j]
                    A[i][j] = 1 if val == 0 else 0

        def get_val(row):
            total = 0
            base = 1
            for i in reversed(row):
                total += i * base
                base = base * 2
            return total

        res = 0
        for row in A:
            res += get_val(row)
            print(res)
        return res


def main():
    sol = Solution()
    matrix = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
    print(sol.matrixScore(matrix))


if __name__ == '__main__':
    main()
