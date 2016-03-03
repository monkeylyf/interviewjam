"""Different ways to add parentheses
leetcode

Given a string of numbers and operators, return all possible results from
computing all the different possible ways to group numbers and operators.
The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
"""


class Solution(object):
    def diffWaysToCompute(self, expression):
        """DP.

        Parse the expression first into tokens and operators.
        dp[i][j] represents all possible results from ith number to jth.
        I. i == j, dp[i][j] = tokens[i]
        II. i < j, dp[i][j] = dp[i][k] multiply dp[k][j] where k falls in [i, j)

        :type input: str
        :rtype: List[int]
        """
        lambdas = {
            '+': lambda x, y : x + y,
            '-': lambda x, y : x - y,
            '*': lambda x, y : x * y
        }
        operators = ('+', '-', '*')

        # Parse.
        i = 0
        j = 0
        tokens = []
        ops = []
        while i < len(expression) and j < len(expression):
            if expression[j] not in operators:
                j += 1
            else:
                tokens.append(int(expression[i:j]))
                ops.append(expression[j])
                j += 1
                i = j

        tokens.append(int(expression[i:j]))
        n = len(tokens)

        dp = [[None for _ in xrange(n)] for _ in xrange(n)]
        for span in xrange(n):
            for i in xrange(n - span):
                if span == 0:
                    dp[i][i + span] = [tokens[i]]
                else:
                    combinations = []
                    for j in xrange(i, i + span):
                        func = lambdas[ops[j]]
                        for a in dp[i][j]:
                            for b in dp[j + 1][i + span]:
                                combinations.append(func(a, b))
                    dp[i][i + span] = combinations

        return dp[0][n - 1]


def main():
    sol = Solution()
    assert sol.diffWaysToCompute("2-1-1") == [2, 0]
    assert sol.diffWaysToCompute("2*3-4*5") == [-34, -10, -14, -10, 10]


if __name__ == '__main__':
    main()
