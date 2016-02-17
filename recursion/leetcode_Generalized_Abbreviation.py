"""Generalized abbreviation
leetcode

Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
"w1r1", "1o2", "2r1", "3d", "w3", "4"]
"""

class Solution(object):
    def generateAbbreviations(self, word):
        """
        :type word: str
        :rtype: List[str]
        """
        container = []
        self.dfs(0, [], word, container)
        return container

    def dfs(self, i, acc, word, container):
        if i == len(word):
            container.append(''.join(str(c) for c in acc))
        else:
            # Do not convert char into number.
            acc.append(word[i])
            self.dfs(i + 1, acc, word, container)
            acc.pop()

            # Convert char into number.
            if acc and not isinstance(acc[-1], basestring):
                # Accumulate with previous number.
                acc[-1] = acc[-1] + 1
                self.dfs(i + 1, acc, word, container)
            else:
                # No previous number. Add first 1.
                acc.append(1)
                self.dfs(i + 1, acc, word, container)
                acc.pop()


def main():
    sol = Solution()
    print sol.generateAbbreviations('word')


if __name__ == '__main__':
    main()
