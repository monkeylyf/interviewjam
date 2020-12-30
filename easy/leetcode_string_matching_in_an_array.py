# https://leetcode.com/problems/string-matching-in-an-array/

from typing import List

class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        words.sort(key=len)
        n = len(words)
        chosen = [False] * n
        for i in range(1, n):
            superword = words[i]
            for j in range(i):
                if chosen[j]:
                    continue
                if words[j] in superword:
                    chosen[j] = True
        return [words[i] for (i, val) in enumerate(chosen) if val]



def main():
    sol = Solution()
    print(sol.stringMatching(["mass","as","hero","superhero"]))


if __name__ == '__main__':
    main()
