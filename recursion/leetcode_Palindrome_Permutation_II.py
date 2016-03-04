"""Palindrome Permutation
leetcode


Given a string s, return all the palindromic permutations (without duplicates)
of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].
Given s = "abc", return [].
"""


from collections import Counter


class Solution(object):
    def generatePalindromes(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        counter = Counter(s)
        tokens = []
        odd_char = None
        for char, freq in counter.iteritems():
            if freq % 2 != 0:
                if odd_char is not None:
                    # More than one char appears odd time make it no palindrome
                    return []
                else:
                    odd_char = char
            tokens.extend([char] * (freq / 2))
        container = set()
        permutations = []
        visited = [False] * len(tokens)
        self.recurse(tokens, visited, [], container, len(tokens))
        for prefix in container:
            if odd_char:
                permutations.append('{}{}{}'.format(''.join(prefix), odd_char, ''.join(reversed(prefix))))
            else:
                permutations.append('{}{}'.format(''.join(prefix), ''.join(reversed(prefix))))

        return permutations

    def recurse(self, tokens, visited, acc, container, n):
        """All combination given tokens."""
        if n == len(acc):
            container.add(''.join(acc))
        else:
            for i, token in enumerate(tokens):
                if not visited[i]:
                    visited[i] = True
                    acc.append(token)
                    self.recurse(tokens, visited, acc, container, n)
                    acc.pop()
                    visited[i] = False

                while i < len(tokens) - 1 and tokens[i] == tokens[i + 1]:
                    i += 1


def main():
    sol = Solution()
    assert sol.generatePalindromes('aabb') == ['abba', 'baab']
    assert sol.generatePalindromes('abc') == []
    assert sol.generatePalindromes('aabbc') == ['abcba', 'bacab']
    assert sol.generatePalindromes('aacbbbb') == ['abbcbba', 'babcbab', 'bbacabb']
    assert sol.generatePalindromes('aaa') == ['aaa']


if __name__ == '__main__':
    main()
