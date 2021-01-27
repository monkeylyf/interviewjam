# https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

class Solution:
    def findTheLongestSubstringBestAnswerEver(self, s):
        seen = {0: -1}
        res = cur = 0
        for i, c in enumerate(s):
            cur ^= 1 << ('aeiou'.find(c) + 1) >> 1
            seen.setdefault(cur, i)
            res = max(res, i - seen[cur])
        return res

    def findTheLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        mark = [True] * 5
        # Potential state compression.
        indiecs = {'a': 0, 'e': 1, 'i': 2, 'o': 3, 'u': 4}
        seen = {'11111': -1}
        longest = 0
        for i, c in enumerate(s):
            index = indiecs.get(c)
            if index is not None:
                mark[index] = not mark[index]
            sig = ''.join('1' if m else '0' for m in mark)
            prev = seen.get(sig)
            if prev is None:
                seen[sig] = prev = i

            if i - prev > longest:
                longest = i - prev

        return longest


def main():
    sol = Solution()
    s = "eleetminicoworoep"
    print(sol.findTheLongestSubstring(s) == 13)
    s = "leetcodeisgreat"
    print(sol.findTheLongestSubstring(s) == 5)
    s = "ixzhsdka"
    print(sol.findTheLongestSubstring(s) == 6)


if __name__ == '__main__':
    main()
