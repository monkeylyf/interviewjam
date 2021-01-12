# https://leetcode.com/problems/complex-number-multiplication/

class Solution:
    def complexNumberMultiply(self, a: str, b: str) -> str:
        def parse(number):
            (aa, bb) = number.split('+')
            return int(aa), int(bb[:-1])

        i, ii  = parse(a)
        h, hh = parse(b)
        return f'{i * h - ii * hh}+{i * hh + ii * h}i'


def main():
    sol = Solution()
    print(sol.complexNumberMultiply('1+1i', '1+1i'))
    print(sol.complexNumberMultiply('1+-1i', '1+-1i'))


if __name__ == '__main__':
    main()
