# Mathematical_Epxression
# checkio
#
# Given a string representing a couple of numbers
# e.g., '595347', a combination of its digits is a mathematical expression
# that is made according to the following rules.
# 
#     1. Digits of the number can be split into a number of groups.
#     2. It's not allowed to change the order of groups or the order of digits in
#     the groups.
#     3. Each group is treated as one integer number.
#     4. Operation signs (+, -, * and /) are placed between the groups.
#     5. Parenthesis are placed around subexpressions to eliminate any ambiguity
#     in evaluation order.
# Then '595347' can get 100 by '(5 + ((9 / (3 / 34)) - 7)) = 100', then return false
# Otherwise return true


def checkio(data):
    def add_four(s, left, right, num):
        # :param s: set, cur dp status 
        # :param left: set, left expression dp status
        # :param right: set, right expression dp status
        # :param num: str, num

        # add the number itself.
        s.add(int(num))
        # loop over all possible combination of 
        for i, j in [ (i, j) for i in left for j in right ]:
            s.add(i + j)
            s.add(i - j)
            s.add(i * j)
            if j != 0:
                s.add(i / j)
    n = len(data)
    # init dp state
    # dp[i][j] reprensents results of all possible mathematical expression.
    dp = [ [ set() for _ in range(n) ] for _ in range(n) ]
    for width in range(n):
        i = 0
        j = width
        while j < n:
            if i == j:
                # single number. 
                dp[i][j].add(int(data[i]))
            elif i == j - 1:
                # two numbers.
                add_four(dp[i][j], dp[i][i], dp[j][j], data[i:j + 1])
            else:
                # Three and more than Three numbers.
                
                # (others) _ (last one)
                add_four(dp[i][j], dp[i][j - 1], dp[j][j], data[i:j + 1])
                # (1) _ (others)
                add_four(dp[i][j], dp[i][i], dp[i + 1][j], data[i:j + 1])
                # (first two) _ (others)
                add_four(dp[i][j], dp[i][i + 1], dp[i + 2][j], data[i:j + 1])
                # (others) _ (last two)
                add_four(dp[i][j], dp[i][j - 2], dp[j - 1][j], data[i:j + 1])
            i += 1
            j += 1

    return not 100 in dp[0][n - 1]


if __name__ == '__main__':
    assert checkio('000000') == True, "All zeros"
    assert checkio('707409') == True, "You can not transform it to 100"
    assert checkio('595347') == False, "(5 + ((9 / (3 / 34)) - 7)) = 100"
    assert checkio('271353') == False, "(2 - (7 * (((1 / 3) - 5) * 3))) = 100"
    assert checkio('000955') == False, "(0 + (0 + (0 + (95 + 5)))) = 100"
    assert checkio('836403') == False, "(8 * ((3 / 6) + (4 * 03))) = 100"
