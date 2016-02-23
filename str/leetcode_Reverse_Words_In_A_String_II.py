"""Reverse words in a string
leetcode

Given an input string, reverse the string word by word. A word is defined as a
sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are
always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
"""


class Solution(object):

    def reverseWords(self, s):
        """
        :type s: a list of 1 length strings (List[str])
        :rtype: nothing
        """
        self.swap(0, len(s) - 1, s)
        head = 0
        i = 0
        for i, char in enumerate(s):
            if char == ' ':
                self.swap(head, i - 1, s)
                head = i + 1
        self.swap(head, i, s)

    def swap(self, head, tail, s):
        while head < tail:
            s[head], s[tail] = s[tail], s[head]
            head += 1
            tail -= 1


def main():
    sol = Solution()
    words = list('the sky is blue')
    sol.reverseWords(words)
    assert ''.join(words) == 'blue is sky the'


if __name__ == '__main__':
    main()
