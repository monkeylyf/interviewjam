# https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        left = 0
        chars = list(s)
        # Scan left to right.
        for i, c in enumerate(chars):
            if c == '(':
                left += 1
            elif c == ')':
                if left > 0:
                    left -= 1
                else:
                    chars[i] = ''
            else:
                pass

        right = 0
        i = len(chars) - 1
        # Scan right to left.
        while i >= 0:
            c = chars[i]
            if c == ')':
                right += 1
            elif c == '(':
                if right > 0:
                    right -= 1
                else:
                    chars[i] = ''
            else:
                pass
            i -= 1

        return ''.join(chars)


def main():
    sol = Solution()
    print(sol.minRemoveToMakeValid('lee(t(c)o)de)') == 'lee(t(c)o)de')
    print(sol.minRemoveToMakeValid('a)b(c)d') == 'ab(c)d')
    print(sol.minRemoveToMakeValid('))((') == '')


if __name__ == '__main__':
    main()
