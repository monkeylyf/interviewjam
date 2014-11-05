"""hackerrank_regex1_validating_the_phone_number

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/regex-1-validating-the-phone-number
"""

import re

def main():
    n = int(raw_input())
    pat = r'^[7-9]([0-9]{9})$'
    for _ in xrange(n):
        number = raw_input()
        print 'YES' if re.search(pat, number) else 'NO'


if __name__ == '__main__':
    main()
