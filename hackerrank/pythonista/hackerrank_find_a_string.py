"""hackerrank_find_a_string.py

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/find-a-string
"""

def main():
    s = raw_input()
    needle = raw_input()

    count = 0
    s_len = len(s)
    needle_len = len(needle)
    for i in xrange(s_len - needle_len + 1):
        if s[i: i + needle_len] == needle:
            count += 1

    print count


if __name__ == '__main__':
    main()
