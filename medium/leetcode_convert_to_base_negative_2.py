# https://leetcode.com/problems/convert-to-base-2/

class Solution:
    def baseNeg2(self, n: int) -> str:
        if n == 0:
            return "0"
        res = []
        while n != 0:
            res.append(n & 1)
            n = -(n >> 1)
        return "".join(map(str, reversed(res)))

    def baseNeg2Slow(self, n: int) -> str:
        bits = []
        while n > 0:
            div, mod = divmod(n, 2)
            bits.append(mod)
            n = div
        i = 0
        carry = False
        length = len(bits)
        while i < length:
            bit = bits[i]
            if carry:
                if bit == 0:
                    bit = 1
                    carry = False
                else:
                    bit = 0
                    carry = True

            if i % 2 == 1:
                if bit == 1:
                    carry = True
            bits[i] = bit
            i += 1

        if carry:
            bits.append(1)
            if i % 2 == 1:
                bits.append(1)

        return ''.join(map(str, reversed(bits)))


def main():
    sol = Solution()
    print(sol.baseNeg2(2) == '110')
    print(sol.baseNeg2(3) == '111')
    print(sol.baseNeg2(4) == '100')
    print(sol.baseNeg2(6) == '11010')


if __name__ == '__main__':
    main()
