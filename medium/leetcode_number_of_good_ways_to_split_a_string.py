# https://leetcode.com/problems/number-of-good-ways-to-split-a-string/

class Solution:
    def numSplits(self, s: str) -> int:
        left = [0] * 26
        left_unique_count = 0
        right = [0] * 26
        right_unique_count = 0
        for c in s:
            i = ord(c) - 97
            right[i] += 1
            if right[i] == 1:
                right_unique_count += 1

        res = 0
        for c in s:
            i = ord(c) - 97
            left[i] += 1
            if left[i] == 1:
                left_unique_count += 1
            right[i] -= 1
            if right[i] == 0:
                right_unique_count -= 1
            if left_unique_count == right_unique_count:
                res += 1
        return res




def main():
    sol = Solution()
    print(sol.numSplits('aacaba'))


if __name__ == '__main__':
    main()
