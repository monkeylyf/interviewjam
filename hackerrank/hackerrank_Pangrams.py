"""hackerrank_Pangrams.py

https://www.hackerrank.com/contests/101aug14/challenges/pangrams
"""

from string import letters


def solve(sentence):
    tokens = sentence.split()
    letter_set = set(''.join(tokens))
    for letter in letters[:26]:
        if letter not in letter_set:
            return False
    return True


def main():
    sentence = raw_input().lower()

    if solve(sentence):
        print 'pangram'
    else:
        print 'not pangram'


if __name__ == '__main__':
    main()
