"""hackerrank_validate_list_of_email_with_filter.py

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/validate-list-of-email-address-with-filter
"""

import re

def main():
    n = int(raw_input())
    email_addrs = []
    for _ in xrange(n):
        email_addrs.append(raw_input())

    email_pat = r'[^@]+@[^@]+\.[^@]{1,3}'
    print sorted(filter(lambda x : re.search(email_pat, x), email_addrs))


if __name__ == '__main__':
    main()
