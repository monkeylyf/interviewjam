"""Remove Invalid Parentheses
leetcode

Remove the minimum number of invalid parentheses in order to make the input
string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
"""


class Solution(object):

    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        container = []
        self.rec(0, 0, s, container, ('(', ')'))
        return container

    def rec(self, last_i, last_j, s, container, parentheses):
        """"""
        left, right = parentheses
        open_left_parenthese = 0
        i = last_i
        while i < len(s):
            if s[i] == left:
                open_left_parenthese += 1
            elif s[i] == right:
                open_left_parenthese -= 1
            else:
                pass
            if open_left_parenthese < 0:
                # Right parentheses outnumbers left paretheses.
                break
            i += 1
        if open_left_parenthese < 0:
            # Invalid detected.
            j = last_j
            while j <= i:
                # Find the a right parenthese to remove. Note that for some
                # consecutive right parentheses, only pick one for next level
                # recrusion to avoid dups
                if (j == last_j or s[j - 1] != right) and s[j] == right:
                    self.rec(i, j, s[:j] + s[j + 1:], container, parentheses)
                j += 1
        else:
            # Valid, but need to test it again in reversed order.
            reversed_s = ''.join(reversed(s))
            if left == '(':
                self.rec(0, 0, reversed_s, container, (')', '('))
            else:
                container.append(reversed_s)


def main():
    sol = Solution()
    assert sol.removeInvalidParentheses("()())()") == ['(())()', '()()()']


if __name__ == '__main__':
    main()
