# https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

# A string is a valid parentheses string (denoted VPS) if it meets one of the
# following:
# It is an empty string "", or a single character not equal to "(" or ")",
# It can be written as AB (A concatenated with B), where A and B are VPS's, or
# It can be written as (A), where A is a VPS.
# We can similarly define the nesting depth depth(S) of any VPS S as follows:
#
# depth("") = 0
# depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
# depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
# depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
# For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1,
# and 2), and ")(" and "(()" are not VPS's.
#
# Given a VPS represented as string s, return the nesting depth of s.
# Example 1:
# Input: s = "(1+(2*3)+((8)/4))+1"
# Output: 3
# Explanation: Digit 8 is inside of 3 nested parentheses in the string.
#
# Example 2:
# Input: s = "(1)+((2))+(((3)))"
# Output: 3
#
# Example 3:
# Input: s = "1+(2*3)/(2-1)"
# Output: 1
#
# Example 4:
# Input: s = "1"
# Output: 0
#
# Constraints:
# 1 <= s.length <= 100
# s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
# It is guaranteed that parentheses expression s is a VPS.

class Solution:
    def maxDepth(self, s: str) -> int:
        left = 0
        right = 0
        depth = None
        acc = 0
        for c in s:
            if c == '(':
                left += 1
                acc += 1
            elif c == ')':
                right += 1
                acc -= 1
            else:
                pass
            if right > left:
                return 0

            if depth is None or acc > depth:
                depth = acc

        if right == left:
            return depth
        else:
            return 0


def main():
    sol = Solution()
    print(sol.maxDepth("(1)+((2))+(((3)))"))
    print(sol.maxDepth("(1+(2*3)+((8)/4))+1"))
    print(sol.maxDepth("1+(2*3)/(2-1)"))

if __name__ == '__main__':
    main()
