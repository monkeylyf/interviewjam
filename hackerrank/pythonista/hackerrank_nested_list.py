"""hackerrank_nested_list

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/nested-list
"""


def main():
    n = int(raw_input())

    scores = {}
    for _ in xrange(n):
        name = raw_input()
        score = float(raw_input())
        try:
            scores[score].append(name)
        except KeyError:
            scores[score] = [name]

    keys = sorted(scores.keys())
    second_lowest = keys[1]
    for name in sorted(scores[second_lowest]):
        print name


if __name__ == '__main__':
    main()
