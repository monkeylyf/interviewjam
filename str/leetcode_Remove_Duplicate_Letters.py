"""Remove duplicate letters
leetcode

Given a string which contains only lowercase letters, remove duplicate letters
so that every letter appear once and only once. You must make sure your result
is the smallest in lexicographical order among all possible results.
"""

from string import ascii_lowercase


class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        # char to index mapping. 0-based.
        mapping = {c: ord(c) - ord('a') for c in ascii_lowercase}
        counter = [0] * 26
        used = [False] * 26
        for char in s:
            idx = mapping[char]
            counter[idx] += 1

        stack = []
        for char in s:
            idx = mapping[char]
            counter[idx] -= 1
            if used[idx]:
                continue

            # Keep stack monotone increasing at best effort.
            # If current char is smaller the top of stack, and top of stack char
            # will still be seen later, replace it with current char.
            while stack and stack[-1] > char and counter[mapping[stack[-1]]] > 0:
                removed_c = stack.pop()
                used[mapping[removed_c]] = False

            used[idx] = True
            stack.append(char)

        return ''.join(stack)


def main():
    sol = Solution()
    assert sol.removeDuplicateLetters('cbacdcbc') == 'acdb'
    assert sol.removeDuplicateLetters('bcabc') == 'abc'


if __name__ == '__main__':
    main()
