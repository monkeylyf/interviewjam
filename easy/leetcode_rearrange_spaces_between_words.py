# https://leetcode.com/problems/rearrange-spaces-between-words/

class Solution:
    def reorderSpaces(self, text: str) -> str:
        words = []
        prev = 0
        seen_c = False
        spaces = 0
        for (i, c) in enumerate(text):
            if c == ' ':
                spaces += 1
                if seen_c:
                    words.append(''.join(text[prev:i]))
                    seen_c = False
                prev = i + 1
            else:
                seen_c = True
        if seen_c:
            words.append(''.join(text[prev:len(text)]))

        total_words = len(words)
        if total_words == 0:
            return ''
        if total_words == 1:
            return words[0] + ' ' * spaces

        (div, mod) = divmod(spaces, total_words - 1)

        res = []
        for (i, word) in enumerate(words):
            res.append(word)
            if i < len(words) - 1:
                res.append(' ' * div)

        if mod:
            res.append(' ' * mod)
        return ''.join(res)


def main():
    sol = Solution()
    print(sol.reorderSpaces("  this   is  a sentence "))
    print(sol.reorderSpaces(" practice   makes   perfect"))
    print(sol.reorderSpaces("hello    world"))


if __name__ == '__main__':
    main()
