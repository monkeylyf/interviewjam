# https://leetcode.com/problems/maximum-score-after-splitting-a-string/

class Solution:
    def maxScore(self, s: str) -> int:
        max_value = 0
        left = 0
        right = s.count('1')
        for i in s:
            if i == '0':
                left += 1
            else:
                right -= 1
            max_value = max(max_value, left + right)

        return max_value


def main():
    sol = Solution()
    print(sol.maxScore("011101"))


if __name__ == '__main__':
    main()
