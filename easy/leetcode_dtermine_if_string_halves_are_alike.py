# https://leetcode.com/problems/determine-if-string-halves-are-alike/

class Solution:
    def halvesAreAlike(self, s: str) -> bool:
        vowels = set(('a', 'e', 'i', 'o', 'u'))
        count = 0
        n = len(s) // 2
        for i, c in enumerate(s):
            if c.lower() in vowels:
                if i < n:
                    count += 1
                else:
                    count -= 1
        return count == 0


def main():
    sol = Solution()
    print(sol.halvesAreAlike('tkPAdxpMfJiltOerItiv'))


if __name__ == '__main__':
    main()
