"""hackerrank_regex2_validate_a_roman_number

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/regex-2-validate-a-roman-number
"""

import re


def main():
    roman = raw_input()
    # Shameless stole from Diveintoipyton3
    pat = """
    ^                   # beginning of string
    M{0,3}              # thousands - 0 to 3 Ms
    (CM|CD|D?C{0,3})    # hundreds - 900 (CM), 400 (CD), 0-300 (0 to 3 Cs),
                        #            or 500-800 (D, followed by 0 to 3 Cs)
    (XC|XL|L?X{0,3})    # tens - 90 (XC), 40 (XL), 0-30 (0 to 3 Xs),
                        #        or 50-80 (L, followed by 0 to 3 Xs)
    (IX|IV|V?I{0,3})    # ones - 9 (IX), 4 (IV), 0-3 (0 to 3 Is),
                        #        or 5-8 (V, followed by 0 to 3 Is)
    $                   # end of string
    """
    print 'True' if re.search(pat, roman, re.VERBOSE) else 'False'


if __name__ == '__main__':
    main()
