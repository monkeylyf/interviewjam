"""Maximum product of word lengths
leetcode

"""

class Solution(object):
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        length = 0
        masks = [0] * len(words)
        base = ord('a')
        # Calculate bit masks for a word.
        for i, word in enumerate(words):
            for char in word:
                bit = 1 << (ord(char) - base)
                masks[i] = masks[i] | bit

        for i in xrange(len(words)):
            for j in xrange(i, len(words)):
                if masks[i] & masks[j] == 0:
                    length = max(length, len(words[i]) * len(words[j]))
        return length


def main():
    sol = Solution()
    assert sol.maxProduct(["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]) == 16
    assert sol.maxProduct(["a", "ab", "abc", "d", "cd", "bcd", "abcd"]) == 4
    assert sol.maxProduct(["a", "aa", "aaa", "aaaa"]) == 0

if __name__ == '__main__':
    main()
