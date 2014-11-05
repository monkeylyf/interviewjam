"""hackerran_finding_the_percentage

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/finding-the-percentage
"""


def main():
    n = int(raw_input())

    scores = {}
    for _ in xrange(n):
        line = raw_input().split()
        name = line[0]
        maths, physics, chemistry = map(float, line[1:])
        scores[name] = (maths + physics + chemistry) / 3

    name = raw_input()
    print '{0:.2f}'.format(scores[name])



if __name__ == '__main__':
    main()
