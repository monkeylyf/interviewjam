# https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/

class Solution:
    def isPrefixOfWord(self, sentence: str, searchWord: str) -> int:
        prev = 0
        word_count = 1
        n = len(searchWord)
        m = len(sentence)
        i = 0
        while i < m:
            val = sentence[i]
            if i - prev == n and sentence[prev:prev + n] == searchWord:
                return word_count
            if val == ' ':
                #print(sentence[prev:i])
                word_count += 1
                prev = i + 1
            i += 1
        return word_count if sentence[prev:i] == searchWord else -1



def main():
    sol = Solution()
    print(sol.isPrefixOfWord("this problem is an easy problem", "pro"))
    print(sol.isPrefixOfWord("i use triple pillow", "pillow"))


if __name__ == '__main__':
    main()
