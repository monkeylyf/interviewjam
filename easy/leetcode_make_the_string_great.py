# https://leetcode.com/problems/make-the-string-great/

class Solution:
    def makeGood(self, s: str) -> str:
        stack = []
        for c in s:
            if not stack:
                stack.append(c)
            else:
                prev = stack[-1]

                if (prev.lower() == c .lower()) and \
                        ((prev.isupper() and c.islower()) or (prev.islower() and c.isupper())):
                    stack.pop()
                else:
                    stack.append(c)
        return ''.join(stack)


def main():
    sol = Solution()
    print(sol.makeGood("bC"))


if __name__ == '__main__':
    main()
