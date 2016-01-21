"""Integer to English word.
leetcode

2147483647
Convert a non-negative integer to its english words representation. Given input
is guaranteed to be less than 2^31 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
"""


class Solution(object):

    SINGLE_DIGITS = {
        '0': '',
        '1': 'One',
        '2': 'Two',
        '3': 'Three',
        '4': 'Four',
        '5': 'Five',
        '6': 'Six',
        '7': 'Seven',
        '8': 'Eight',
        '9': 'Nine',
    }

    TENS = {
        '10': 'Ten',
        '11': 'Eleven',
        '12': 'Twelve',
        '13': 'Thirteen',
        '14': 'Fourteen',
        '15': 'Fifteen',
        '16': 'Sixteen',
        '17': 'Seventeen',
        '18': 'Eighteen',
        '19': 'Nineteen',
    }

    TEN_DIGIT = {
        '2': 'Twenty',
        '3': 'Thirty',
        '4': 'Forty',
        '5': 'Fifty',
        '6': 'Sixty',
        '7': 'Seventy',
        '8': 'Eighty',
        '9': 'Ninety',
    }

    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        def three_digits_to_str(num):
            """Convert digits num to str.

            :param num: str, with length no more than 3.
            """
            if len(num) == 0:
                return ''
            elif len(num) == 1:
                num = '00' + num
            elif len(num) == 2:
                num = '0' + num
            elif len(num) == 3:
                pass
            else:
                raise ValueError(num)

            ret = []
            if num[0] != '0':
                ret.append(Solution.SINGLE_DIGITS[num[0]])
                ret.append('Hundred')

            if num[1] != '0':
                #if ret:
                #    ret.append('And')
                if num[1] == '1':
                    ret.append(Solution.TENS[num[1:]])
                else:
                    ret.append(Solution.TEN_DIGIT[num[1]])
                    ret.append(Solution.SINGLE_DIGITS[num[2]])
            else:
                ret.append(Solution.SINGLE_DIGITS[num[2]])

            return ' '.join(token for token in ret if token)

        if num == 0:
            return 'Zero'
        num_str = str(num)
        n = len(num_str)
        segments = []

        segments.append(three_digits_to_str(num_str[-3:]))

        thousand = three_digits_to_str(num_str[-6:-3])
        if thousand:
            segments.append('Thousand')
            segments.append(thousand)
        million = three_digits_to_str(num_str[-9:-6])
        if million:
            segments.append('Million')
            segments.append(million)

        billion = three_digits_to_str(num_str[-12:-9])
        if billion:
            segments.append('Billion')
            segments.append(billion)

        return ' '.join(segments[i] for i in reversed(xrange(len(segments))) if segments[i])


def main():
    sol = Solution()
    #print sol.numberToWords(2147483647)
    assert sol.numberToWords(20) == 'Twenty'
    assert sol.numberToWords(123) == 'One Hundred Twenty Three'
    assert sol.numberToWords(12345) == 'Twelve Thousand Three Hundred Forty Five'
    assert sol.numberToWords(1234567) == "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"



if __name__ == '__main__':
    main()
