# https://leetcode.com/problems/palindromic-substrings/

class Solution:
    def countSubstrings(self, s: str) -> int:
        if not s:
            return 0

        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]
        count = 0

        for step in range(n + 1):
            for i in range(n - step):
                j = i + step
                if step == 0:
                    dp[i][i] = True
                elif step == 1:
                    dp[i][i + 1] = s[i] == s[i + 1]
                else:
                    dp[i][j] = s[i] == s[j] and dp[i + 1][j - 1]

                if dp[i][j]:
                    count += 1
        return count
