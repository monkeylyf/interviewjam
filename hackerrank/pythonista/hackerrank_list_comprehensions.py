"""hackerrank_list_comprehensions.py

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/list-comprehensions
"""

def main():
    x = int(raw_input())
    y = int(raw_input())
    z = int(raw_input())
    n = int(raw_input())

    print [[i, j, h] for i in xrange(x + 1)
                     for j in xrange(y + 1)
                     for h in xrange(z + 1)
                     if i + j + h != n ]


if __name__ == '__main__':
    main()
