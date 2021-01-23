# https://leetcode.com/problems/score-of-parentheses/

class Solution:
    def scoreOfParentheses(self, S: str) -> int:
        if not S:
            return 0
        if len(S) == 2:
            return 1

        s = []
        for c in S:
            if c == '(':
                s.append(c)
            else:
                if s[-1] != '(':
                    val = s.pop() * 2
                    s.pop()  # Pop '('
                    while s and s[-1] != '(':
                        val += s.pop()
                    s.append(val)
                else:
                    s.pop()
                    c = 1
                    while s and s[-1] != '(':
                        c += s.pop()
                    s.append(c)
        return s[0]


def main():
    sol = Solution()
    print(sol.scoreOfParentheses("(()(()))") == 6)
    print(sol.scoreOfParentheses("()()") == 2)
    print(sol.scoreOfParentheses("()") == 1)
    print(sol.scoreOfParentheses("(())") == 2)


if __name__ == '__main__':
    main()
