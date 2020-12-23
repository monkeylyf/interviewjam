# https://leetcode.com/problems/goal-parser-interpretation/

# You own a Goal Parser that can interpret a string command. The command
# consists of an alphabet of "G", "()" and/or "(al)" in some order. The
# Goal Parser will interpret "G" as the string "G", "()" as the string
# "o", and "(al)" as the string "al". The interpreted strings are then
# concatenated in the original order.
#
# Given the string command, return the Goal Parser's interpretation of command.
#
# Example 1:
# Input: command = "G()(al)"
# Output: "Goal"
# Explanation: The Goal Parser interprets the command as follows:
# G -> G
# () -> o
# (al) -> al
# The final concatenated result is "Goal".

# Example 2:
# Input: command = "G()()()()(al)"
# Output: "Gooooal"

# Example 3:
# Input: command = "(al)G(al)()()G"
# Output: "alGalooG"
#
# Constraints:
# 1 <= command.length <= 100
# command consists of "G", "()", and/or "(al)" in some order.

class Solution:
    def interpret(self, command: str) -> str:
        res = []
        prev_left_parenthisis_index = 0
        for (i, char) in enumerate(command):
            if char == 'G':
                res.append('G')
            elif char == '(':
                prev_left_parenthisis_index = i
            elif char == ')':
                if prev_left_parenthisis_index + 1 == i:
                    res.append('o')
                else:
                    res.append(command[prev_left_parenthisis_index + 1:i])
            else:
                pass

        return ''.join(res)


def main():
    sol = Solution()
    print(sol.interpret("G()(al)"))


if __name__ == '__main__':
    main()
