"""Flip Game
leetcode

You are playing the following Flip Game with your friend: Given a string that
contains only these two characters: + and -, you and your friend take turns to
flip two consecutive "++" into "--". The game ends when a person can no longer
make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid
move.

For example, given s = "++++", after one move, it may become one of the following
states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
"""


class Solution(object):
    def generatePossibleNextMoves(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        container = []
        ls = list(s)
        for i in xrange(len(s) - 1):
            if s[i] == '+' and s[i + 1] == '+':
                ls[i] = '-'
                ls[i + 1] = '-'
                container.append(''.join(ls))
                ls[i] = '+'
                ls[i + 1] = '+'
        return container


def main():
    sol = Solution()
    assert sol.generatePossibleNextMoves("++++") == ['--++', '+--+', '++--']
    assert sol.generatePossibleNextMoves("--") == []


if __name__ == '__main__':
    main()
