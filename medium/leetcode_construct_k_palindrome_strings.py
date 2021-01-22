# https://leetcode.com/problems/construct-k-palindrome-strings/

from collections import Counter

class Solution:
    def canConstruct(self, s: str, k: int) -> bool:
        n = len(s)
        if k > n:
            return False
        if k == n:
            return True
        c = Counter(s)
        odds = sum(1 for i in c.values() if i % 2 == 1)
        return k >= odds


def main():
    sol = Solution()
    print(sol.canConstruct('annabelle', 2) == True)
    print(sol.canConstruct('leetcode', 3) == True)
    print(sol.canConstruct('true', 4) == True)
    print(sol.canConstruct('yzyzyzyzyzyzyzy', 2) == True)
    print(sol.canConstruct('cr', 7) == True)


if __name__ == '__main__':
    main()
