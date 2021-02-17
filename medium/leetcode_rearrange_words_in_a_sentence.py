# https://leetcode.com/problems/rearrange-words-in-a-sentence/

from functools import cmp_to_key

class Solution:
    def arrangeWords(self, text: str) -> str:
        if not text:
            return text

        def comparator(a, b):
            aa, i = a
            bb, j = b
            a_len = len(aa)
            b_len = len(bb)
            if a_len == b_len:
                return (i > j) - (j < i)
            else:
                return (a_len > b_len) - (a_len < b_len)

        text = text.lower()
        tokens = [(t, i) for i, t in enumerate(text.split())]
        tokens.sort(key=cmp_to_key(comparator))

        return ' '.join(t[0].capitalize() if i == 0 else t[0] for i, t in enumerate(tokens))


def main():
    sol = Solution()
    text = "Keep calm and code on"
    print(sol.arrangeWords(text))


if __name__ == '__main__':
    main()
