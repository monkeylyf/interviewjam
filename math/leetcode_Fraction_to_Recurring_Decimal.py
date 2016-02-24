"""Fraction to recurssing decimal
leetcode

Given two integers representing the numerator and denominator of a fraction,
return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
"""


class Solution(object):
    def fractionToDecimal(self, numerator, denominator):
        """
        :type numerator: int
        :type denominator: int
        :rtype: str
        """
        # Hanlde negativity.
        negaitve = (numerator < 0 and denominator) > 0 or \
                   (numerator > 0 and denominator) < 0
        numerator = abs(numerator)
        denominator = abs(denominator)
        left = str(numerator / denominator)
        numerator = numerator % denominator

        if numerator != 0:
            # Handle dot part
            mapping = {}
            has_seen = False
            idx = 0
            digits = []
            while numerator != 0 and not has_seen:
                digits.append(str(numerator * 10 / denominator))
                mapping[numerator] = idx
                numerator = numerator * 10 % denominator
                has_seen = numerator in mapping
                idx += 1
            digits = ''.join(digits)
            if has_seen:
                # Handle repeated pattern
                idx = mapping[numerator]
                digits = digits[:idx] + '(' + digits[idx:] + ')'
            ret = left + '.' + digits
        else:
            ret = left

        return '-' + ret if negaitve else ret


def main():
    sol = Solution()
    assert sol.fractionToDecimal(2, 3) == '0.(6)'
    assert sol.fractionToDecimal(2, 1) == '2'
    assert sol.fractionToDecimal(1, 2) == '0.5'
    assert sol.fractionToDecimal(1, 6) == '0.1(6)'
    assert sol.fractionToDecimal(-50, 8) == '-6.25'
    # print sol.fractionToDecimal(1, 214748364)


if __name__ == '__main__':
    main()
