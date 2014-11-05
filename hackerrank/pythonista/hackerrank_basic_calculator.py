"""hackerrank_basic_calculator

https://www.hackerrank.com/contests/pythonista-practice-session/challenges/basic-calculator
"""


def main():
    a = float(raw_input())
    b = float(raw_input())

    template = '{0:.2f}'

    print template.format(a + b)
    print template.format(a - b)
    print template.format(a * b)
    print template.format(a / b)
    print template.format(a // b)


if __name__ == '__main__':
    main()
