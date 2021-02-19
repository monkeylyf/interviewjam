# https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

class Solution:
    def minOperations(self, s: str) -> int:
        odds = 0
        evens = 0
        for i, c in enumerate(reversed(s)):
            if c == '1':
                if i % 2 == 0:
                    evens += 1
                else:
                    odds += 1
        n = len(s)
        return min(n // 2 - odds + evens, (n + 1) // 2 - evens + odds )


    def minOperationsSlow(self, s: str) -> int:
        n = len(s)
        i = 0
        a = 0
        while i < n:
            a = a ^ (1 << i)
            i += 2
        b = 0
        i = 1
        while i < n:
            b = b ^ (1 << i)
            i += 2

        val = int(s, 2)

        aa = val ^ a
        bb = val ^ b

        a_count = 0
        b_count = 0
        while aa > 0:
            a_count += aa & 1
            aa = aa >> 1

        while bb > 0:
            b_count += bb & 1
            bb = bb >> 1

        return min(a_count, b_count)


def main():
    sol = Solution()
    print(sol.minOperations("0100") == 1)
    print(sol.minOperations("10") == 0)
    print(sol.minOperations("1111") == 2)
    print(sol.minOperations("101101111"))


if __name__ == '__main__':
    main()
